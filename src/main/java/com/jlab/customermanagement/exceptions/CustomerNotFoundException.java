package com.jlab.customermanagement.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(Long id) {
		super("Customer with id " + id +" not found.");
	}

}