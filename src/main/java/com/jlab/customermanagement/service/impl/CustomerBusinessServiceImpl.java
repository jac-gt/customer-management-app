package com.jlab.customermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlab.customermanagement.exceptions.CustomerNotFoundException;
import com.jlab.customermanagement.model.Customer;
import com.jlab.customermanagement.repo.CustomerRepository;
import com.jlab.customermanagement.service.CustomerService;

@Service
public class CustomerBusinessServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer save(Customer customer) {
		return repo.save(customer);
		
	}
	
	@Override
	public List<Customer> all() {	
		return repo.findAll();
	}

	@Override
	public Customer one(long id) {
		return repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	
}
