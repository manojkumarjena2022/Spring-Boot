package com.mj.controller;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/demo")
public class RequestPathsController {
	@Autowired
	private ServletContext sc;
	@Autowired
	private ServletConfig cg;
	@Autowired
	private HttpSession hs;
	
	/*@RequestMapping("/")
	public String showHome()
	{
		return "home";
	}*/
	/*@RequestMapping
	public String showHome()
	{
		return "home";
	}*/
	/*@RequestMapping(method = RequestMethod.GET)
	public String showHome()
	{
		return "home";
	}*/
	@GetMapping
	public String showHome()
	{
		return "home";
	}
	
	
	/*@RequestMapping("/REPORT")
	public String showReport()
	{
		System.out.println("RequestPathsController.showReport()");
		return "display_report";
	}
	
	@RequestMapping("/report")
	public String showReport1()
	{
		System.out.println("RequestPathsController.showReport1()");
		return "display_report1";
	}*/
	
	
	/*@RequestMapping(value = "/report",method = RequestMethod.GET)
	public String showReport()
	{
		System.out.println("RequestPathsController.showReport()");
		return "display_report";
	}
	
	@RequestMapping(value = "/report",method = RequestMethod.POST)
	public String showReport1()
	{
		System.out.println("RequestPathsController.showReport1()");
		return "display_report1";
	}*/
	/*@GetMapping("/report")
	public String showReport()
	{
		System.out.println("RequestPathsController.showReport()");
		return "display_report";
	}
	
	@PostMapping("/report")
	public String showReport1()
	{
		System.out.println("RequestPathsController.showReport1()");
		return "display_report1";
	}*/
	
	/*@GetMapping({"/report","/report1","/report2"})
	public String showReport()
	{
		System.out.println("RequestPathsController.showReport()");
		return "display_report";
	}*/
	
	/*@GetMapping(value={"/report"})
	public String showReport()
	{
		System.out.println("RequestPathsController.showReport()");
		return "display_report1";
	}*/
	/*@RequestMapping("/report")
	public String showReport()
	{
		System.out.println("RequestPathsController.showReport()");
		System.out.println("Web App Name :: "+sc.getContextPath());
		System.out.println("DS Logical name :: "+cg.getServletName());
		System.out.println("Session Id :: "+hs.getId());
		return "display_report1";
	}*/
	/*Web App Name :: /BootMVCProj3-RequestPaths
	DS Logical name :: dispatcherServlet
	Session Id :: 12A52B5668AB012AA8536C458A1AB82D*/
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map,HttpSession session)
	{
		System.out.println("Session Id :: "+session.getId());
		return "display_report1";
	}


}
