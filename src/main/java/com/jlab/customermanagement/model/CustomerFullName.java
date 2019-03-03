package com.jlab.customermanagement.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class CustomerFullName {

	@Size(max=200)
	@Column(name = "FIRST_NAME")
	@NotNull
	private String firstName;

	@Nullable
	@Size(max=200)	
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@NotNull
	@Size(max=200)		
	@Column(name = "LAST_NAME")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
