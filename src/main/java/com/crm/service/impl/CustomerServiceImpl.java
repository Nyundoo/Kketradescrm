package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.domain.Customer;
import com.crm.repository.CustomerRepository;
import com.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public  Customer save( Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List< Customer> findAll() {
		return (List< Customer>) customerRepository.findAll();
	}
	
	public  Customer findOne(Long id) {
		return customerRepository.findById(id).get();
	}		
	
	public void removeOne(long id) {
		customerRepository.deleteById(id);
		
	}

}
