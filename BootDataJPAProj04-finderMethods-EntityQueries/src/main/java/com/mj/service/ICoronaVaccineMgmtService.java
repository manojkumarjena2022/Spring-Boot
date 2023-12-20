package com.mj.service;

import java.util.List;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> fetchVaccineByCompany(String company);

}
