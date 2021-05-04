package com.crm.repository;

import org.springframework.data.repository.CrudRepository;

import com.crm.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
