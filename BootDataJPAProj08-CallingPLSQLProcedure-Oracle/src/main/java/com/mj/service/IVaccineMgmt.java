package com.mj.service;

import java.util.List;

import com.mj.entity.CoronaVaccine;

public interface IVaccineMgmt {
	public List<CoronaVaccine> serachVaccinesByPriceRange(Double min,Double max);
	public String authenticate(String uname,String password);
	public Object[] getEmpDetailsByEmpNo(Integer empNo);
}
