package com.mj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mj.entity.Employee;

@Controller
public class TestController {
	@RequestMapping("/")
	public String showHome(Map<String, Object> map)
	{
		System.out.println("TestController.showHome()");
		return "home";
	}

	@RequestMapping("/report")
	public String showReport(Map<String, Object> map)
	{
		System.out.println("TestController.showReport()");
		map.put("name", "Manoj");
		map.put("age", 28);
		map.put("salary", 27000.0);
		map.put("mrgStatus", true);
		return "report";
	}
	
	@RequestMapping("/report1")
	public String showReport1(Map<String, Object> map)
	{
		System.out.println("TestController.showReport1()");
		String[] nickNameArray=new String[]{"MJ","Kumar","MJ Kumar"};
		Set<Long> mobileNosSet=new HashSet();
		mobileNosSet.add(8765454345L);
		mobileNosSet.add(9878787878L);
		List<String> courseList=new ArrayList();
		courseList.add("Core Java");
		courseList.add("Spring Boot");
		Map<String, Long> idsMap=new HashMap();
		idsMap.put("aadhar", 876564564567L);
		idsMap.put("pan", 87654564L);
		
		map.put("nickNameArray", nickNameArray);
		map.put("mobileNosSet", mobileNosSet);
		map.put("courseList", courseList);
		map.put("idsMap", idsMap);
		
		return "report1";
	}
	
	@RequestMapping("/report2")
	public String showReport2(Map<String, Object> map)
	{
		System.out.println("TestController.showReport2()");
		List<Employee> employeeList=List.of(new Employee(123L, "MJ Kumar", "Lead Developer",27700.0),
				new Employee(122L, "Manoj", "Developer", 7650.0),
				new Employee(124L, "MJ", "Tester", 8950.0));
		
		map.put("employeeList", employeeList);
		
		return "report2";
	}
	
	@RequestMapping("/report3")
	public String showReport3(Map<String, Object> map)
	{
		System.out.println("TestController.showReport3()");
		Employee employee=new Employee(123L, "MJ Kumar", "Lead Developer",27700.0);
		
		map.put("employee", employee);
		
		return "report3";
	}
}
