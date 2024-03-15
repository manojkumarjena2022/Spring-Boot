package com.mj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mj.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployee();
	public Page<Employee> getPageableEmployees(Pageable pageable);
	public String addEmployee(Employee emp);
	public String updateEmployee(Employee emp);
	public Employee fetchEmployeeByEmpno(Integer empno);
	public String deleteEmployeeByEmpno(Integer empno);
}
