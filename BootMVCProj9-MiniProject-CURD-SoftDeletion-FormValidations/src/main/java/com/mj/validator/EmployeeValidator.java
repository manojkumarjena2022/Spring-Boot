package com.mj.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mj.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("EmployeeValidator.supports()");
		//wheather handler method is passing correct command class object or not
		//if not throws exception
		//return Employee.class==clazz;
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		Employee emp=(Employee)target;
		//server side form validation logic
		if(emp.getEname()==null || emp.getEname().isBlank())
			errors.rejectValue("ename", "emp.ename.rquired");
		else if(emp.getEname().length()<5)
			errors.rejectValue("ename", "emp.ename.minlength");
		
		if(emp.getJob()==null || emp.getJob().isBlank())
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<5)
			errors.rejectValue("job", "emp.job.minlength");
		
		//System.out.println("emp.getDeptno():"+emp.getDeptno());
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno", "emp.deptno.required");
		else if(((Float)emp.getDeptno().floatValue()).isNaN())
			errors.rejectValue("deptno", "emp.deptno.numeric");
		else if(emp.getDeptno()<5 || emp.getDeptno()>13)
			errors.rejectValue("deptno", "emp.deptno.range");
		
		//System.out.println("emp.getSal():"+emp.getSal());
		if(emp.getSal()==null)
			errors.rejectValue("sal", "emp.sal.required");
		else if(emp.getSal().isNaN())
			errors.rejectValue("sal", "emp.sal.numeric");
		else if(emp.getSal()<10000 || emp.getSal()>100000)
			errors.rejectValue("sal", "emp.sal.range");
	}

}
