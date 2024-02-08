package com.mj.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.Emp;
@Service("empService")
public class EmpMgmtImpl implements IEmpMgmtService {
	@Autowired
	EntityManager manager;
	@Override
	public List<Emp> serachEmpsByDesgs(String desg1, String desg2) {
		//create storedProcedure object representing our PL/SQl procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("GET_EMPDETAILS_BY_DESGS", Emp.class);
		//register parameters of PL/SQL procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		//set values to parameter
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);
		//call PL/SQL procedure
		List<Emp> list=query.getResultList();
		return list;
	}
}

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_EMPDETAILS_BY_DESGS`(IN desg1 varchar(10),IN desg2 varchar(10))
BEGIN
SELECT empno,ename,job,sal from emp where job in(desg1,desg2) order by job;
END*/