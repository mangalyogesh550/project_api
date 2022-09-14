package com.project.api.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.api.entity.CountyEntity;
import com.project.api.repository.CountyRepo;

public class CountyServiceImplTest {
	@Mock
	private CountyRepo countyRepo;

	@InjectMocks
	private CountyServiceImpl countyServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addCountyTest() {
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setName("Test Name");
		when(countyRepo.save(ArgumentMatchers.any(CountyEntity.class))).thenReturn(countyEntity);
		CountyEntity county = countyServiceImpl.addCounty(countyEntity);
		assertThat(county.getName()).isSameAs(countyEntity.getName());
		verify(countyRepo).save(countyEntity);
	}

	// method1
	@Test
	void getAllCountyTest() {
		List<CountyEntity> counties = new ArrayList();
		counties.add(new CountyEntity()); // this line can be removed not compulsory
		when(countyRepo.findAll()).thenReturn(counties);
		List<CountyEntity> expected = countyServiceImpl.getAllCounty();
		assertEquals(expected, counties);
		verify(countyRepo).findAll();
	}

	@Test
	public void getByNameTest() {
		CountyEntity county = new CountyEntity();
		county.setName("test");
		when(countyRepo.findByName(county.getName())).thenReturn(county);
		CountyEntity expected = countyServiceImpl.getByName(county.getName());
		assertThat(expected).isSameAs(county);
		verify(countyRepo).findByName(county.getName());
	}

	@Test
	public void getByStateTest() {
		CountyEntity county = new CountyEntity();
		county.setState("test");
		when(countyRepo.findByState(county.getState())).thenReturn((List<CountyEntity>) county);
		List<CountyEntity> expected = countyServiceImpl.getByState(county.getState());
		assertThat(expected).isSameAs(county);
		verify(countyRepo).findByName(county.getName());
	}

}
