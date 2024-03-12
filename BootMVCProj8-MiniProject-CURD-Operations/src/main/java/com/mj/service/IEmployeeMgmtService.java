package com.mj.service;

import com.mj.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployee();
	public String addEmployee(Employee emp);
	public String updateEmployee(Employee emp);
	public Employee fetchEmployeeByEmpno(Integer empno);
	public String deleteEmployeeByEmpno(Integer empno);
}
