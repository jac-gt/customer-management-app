package com.jlab.customermanagement.service;

import java.util.List;
import java.util.Optional;

import com.jlab.customermanagement.model.Customer;

public interface CustomerService {

	public Customer save(Customer customer);
	
	public List<Customer> all();

	public Customer one(long id);

	public void delete(long customerId);

}
