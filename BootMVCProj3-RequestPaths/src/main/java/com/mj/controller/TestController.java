package com.mj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
	/*@RequestMapping
	public String showHome()
	{
		return "home";
	}*/
	/*@RequestMapping(method = RequestMethod.POST)
	public String showHome()
	{
		return "home";
	}*/
	@PostMapping
	public String showHome()
	{
		return "home";
	}
	
	@GetMapping(value={"/report"})
	public String generateReport()
	{
		System.out.println("TestController.generateReport()");
		return "display_report";
	}
}
