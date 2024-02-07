package com.mj.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mj.entity.CoronaVaccine;
import com.mj.repo.ICoronaVaccineRepo;
@Service("serviceMgmt")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String vendor) {
		return repo.searchVaccineByCompany(vendor);
	}
	@Override
	public List<CoronaVaccine> fetchVaccineByPriceRange(Double min, Double max) {
		return repo.searchVaccineByPriceRange(min, max);
	}
	@Override
	public List<Object[]> fetchVaccineDataByCompanies(String company1, String company2, String company3) {
		return repo.searchVaccineDataByCompanies(company1, company2, company3);
	}
	@Override
	public List<Double> fetchVaccinePriceByNames(String name1, String name2) {
		return repo.searchVaccinePriceByNames(name1, name2);
	}
	@Override
	public Optional<CoronaVaccine> fetchVaccineByName(String name) {
		return repo.searchVaccineByName(name);
	}
	@Override
	public Object fetchVaccineDataByName(String name) {
		return repo.searchVaccineDataByName(name);
	}
	@Override
	public String fetchVaccineCountryByName(String name) {
		return repo.searchVaccineCountryByName(name);
	}
	@Override
	public Long fetchVaccinesCount() {
		return repo.fetchVaccinesCount();
	}
	@Override
	public Object fetchVaccinesAggregateDataByPriceRange(Double min, Double max) {
		return repo.fetchVaccinesAggregateDataByPriceRange(min, max);
	}
	@Override
	@Transactional
	public int modifyVaccinePriceByCountry(Double newPrice, String country) {
		return repo.updatePriceByCountry(newPrice, country);
	}
	@Override
	@Transactional
	public int removeVaccineByPriceRange(Double startPrice, Double endPrice) {
		return repo.deleteVaccineByPriceRange(startPrice, endPrice);
	}
	@Override
	public int registerVaccine(String company, String country, String name, Double price, Integer doseCount) {
		return repo.insertVaccine(company, country, name, price, doseCount);
	}
	@Override
	public Date fetchSystemDate() {
		return repo.getSystemDate();
	}
	@Override
	public int createTempTable() {
		return repo.createTempTable();
	}


}
