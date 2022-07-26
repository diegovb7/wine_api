package com.wine_api.wine_api.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.wine_api.wine_api.repository.RegionRepository;
import com.wine_api.wine_api.repository.WineRepository;
import com.wine_api.wine_api.repository.TypeRepository;
import com.wine_api.wine_api.repository.WineryRepository;
import com.wine_api.wine_api.wines.Region;
import com.wine_api.wine_api.wines.Type;
import com.wine_api.wine_api.wines.Wine;
import com.wine_api.wine_api.wines.Winery;

@WebMvcTest
class WineApiControllerTest {
    
    @MockBean
    private WineRepository wineRepository;
    private RegionRepository regionRepository;
    private TypeRepository TypeRepository;
    private WineryRepository WineryRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllWines() throws Exception{

        //Wine(String name, String year, Float rating, Integer num_reviews, Float price, String body,
        //String acidity, Winery winery, Type type, Region region)

        Wine wine1 = new Wine("Wine1", "2000", new Float(4.5),
            new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery1"), new Type("Duro"), new Region("España", "Europa"));

        Wine wine2 = new Wine("Wine2", "2002", new Float(4.5),
            new Integer(4), new Float(6.7), "NA", "NA", new Winery("Winery2"), new Type("Duro2"), new Region("España", "Europa"));
        
        Mockito.when(wineRepository.findAll()).thenReturn(Arrays.asList(wine1, wine2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/wine"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1));
    }

    @Test
    void test(){
        
    }
}
