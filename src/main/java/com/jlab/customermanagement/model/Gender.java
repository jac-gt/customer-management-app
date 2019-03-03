package com.jlab.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	NOT_SPECIFIED("Not Specified", 0), MALE("Male", 1), FEMALE("Female", 2);

	private String gender;
	private final int value;

	private Gender(String gender, int value) {
		this.setGender(gender);
		this.value = value;
	}
	
	 @JsonValue
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getValue() {
		return value;
	}

}
