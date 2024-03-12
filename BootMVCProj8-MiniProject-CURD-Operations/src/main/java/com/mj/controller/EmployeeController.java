package com.mj.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mj.model.Employee;
import com.mj.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	@GetMapping("/emp_report")
	public String showEmpReport(Map<String, Object> map)
	{
		Iterable<Employee> empList = service.getAllEmployee();
		map.put("empList", empList);
		return "emp_report";
	}
	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(Map<String, Object> map,@ModelAttribute("emp")Employee emp)
	{
		return "add_employee";
	}

	/*@PostMapping("/insert_employee")
	public String insertEmployee(Map<String, Object> map,@ModelAttribute("emp")Employee emp)
	{
		String result=service.addEmployee(emp);
		Iterable<Employee> empList=service.getAllEmployee();
		map.put("resultMsg", result);
		map.put("empList", empList);
		return "emp_report";
	}*/
	
	/*@PostMapping("/insert_employee")
	public String insertEmployee(Map<String, Object> map,@ModelAttribute("emp")Employee emp)
	{
		String result=service.addEmployee(emp);
		map.put("resultMsg", result);
		return "redirect:emp_report";
	}*/
	
	@PostMapping("/insert_employee")
	public String insertEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp)
	{
		String result=service.addEmployee(emp);
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:emp_report";
	}
	
	/*@PostMapping("/insert_employee")
	public String insertEmployee(HttpSession session,@ModelAttribute("emp")Employee emp)
	{
		String result=service.addEmployee(emp);
		session.setAttribute("resultMsg", result);
		return "redirect:emp_report";
	}*/
	
	@GetMapping("/edit_employee")
	public String showEditEmployeeForm(Map<String, Object> map,@RequestParam("eno")Integer id,@ModelAttribute("emp")Employee emp)
	{
		//System.out.println("eno :"+id);
		Employee emp1=service.fetchEmployeeByEmpno(id);
		//System.out.println(emp1);
		BeanUtils.copyProperties(emp1, emp);
		return "edit_employee";
	}
	/*@PostMapping("/edit_employee")
	public String updateEmployee(Map<String, Object> map,@ModelAttribute("emp")Employee emp)
	{
		String result=service.updateEmployee(emp);
		Iterable<Employee> empList=service.getAllEmployee();
		map.put("resultMsg", result);
		map.put("empList", empList);
		return "emp_report";
	}*/
	@PostMapping("/edit_employee")
	public String updateEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp)
	{
		String result=service.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:emp_report";
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam("eno")Integer id)
	{
		String result=service.deleteEmployeeByEmpno(id);
		//attrs.addAttribute("resultMsg", result);
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:emp_report";
	}
	
}
