package com.mj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mj.model.Employee;
import com.mj.repository.IEmployeeRepo;
@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo repo;
	@Override
	public Iterable<Employee> getAllEmployee() {
		return repo.findAll(Sort.by("job").descending());
	}
	@Override
	public String addEmployee(Employee emp) {
		return "Employee inserted with Id value :"+repo.save(emp).getEmpno();
	}
	@Override
	public String updateEmployee(Employee emp) {
		return repo.save(emp).getEmpno()+" Employee updated.";
	}
	@Override
	public Employee fetchEmployeeByEmpno(Integer empno) {
		return repo.findById(empno).get();
	}
	@Override
	public String deleteEmployeeByEmpno(Integer empno) {
		repo.deleteById(empno);
		return empno+" employee deleted.";
	}
	@Override
	public Page<Employee> getPageableEmployees(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
