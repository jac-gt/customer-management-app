package com.jlab.customermanagement.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jlab.customermanagement.model.converters.BooleanToStringConverter;
import com.jlab.customermanagement.model.validators.CustomerAddress;
import com.jlab.customermanagement.model.validators.FullName;

@Entity
@Table(name = "CUSTOMERS")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private long id;

	@Embedded
	@FullName
	private CustomerFullName fullName;

	@Nullable
	@Column(name = "INITIALS")
	@Size(max = 10)
	private String initials;

	@NotNull
	@Column(name = "TITLE")
	private Title title;

	@NotNull
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	@CustomerAddress
	private Set<Address> address;

	@NotNull
	@Column(name = "GENDER")
	private Gender sex;

	@NotNull
	@Column(name = "MARITAL_STATUS")
	private MaritalStatus maritalStatus;

	@NotNull
	@Min(value = 0, message = "Credit Rating must between 0 and 100")
	@Max(value = 100, message = "Credit Rating must between 0 and 100")
	private int creditRating;

	@Column(name = "NAB_CUSTOMER")
	@NotNull
	@Convert(converter = BooleanToStringConverter.class)
	private boolean nabCustomer;

	public Customer() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public int getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}

	public boolean getNabCustomer() {
		return nabCustomer;
	}

	public void setNabCustomer(boolean nabCustomer) {
		this.nabCustomer = nabCustomer;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public CustomerFullName getFullName() {
		return fullName;
	}

	public void setFullName(CustomerFullName fullName) {
		this.fullName = fullName;
	}
}
