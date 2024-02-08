package com.mj.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CoronaVaccine;
@Service("vaccineService")
public class VaccineMgmt implements IVaccineMgmt {
	@Autowired
	EntityManager manager;
	@Override
	public List<CoronaVaccine> serachVaccinesByPriceRange(Double min, Double max) {
		//create storedProcedure object representing our PL/SQl procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_VACCINES_BY_PRICERANGE", CoronaVaccine.class);
		//register parameters of PL/SQL procedure
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, CoronaVaccine.class, ParameterMode.REF_CURSOR);
		//set values to parameter
		query.setParameter(1, min);
		query.setParameter(2, max);
		//call PL/SQL procedure
		List<CoronaVaccine> list=query.getResultList();
		return list;
	}
	@Override
	public String authenticate(String uname, String password) {
		//create StoredProcedure object representing our PL/SQL
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_AUTHENTICATE");
		//register parameters of PL/SQL procedure
		query.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class, ParameterMode.OUT);
		//set parameter value
		query.setParameter(1, uname);
		query.setParameter(2, password);
		//call the procedure
		query.execute();
		//get result of out parameter
		String result=(String) query.getOutputParameterValue(3);
		return result;
	}
	@Override
	public Object[] getEmpDetailsByEmpNo(Integer empNo) {
		//unwrap session
		Session ses=manager.unwrap(Session.class);
		//write plain jdbc to call PL/SQL
		Object[] obj=ses.doReturningWork(con->{
			//create Callable statement obj
			CallableStatement cs=con.prepareCall("{?=call FX_GET_EMP_DETAILS(?,?,?,?)}");
			//register return,out parameter
			cs.registerOutParameter(1, Types.INTEGER);//return param(?1)
			cs.registerOutParameter(3, Types.VARCHAR);//return param(?3)
			cs.registerOutParameter(4, Types.VARCHAR);//return param(?4)
			cs.registerOutParameter(5, Types.FLOAT);//return param(?5)
			//set value for IN param
			cs.setInt(2, empNo);
			//call PL/SQL function
			cs.execute();
			//gather results from return, out params
			Object[] objs=new Object[4];
			objs[0]=cs.getInt(1);
			objs[1]=cs.getString(3);
			objs[2]=cs.getString(4);
			objs[3]=cs.getFloat(5);
			return objs;
		});
		return obj;
	}

}
/*
 CREATE OR REPLACE PROCEDURE P_GET_VACCINES_BY_PRICERANGE 
(
  STARTPRICE IN NUMBER 
, ENDPRICE IN NUMBER 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  open DETAILS FOR
  SELECT REG_NO,NAME,COMPANY,COUNTRY,PRICE,REQUIRED_DOSE_COUNT FROM corona_vaccine WHERE price>=STARTPRICE AND price<=ENDPRICE;
END P_GET_VACCINES_BY_PRICERANGE;

 */


/*create or replace NONEDITIONABLE PROCEDURE P_AUTHENTICATE 
(
  USER_NAME IN VARCHAR2 
, PASS IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
RES_COUNT NUMBER(5);
BEGIN
  SELECT COUNT(*) INTO RES_COUNT FROM STUDENT WHERE USERNAME=USER_NAME AND PASSWORD=PASS;
  IF(RES_COUNT<>0) THEN
    RESULT:='VALID CREDENTIAL';
  ELSE
    RESULT:='INAVALID CREDENTIAL';
  END IF;
END P_AUTHENTICATE;*/


/*CREATE OR REPLACE FUNCTION FX_GET_EMP_DETAILS 
(
  ENO IN NUMBER 
, NAME OUT VARCHAR2 
, DESG OUT VARCHAR2 
, SALARY OUT NUMBER 
) RETURN NUMBER AS 
DNO NUMBER(3);
BEGIN
  SELECT ENAME,JOB,SAL,DEPTNO INTO NAME,DESG,SALARY,DNO FROM EMP WHERE EMPNO=ENO;
  RETURN DNO;
END FX_GET_EMP_DETAILS;*/