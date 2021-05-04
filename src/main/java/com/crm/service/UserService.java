package com.crm.service;

import java.util.Set;

import com.crm.domain.User;
import com.crm.domain.security.UserRole;



public interface UserService {
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
}
