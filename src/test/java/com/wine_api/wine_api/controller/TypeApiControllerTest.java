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
import com.wine_api.wine_api.service.TypeService;
import com.wine_api.wine_api.wines.Type;

@WebMvcTest(TypeController.class)
class TypeApiControllerTest {

	@MockBean
	private TypeService typeService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getAllTypesTest() throws Exception {
		Type type1 = new Type("Blanco");
		Type type2 = new Type("Rojo");

		Mockito.when(typeService.getAll()).thenReturn(Arrays.asList(type1, type2));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/type"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("Rojo"));

	}

	@Test
	void getTypeTest() throws Exception {
		Type type1 = new Type(1, "Blanco");

		Mockito.when(typeService.getTypeById(1)).thenReturn(type1);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/type/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("Blanco"));

	}

	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void saveTypeTest() throws Exception {
		Type type1 = new Type(1, "Blanco");

		Mockito.when(typeService.createType(Mockito.any(Type.class))).thenReturn(type1);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(type1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/type/")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("Blanco"));
	}

	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void updateTypeTest() throws Exception {
		Type type1 = new Type(1, "Blanco");

		Mockito.when(typeService.updateType(Mockito.any(Type.class))).thenReturn(type1);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(type1);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/api/type/")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("Blanco"));
	}

}
