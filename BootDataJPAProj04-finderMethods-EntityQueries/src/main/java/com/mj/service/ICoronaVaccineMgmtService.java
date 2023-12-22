package com.mj.service;

import java.util.List;
import java.util.Optional;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> fetchVaccineByCompany(String company);
	public List<CoronaVaccine> fetchVaccineByPriceLessThan(Double price);
	public List<CoronaVaccine> fetchVaccineByPriceRange(Double startPrice,Double endPrice);
	public List<CoronaVaccine> fetchVaccineByNameLike(String initChars);
	public List<CoronaVaccine> fetchVaccineByNameStartingWith(String startingChars);
	public List<CoronaVaccine> fetchVaccineByNameEndingWith(String endingChars);
	public List<CoronaVaccine> fetchVaccineByNameHaving(String letters);
	public List<CoronaVaccine> fetchVaccineByCountries(String ... countries);
	public List<CoronaVaccine> fetchVaccineByNotInCountries(List<String> countries);
	public List<CoronaVaccine> fetchVaccineByPriceAsc(Double startPrice);
	public List<CoronaVaccine> fetchVaccineByNotFromCountry(String country);
	public Optional<CoronaVaccine> fetchVaccineByRegNo(Long regNo);
	public List<CoronaVaccine> fetchVaccineByNameAndCountry(String name,String country);
	public List<CoronaVaccine> fetchVaccineByNameLikeOrPriceRange(String initChars,Double startPrice,Double endPrice);
	public List<CoronaVaccine> fetchVaccineByCountryInAndPriceRange(List<String> countries,Double startPrice,Double endPrice);
	public List<CoronaVaccine> fetchVaccineByCountryInAndNameInAndPriceGreterThanEqual(List<String> countries,List<String> names,Double startPrice);

}
