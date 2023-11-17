package com.mj.service;

import java.util.List;

import com.mj.dto.EmployeeDTO;

public interface IEmployeeService {
	public List<EmployeeDTO> fetchEmpByDesgs(String cond) throws Exception;
}
