package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.domain.Customer;
import com.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCustomerPost(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		customerService.save(customer);

		return "redirect:customerList";
	}
	
	@RequestMapping("/customerList")
	public String customerList(Model model) {
		List<Customer> customerList = customerService.findAll();
		model.addAttribute("customerList", customerList);	
		return "customerList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		customerService.removeOne(Long.parseLong(id.substring(8)));
		List<Customer> customerList = customerService.findAll();
		model.addAttribute("customerList", customerList);
		
		return "redirect:/customer/customerList";
	}
	
	@RequestMapping("/customerInfo")
	public String customerInfo(@RequestParam("id") Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		
		return "customerInfo";
	}

	@RequestMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("id") Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		
		return "updateCustomer";
	}
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
	public String updateCustomerPost(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		customerService.save(customer);
		
		return "redirect:/customer/customerInfo?id="+customer.getId();
	}
}
