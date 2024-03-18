package com.mj.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mj.editor.LocalDateEditor;
import com.mj.editor.LocalDateTimeEditor;
import com.mj.editor.LocalTimeEditor;
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
	public String registerCricketer(@ModelAttribute Cricketer cricketer,Map<String,Object> map,BindingResult errors)
	{
		if (errors.hasErrors()) {
			return "register_cricketer";
		}
		String result=service.registerCricketer(cricketer);
		map.put("resultMsg", result);
		return "show_result";
	}
	@InitBinder
	public void myInitBinder(WebDataBinder binder)
	{
		System.out.println("CricketerController.myInitBinder()");
		binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(LocalTime.class, new LocalTimeEditor());
		binder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor());
	}
}
