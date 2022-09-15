package com.project.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProjectApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	private Object fieldValue;

	public ProjectApiException(String resourceName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

}
