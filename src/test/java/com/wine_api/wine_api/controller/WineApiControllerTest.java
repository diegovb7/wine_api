package com.wine_api.wine_api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wine_api.wine_api.service.WineService;
import com.wine_api.wine_api.wines.Region;
import com.wine_api.wine_api.wines.Type;
import com.wine_api.wine_api.wines.Wine;
import com.wine_api.wine_api.wines.Winery;

@WebMvcTest(WineController.class)
class WineApiControllerTest {
  
    @MockBean
    private WineService wineService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllWinesTest() throws Exception{

        //Wine(String name, String year, Float rating, Integer num_reviews, Float price, String body,
        //String acidity, Winery winery, Type type, Region region)

        Wine wine1 = new Wine("Wine1", "2000", new Float(4.5),
            new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery1"), new Type("Duro"), new Region("España", "Europa"));

        Wine wine2 = new Wine("Wine2", "2002", new Float(4.5),
            new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery2"), new Type("Duro2"), new Region("España", "Europa"));
        
        Mockito.when(wineService.getAll()).thenReturn(Arrays.asList(wine1, wine2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/wine"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].name").value("Wine1"));
    }
    
    @Test
	void getWineTest() throws Exception {
    	Wine wine1 = new Wine("Wine1", "2000", new Float(4.5),
                new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery1"), new Type("Duro"), new Region("España", "Europa"));

		Mockito.when(wineService.getWineById(1)).thenReturn(wine1);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/wine/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("Wine1"));
	}
    
    @Test
    @WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void saveWineTest() throws Exception {
    	Wine wine1 = new Wine("Wine1", "2000", new Float(4.5),
                new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery1"), new Type("Duro"), new Region("España", "Europa"));

		Mockito.when(wineService.createWine(Mockito.any(Wine.class))).thenReturn(wine1);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(wine1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/wine/")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType("application/json;"));
	}
    
    @Test
    @WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void updateWineTest() throws Exception {
    	Wine wine1 = new Wine("Wine1", "2000", new Float(4.5),
                new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery1"), new Type("Duro"), new Region("España", "Europa"));

		Mockito.when(wineService.updateWine(Mockito.any(Wine.class))).thenReturn(wine1);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(wine1);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/api/wine/")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType("application/json;"));
	}	
}

