package com.jlab.customermanagement.service.impl;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jlab.customermanagement.exceptions.CustomerNotFoundException;
import com.jlab.customermanagement.repo.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerBusinessServiceImplTest {

	@InjectMocks
	private CustomerBusinessServiceImpl customerService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	private CustomerRepository custRepo;

	@Test
	public void getNonExistantCustomerThrowsException_test() {

		thrown.expect(CustomerNotFoundException.class);
		thrown.expectMessage("Customer with id 1 not found.");

		long customerId = 1;

		when(custRepo.findById(customerId)).thenReturn(Optional.empty());

		customerService.one(customerId);

	}

}
