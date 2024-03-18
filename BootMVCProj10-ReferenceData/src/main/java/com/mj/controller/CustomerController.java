package com.mj.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mj.model.Customer;
import com.mj.service.ICustomerMgmtService;

@Controller
public class CustomerController {
	@Autowired
	ICustomerMgmtService service;
	@GetMapping("/")
	public String showRegisterForm(@ModelAttribute("cust") Customer customer) {
		return "register_customer";
	}
	@PostMapping("/register_customer")
	public String registerCustomer(@ModelAttribute("cust") Customer customer,Map<String,Object> map) {
		return "result";
	}

	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries()
	{
		return service.getAllCountries();
	}
	@ModelAttribute("languageInfo")
	public Set<String> populateLanguages()
	{
		return service.getAllLanguages();
	}
	@ModelAttribute("hobbiesInfo")
	public Set<String> populateHobbies()
	{
		return service.getAllHobbies();
	}
}
