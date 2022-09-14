package com.project.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CountyDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private long id;

	private String fips;

	private String state;

	private String name;

}
