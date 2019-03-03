package com.jlab.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MaritalStatus {
	NOT_SPECIFIED("Not Specified", 0), MARRIED("Married", 1), SINGLE("Single", 2);

	private String status;
	private final int value;

	private MaritalStatus(String status, int value) {
		this.setStatus(status);
		this.value = value;
	}
	
	 @JsonValue
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getValue() {
		return value;
	}
	
}
