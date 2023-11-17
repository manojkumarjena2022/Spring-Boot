package com.mj.bo;

import lombok.Data;

@Data
public class EmployeeBO {
	private Integer empNo;
	private String ename;
	private String job;
	private Integer mgr;
	private String hireDate;
	private Double sal;
	private Double comm;
	private Integer deptNo;
}
