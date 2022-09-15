package com.project.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.entity.CountyEntity;
import com.project.api.service1.CountyService;

@WebMvcTest(CountyController.class)
public class CountyControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CountyService countyService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testPostExample() throws Exception {
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setId(1);
		countyEntity.setName("newyork");
		Mockito.when(countyService.addCounty(ArgumentMatchers.any())).thenReturn(countyEntity);
		String json = mapper.writeValueAsString(countyEntity);
		mockMvc.perform(post("/county/detail").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.name", Matchers.equalTo("newyork")));
	}

	@Test
	public void testGetAllExample() throws Exception {
		List<CountyEntity> countiesEntity = new ArrayList();
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setId(1);
		countyEntity.setName("newyork");
		countiesEntity.add(countyEntity);
		Mockito.when(countyService.getAllCounty()).thenReturn(countiesEntity);
		mockMvc.perform(get("/county/details")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("newyork")));
	}

	@Test
	public void testGetByNameExample() throws Exception {
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setId(1);
		countyEntity.setName("newyork");
		Mockito.when(countyService.getByName(ArgumentMatchers.anyString())).thenReturn(countyEntity);
		String json = mapper.writeValueAsString(countyEntity);
		mockMvc.perform(get("/county/details/name/name").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.name", Matchers.equalTo("newyork")));
	}

	@Test
	public void testGetByStateExample() throws Exception {
		List<CountyEntity> counties = new ArrayList();
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setId(1);
		countyEntity.setName("newyork");
		counties.add(countyEntity);
		Mockito.when(countyService.getByState(ArgumentMatchers.anyString())).thenReturn(counties);
		String json = mapper.writeValueAsString(counties);
		mockMvc.perform(get("/county/details/state/state").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", Matchers.equalTo(1)))
				.andExpect(jsonPath("$.name", Matchers.equalTo("newyork")));
	}

}
