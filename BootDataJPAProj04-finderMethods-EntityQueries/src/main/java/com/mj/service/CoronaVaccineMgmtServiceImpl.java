package com.mj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mj.entity.CoronaVaccine;
import com.mj.repo.ICoronaVaccineRepo;
@Service("serviceMgmt")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company) {
		System.out.println(repo.getClass()+" "+repo.getClass().getDeclaredMethods());
		//return repo.findByCompany(company);
		//return repo.findByCompanyEquals(company);
		return repo.findByCompanyIs(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByPriceLessThan(Double price) {
		return repo.findByPriceLessThan(price);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByPriceRange(Double startPrice, Double endPrice) {
		return repo.findByPriceBetween(startPrice, endPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNameLike(String initChars) {
		return repo.findByNameLike(initChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNameStartingWith(String startingChars) {
		return repo.findByNameStartingWith(startingChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNameEndingWith(String endingChars) {
		return repo.findByNameEndingWith(endingChars);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNameHaving(String letters) {
		return repo.findByNameContaining(letters);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByCountries(String... countries) {
		//return repo.findByCountryIn(countries);
		return repo.findByCountryIn(List.of(countries));
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNotInCountries(List<String> countries) {
		return repo.findByCountryNotIn(countries);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByPriceAsc(Double startPrice) {
		return repo.findByPriceGreaterThanOrderByPriceAsc(startPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNotFromCountry(String country) {
		return repo.findByCountryIsNot(country);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineByRegNo(Long regNo) {
		return repo.findByRegNo(regNo);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNameAndCountry(String name, String country) {
		//return repo.findByNameAndCountry(name, country);
		return repo.findByNameEqualsAndCountryEquals(name, country);
		
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByNameLikeOrPriceRange(String initChars, Double startPrice,
			Double endPrice) {
		return repo.findByNameLikeOrPriceBetween(initChars, startPrice, endPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByCountryInAndPriceRange(List<String> countries, Double startPrice,
			Double endPrice) {
		return repo.findByCountryInAndPriceBetween(countries, startPrice, endPrice);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByCountryInAndNameInAndPriceGreterThanEqual(List<String> countries,
			List<String> names, Double startPrice) {
		return repo.findByCountryInAndNameInOrPriceGreaterThanEqual(countries, names, startPrice);
	}
}
