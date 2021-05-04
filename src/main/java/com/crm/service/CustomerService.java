package com.crm.service;

import java.util.List;

import com.crm.domain.Customer;

public interface CustomerService {
Customer save(Customer customer);
	
	List<Customer> findAll();
	
	Customer findOne(Long id);

	void removeOne(long id);
}
