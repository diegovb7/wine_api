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
import com.wine_api.wine_api.service.RegionService;
import com.wine_api.wine_api.wines.Region;

@WebMvcTest(RegionController.class)
class RegionApiControllerTest {

	@MockBean
	private RegionService regionService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getAllRegionsTest() throws Exception {
		Region region1 = new Region("España", "Europa");
		Region region2 = new Region("Francia", "Europa");

		Mockito.when(regionService.getAll()).thenReturn(Arrays.asList(region1, region2));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/region"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("Francia"));

	}

	@Test
	void getRegionTest() throws Exception {
		Region region1 = new Region("España", "Europa");

		Mockito.when(regionService.getRegionById(1)).thenReturn(region1);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/region/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("España"));

	}

	@Test
	@WithMockUser(username = "user", password = "1234", roles = { "USER" })
	void saveRegionTest() throws Exception {
		Region region1 = new Region("España", "Europa");

		Mockito.when(regionService.createRegion(Mockito.any(Region.class))).thenReturn(region1);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(region1);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/region/").content(json)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("España"));
	}

	@Test
	@WithMockUser(username = "user", password = "1234", roles = { "USER" })
	void updateRegionTest() throws Exception {
		Region region1 = new Region(135, "España", "Europa");

		Mockito.when(regionService.updateRegion(Mockito.any(Region.class))).thenReturn(region1);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(region1);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/region/").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("España"));
	}

}
