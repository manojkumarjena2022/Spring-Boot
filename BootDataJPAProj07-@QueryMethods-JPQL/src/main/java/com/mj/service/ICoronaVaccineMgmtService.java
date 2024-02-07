package com.mj.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine>fetchVaccineByCompany(String vendor);
	public List<CoronaVaccine> fetchVaccineByPriceRange(Double min,Double max);
	public List<Object[]> fetchVaccineDataByCompanies(String company1,String company2,String company3);
	public List<Double> fetchVaccinePriceByNames(String name1,String name2);
	
	public Optional<CoronaVaccine> fetchVaccineByName(String name);
	public Object fetchVaccineDataByName(String name);
	public String fetchVaccineCountryByName(String name);
	
	public Long fetchVaccinesCount();
	public Object fetchVaccinesAggregateDataByPriceRange(Double min,Double max);
	
	public int modifyVaccinePriceByCountry(Double newPrice,String country);
	public int removeVaccineByPriceRange(Double startPrice,Double endPrice);
	
	public int registerVaccine(String company,String country,String name,Double price,Integer doseCount);
	public Date fetchSystemDate();
	public int createTempTable();
	
}
