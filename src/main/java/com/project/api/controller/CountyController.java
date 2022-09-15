package com.project.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.entity.CountyEntity;
import com.project.api.service1.CountyService;

@RestController
@RequestMapping(value = "/county")
public class CountyController {
	
	@Autowired
	CountyService countyService;

	@PostMapping(value = "/details")
	public ResponseEntity<CountyEntity> add(@RequestBody CountyEntity countyEntity) throws IOException {
		return new ResponseEntity<CountyEntity>(countyService.addCounty(countyEntity), HttpStatus.CREATED);
	}

	@GetMapping(value = "/details")
	public List<CountyEntity> getAllCounty() {
		return countyService.getAllCounty();

	}

	@GetMapping(value = "/details/{name}")
	public ResponseEntity<CountyEntity> getCountyByName(@PathVariable("name") String name) {
		return new ResponseEntity<CountyEntity>(countyService.getByName(name), HttpStatus.FOUND);
	}

	@GetMapping(value = "/details/{state}")
	public ResponseEntity<List<CountyEntity>> getCountyByState(@PathVariable("state") String state) {
		return new ResponseEntity<List<CountyEntity>>(countyService.getByState(state), HttpStatus.FOUND);
	}

}
