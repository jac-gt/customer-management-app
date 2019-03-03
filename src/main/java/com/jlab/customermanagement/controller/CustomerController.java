package com.jlab.customermanagement.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jlab.customermanagement.model.Customer;
import com.jlab.customermanagement.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * POST Mapping for creating customer
	 * 
	 * @param customer
	 * @return Response Entity with location or error
	 */
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		Customer newCustomer = customerService.save(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	/**
	 * Function to get details for a given customer id
	 * 
	 * @param id Id of the customer
	 * @return Details of the customer
	 */
	@GetMapping("/customers/{customerId}")
	public Customer one(@PathVariable long customerId) {
		return customerService.one(customerId);
	}

	/**
	 * 
	 * Function to get details for all customers
	 * 
	 * @return
	 */
	@GetMapping("/customers")
	public List<Customer> all() {
		return customerService.all();
	}

}
