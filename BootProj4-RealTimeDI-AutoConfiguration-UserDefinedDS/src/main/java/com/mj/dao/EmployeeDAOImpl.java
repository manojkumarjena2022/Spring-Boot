package com.mj.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mj.bo.EmployeeBO;
@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP WHERE JOB IN";
	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmpsByDesg(String condition) throws Exception {
		System.out.println("Datasource class name :"+ds.getClass());
		//System.out.println(GET_EMPS_BY_DESGS+"("+condition+")"+" ORDER BY JOB");
		List<EmployeeBO> listBO=new ArrayList<EmployeeBO>();
		try(
				//get pooled connection obj
				Connection con=ds.getConnection();
				Statement st=con.createStatement();
				//send and execute sql query to db s/w
				ResultSet result=st.executeQuery(GET_EMPS_BY_DESGS+"("+condition+")"+" ORDER BY JOB");
		) {
			
			//converts rs object records to List of BO class objs
			EmployeeBO bo=null;
			while (result.next()) {
				//copy each record of RS to obj of EmployeeBO list collection
				bo=new EmployeeBO();
				bo.setEmpNo(result.getInt(1));
				bo.setEname(result.getString(2));
				bo.setJob(result.getString(3));
				bo.setMgr(result.getInt(4));
				bo.setHireDate(result.getString(5));
				bo.setSal(result.getDouble(6));
				bo.setComm(result.getDouble(7));
				bo.setDeptNo(result.getInt(8));
				//add each EmployeeBO to List collection
				listBO.add(bo);
			}//while
		}//try  //con,st object will be closed here
		catch (SQLException se) {
			se.printStackTrace();
			throw se;//for exception propagation
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}//method
}//class
