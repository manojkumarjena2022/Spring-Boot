package com.mj.service;

import java.util.List;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> searchVaccineByGivenData(CoronaVaccine vaccine,boolean ascOrder,String... props);
	public CoronaVaccine getVaccineByRegNo(Long regNo);
	public String removeVaccinesByRegNos(Iterable<Long> regNos);
}
