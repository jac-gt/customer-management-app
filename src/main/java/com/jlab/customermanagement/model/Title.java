package com.jlab.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Title {
	NOT_SPECIFIED("Not Specified", 0), MR("Mr", 1), MRS("Mrs", 2), MASTER("Master", 3),
	MISS("Miss",4);
	
	private String title;
	private final int value;

	private Title(String status, int value) {
		this.setStatus(status);
		this.value = value;
	}
	
	 @JsonValue
	public String getTitle() {
		return title;
	}

	public void setStatus(String title) {
		this.title = title;
	}

	public int getValue() {
		return value;
	}
}
