package com.mj.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mj.model.Cricketer;
import com.mj.service.ICricketerMgmtService;

@Controller
public class CricketerController {
	@Autowired
	private ICricketerMgmtService service;
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	@GetMapping("/register")
	public String showRegisterCricketerForm(@ModelAttribute Cricketer cricketer)
	{
		return "register_cricketer";
	}
	@PostMapping("/register")
	public String registerCricketer(@ModelAttribute Cricketer cricketer,Map<String,Object> map)
	{
		String result=service.registerCricketer(cricketer);
		map.put("resultMsg", result);
		return "show_result";
	}
	@InitBinder
	public void myInitBinder(WebDataBinder binder)
	{
		System.out.println("CricketerController.myInitBinder()");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor=new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(java.util.Date.class, editor);
	}
}
