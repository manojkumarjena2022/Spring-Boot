package com.mj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mj.service.IWishMessageGeneratorService;

@Controller
public class WishMessageController {
	@Autowired
	IWishMessageGeneratorService service;

	@RequestMapping("/")
	public String showHome() {
		return "home";// LVN (Logical View Name)
	}

	/*@RequestMapping("/wish")
	public ModelAndView generateWishMessage()
	{
		//use service
		String result=service.generateWishMessage();
		//return MAV
		//ModelAndView mav=new ModelAndView();
		//mav.addObject("wMsg", result);
		//mav.setViewName("display");
		//return mav;
		return new ModelAndView("display", "wMsg", result);
	}*/
	
	/*@RequestMapping("/wish")
	public String generateWishMessage(BindingAwareModelMap map)
	{
		System.out.println(map.getClass());
		//use service
		String result=service.generateWishMessage();
		map.addAttribute("wMsg", result);
		return "display";
	}*/
	
	/*@RequestMapping("/wish")
	public String generateWishMessage(ModelMap map)
	{
		System.out.println("Class Name :: "+map.getClass());
		//use service
		String result=service.generateWishMessage();
		map.addAttribute("wMsg", result);
		return "display";
	}*/
	
	/*@RequestMapping("/wish")
	public String generateWishMessage(HashMap<String, Object> map)
	{
		System.out.println("Class Name :: "+map.getClass());
		//use service
		String result=service.generateWishMessage();
		map.put("wMsg", result);
		return "display";
	}*/
	
	//Recommended
	/*@RequestMapping("/wish")
	public String generateWishMessage(Map<String, Object> map)
	{
		System.out.println("Class Name :: "+map.getClass());
		//use service
		String result=service.generateWishMessage();
		map.put("wMsg", result);
		return "display";
	}*/
	
	/*@RequestMapping("/wish")
	public String generateWishMessage(Model model)
	{
		System.out.println("Class Name :: "+model.getClass());
		//use service
		String result=service.generateWishMessage();
		model.addAttribute("wMsg", result);
		return "display";
	}*/
	
	/*@RequestMapping("/wish")
	public void generateWishMessage(Model model)
	{
		System.out.println("Class Name :: "+model.getClass());
		//use service
		String result=service.generateWishMessage();
		model.addAttribute("wMsg", result);
	}*/
	
	/*@RequestMapping("/wish")
	public void generateWishMessage(Model model)
	{
		System.out.println("Class Name :: "+model.getClass());
		//use service
		String result=service.generateWishMessage();
		model.addAttribute("wMsg", result);
	}*/
	
	/*@RequestMapping("/wish")
	public Model generateWishMessage()
	{
		//use service
		String result=service.generateWishMessage();
		Model model=new ExtendedModelMap();
		System.out.println("Class Name :: "+model.getClass());
		model.addAttribute("wMsg", result);
		return model;
	}*/
	
	/*@RequestMapping("/wish")
	public Map<String, Object> generateWishMessage()
	{
		//use service
		String result=service.generateWishMessage();
		Map<String, Object> map=new HashMap();
		System.out.println("Class Name :: "+map.getClass());
		map.put("wMsg", result);
		return map;
	}*/
	
	@RequestMapping("/wish")
	public void generateWishMessage(HttpServletResponse response) throws IOException
	{
		//use service
		String result=service.generateWishMessage();
		//get printWriter object
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.write("<h1>wish message ::"+result+"</h1>");
		//return;
	}
}
