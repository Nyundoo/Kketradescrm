package com.crm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.service.CustomerService;

@RestController
public class ResourceController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer/removeList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> customerIdList, Model model
			){
		
		for (String id : customerIdList) {
			String customerId =id.substring(8);
			customerService.removeOne(Long.parseLong(customerId));
		}
		
		return "delete success";
	}
}
