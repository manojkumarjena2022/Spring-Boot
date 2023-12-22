package com.mj.runners;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.mj.entity.CoronaVaccine;
import com.mj.service.ICoronaVaccineMgmtService;
@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			//service.fetchVaccineByCompany("Softition").forEach(System.out::println);
			//service.fetchVaccineByPriceLessThan(1000.0).forEach(System.out::println);
			//service.fetchVaccineByPriceLessThan(1000.0).forEach(System.out::println);
			//service.fetchVaccineByPriceRange(500.0,1000.0).forEach(System.out::println);
			//service.fetchVaccineByNameLike("__").forEach(System.out::println);
			//OR
			//service.fetchVaccineByNameLike("J%").forEach(System.out::println);
			//service.fetchVaccineByNameStartingWith("M").forEach(System.out::println);
			//service.fetchVaccineByNameEndingWith("r").forEach(System.out::println);
			//service.fetchVaccineByNameHaving("MJ").forEach(System.out::println);
			//service.fetchVaccineByCountries("India","China").forEach(System.out::println);
			//service.fetchVaccineByNotInCountries(List.of("India","China")).forEach(System.out::println);
			//service.fetchVaccineByNotFromCountry("China").forEach(System.out::println);
			//service.fetchVaccineByPriceAsc(500.0).forEach(System.out::println);
			/*Optional<CoronaVaccine> optVaccine=service.fetchVaccineByRegNo(1001L);
			if(optVaccine.isPresent())
			{
				System.out.println(optVaccine.get());
			}
			else
			{
				System.out.println("Vaccine not found");
			}*/
			
			/*USING MULTIPLE PROPERTIES BASED CONDITIONS*/
			
			//service.fetchVaccineByNameAndCountry("MJ","India").forEach(System.out::println);
			//service.fetchVaccineByNameLikeOrPriceRange("MJ",1000.0,2000.0).forEach(System.out::println);
			//service.fetchVaccineByCountryInAndPriceRange(List.of("India","Rusia"),1000.0,2000.0).forEach(System.out::println);
			service.fetchVaccineByCountryInAndNameInAndPriceGreterThanEqual(List.of("India","Rusia"),List.of("MJ","Manoj"),2000.0).forEach(System.out::println);
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
