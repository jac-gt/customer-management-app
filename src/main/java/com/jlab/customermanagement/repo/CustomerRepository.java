package com.jlab.customermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jlab.customermanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
