package com.jlab.customermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
