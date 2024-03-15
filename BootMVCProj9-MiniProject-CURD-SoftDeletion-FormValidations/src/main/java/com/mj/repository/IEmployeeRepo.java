package com.mj.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mj.model.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer>{

}
