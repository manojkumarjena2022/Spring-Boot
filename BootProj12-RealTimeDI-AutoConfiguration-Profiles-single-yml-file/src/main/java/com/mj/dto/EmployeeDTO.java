package com.mj.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class EmployeeDTO implements Serializable {
	private Integer srNo;
	private Integer empNo;
	private String ename;
	private String job;
	private Integer mgr;
	private String hireDate;
	private Double sal;
	private Double comm;
	private Integer deptNo;
}
