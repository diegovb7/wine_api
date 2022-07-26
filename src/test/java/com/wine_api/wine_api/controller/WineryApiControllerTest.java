package com.wine_api.wine_api.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;

import com.wine_api.wine_api.repository.WineryRepository;
import com.wine_api.wine_api.service.WineryService;
import com.wine_api.wine_api.wines.Winery;

@WebMvcTest(WineryController.class)
class WineryApiControllerTest {
	
	@MockBean
	private WineryService wineryService;
    //private WineryRepository wineryRepository;

    @Autowired
    private MockMvc mockMvc;

	@Test
	void getAllWineries() throws Exception{
		Winery winery1 = new Winery("Winery1");
		Winery winery2 = new Winery("Winery2");
		
		Mockito.when(wineryService.getAll()).thenReturn(Arrays.asList(winery1, winery2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/winery"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("Winery2"));
		
	}

}
