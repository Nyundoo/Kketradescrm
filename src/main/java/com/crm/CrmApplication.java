package com.crm;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crm.domain.User;
import com.crm.domain.security.Role;
import com.crm.domain.security.UserRole;
import com.crm.service.UserService;
import com.crm.utility.SecurityUtility;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("worker");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("worker"));
		user1.setEmail("worker@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(2);
		role1.setName("ROLE_WORKER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}
}
