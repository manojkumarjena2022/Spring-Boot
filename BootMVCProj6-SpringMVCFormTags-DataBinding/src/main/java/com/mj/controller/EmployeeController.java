package com.mj.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mj.model.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping
	public String showHome()
	{
		return "home";
	}
	
	@GetMapping("/register_emp")
	public String showRegisterForm(@ModelAttribute("emp") Employee emp)
	{
		return "register";
	}
	@PostMapping("/register_emp")
	public String registerEmployee(Map<String, Object> map,@ModelAttribute("emp") Employee employee)//@ModelAttribute Employee employee
	{
		System.out.println(employee);
		return "result";
	}
}
