package com.mj.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	private String ename;
	private String eaddrs;
	private Double salary;
	
	public Employee()
	{
		System.out.println("Employee.Employee()");
	}
}
