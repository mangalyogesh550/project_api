package com.project.api.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
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

	@Test
	void addCountyListTest() {
		List<CountyEntity> counties = new ArrayList();
		CountyEntity countyEntity = new CountyEntity();
		countyEntity.setName("Test Name");
		counties.add(countyEntity);
		when(countyRepo.saveAll(counties)).thenReturn(counties);
		List<CountyEntity> counties1 = countyServiceImpl.addCountyList(counties);
		assertThat(counties.get(0).getName()).isSameAs(counties.get(0).getName());
		verify(countyRepo).saveAll(counties);
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

	// method2
	@Test
	void getAllCountyTest2() {
		List<CountyEntity> counties3 = new ArrayList<>();
		CountyEntity county = new CountyEntity();
		county.setName("test");
		counties3.add(county);

		when(countyRepo.findAll()).thenReturn(counties3);
		List<CountyEntity> cList = countyServiceImpl.getAllCounty();
		Assertions.assertEquals("test", cList.get(0).getName());
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
		List<CountyEntity> counties1 = new ArrayList();
		CountyEntity county = new CountyEntity();
		county.setState("test");
		when(countyRepo.findByState(county.getState())).thenReturn((List<CountyEntity>) counties1);
		List<CountyEntity> expected = countyServiceImpl.getByState(county.getState());
		assertThat(expected).isSameAs(counties1);
		verify(countyRepo).findByState(county.getState());
	}

}
