package com.wine_api.wine_api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.wine_api.wine_api.service.WineryService;
import com.wine_api.wine_api.wines.Winery;

@WebMvcTest(WineryController.class)
class WineryApiControllerTest {

	@MockBean
	private WineryService wineryService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void getAllWineriesTest() throws Exception {
		Winery winery1 = new Winery("Winery1");
		Winery winery2 = new Winery("Winery2");

		Mockito.when(wineryService.getAll()).thenReturn(Arrays.asList(winery1, winery2));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/winery"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("Winery2"));

	}

	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void getWineryTest() throws Exception {
		Winery winery1 = new Winery(1, "Winery1");

		Mockito.when(wineryService.getWineryById(1)).thenReturn(winery1);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/winery/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("Winery1"));

	}

	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void saveWineryTest() throws Exception {
		Winery winery1 = new Winery(1, "Winery1");

		Mockito.when(wineryService.createWinery(Mockito.any(Winery.class))).thenReturn(winery1);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(winery1);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/winery/").content(json)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType("application/json;"));
	}

	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void updateWineryTest() throws Exception {
		Winery winery1 = new Winery(513, "Winery1");

		Mockito.when(wineryService.updateWinery(Mockito.any(Winery.class))).thenReturn(winery1);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(winery1);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/winery/").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType("application/json;"));
	}

}
