package com.project.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.api.entity.CountyEntity;
import com.project.api.repository.CountyRepo;
import com.project.api.service1.CountyService;

public class CountyServiceImpl implements CountyService {

	@Autowired
	CountyRepo countyRepo;

	@Override
	public CountyEntity addCounty(CountyEntity countyEntity) {
		return countyRepo.save(countyEntity);

	}

	@Override
	public List<CountyEntity> getAllCounty() {
		return countyRepo.findAll();

	}

	@Override
	public CountyEntity getByName(String name) {
		return countyRepo.findByName(name);
	}

	@Override
	public List<CountyEntity> getByState(String state) {
		return countyRepo.findByState(state);
	}

}
