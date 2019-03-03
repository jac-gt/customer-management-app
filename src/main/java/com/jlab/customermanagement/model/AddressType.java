package com.jlab.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AddressType {
	 MAIL("Mailing", 1), RESIDENCE("Residence", 2);

	private String type;
	private  int value;

	private AddressType(String type, int value) {
		this.type = type;
		this.value = value;
	}
	
	 @JsonValue
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

}
