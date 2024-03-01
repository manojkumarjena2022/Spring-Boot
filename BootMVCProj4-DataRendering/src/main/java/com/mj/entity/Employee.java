package com.mj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private Long eid;
	private String ename;
	private String desg;
	private Double salary;
}
