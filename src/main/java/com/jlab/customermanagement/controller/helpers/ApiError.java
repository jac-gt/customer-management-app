package com.jlab.customermanagement.controller.helpers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public List<String> getErrors() {
		return errors;
	}

}
