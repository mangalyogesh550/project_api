package com.project.api.service1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.api.entity.CountyEntity;

@Service
public interface CountyService {
	public CountyEntity addCounty(CountyEntity countyEntity);

	public List<CountyEntity> addCountyList(List<CountyEntity> countyEntity);

	public List<CountyEntity> getAllCounty();

	public CountyEntity getByName(String name);

	public List<CountyEntity> getByState(String state);

}
