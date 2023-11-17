package com.mj.dao;

import java.util.List;

import com.mj.bo.EmployeeBO;

public interface IEmployeeDAO {
public List<EmployeeBO> getEmpsByDesg(String condition) throws Exception;
}
