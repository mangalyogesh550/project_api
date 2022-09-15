package com.project.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.entity.CountyEntity;
import com.project.api.service.impl.CountyServiceImpl;




@SpringBootApplication
public class ProjectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(CountyServiceImpl countyServiceImpl){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CountyEntity>> typeReference = new TypeReference<List<CountyEntity>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/project.json");
			try {
				List<CountyEntity> countyDetail = mapper.readValue(inputStream,typeReference);
				countyServiceImpl.addCountyList(countyDetail);
				System.out.println("All County  List Saved!");
			} catch (IOException e){
				System.out.println("Unable to save list: " + e.getMessage());
			}
	    };
	}

}
