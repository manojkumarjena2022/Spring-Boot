package com.mj.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	private String ename;
	private String eaddrs="Odisha";
	private Double salary=8000.0;
	
	public Employee()
	{
		System.out.println("Employee.Employee()");
	}
}
