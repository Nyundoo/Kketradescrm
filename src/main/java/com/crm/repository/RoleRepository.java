package com.crm.repository;

import org.springframework.data.repository.CrudRepository;

import com.crm.domain.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
