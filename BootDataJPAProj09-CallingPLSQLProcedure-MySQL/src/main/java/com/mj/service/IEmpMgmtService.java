package com.mj.service;

import java.util.List;

import com.mj.entity.Emp;

public interface IEmpMgmtService {
	public List<Emp> serachEmpsByDesgs(String desg1,String desg2);
}
