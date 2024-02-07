package com.mj.runners;

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
			/*service.fetchVaccineByCompany("Softition").forEach(vaccine->{
				System.out.println(vaccine.getName()+" "+vaccine.getCountry()+" "+vaccine.getPrice());
			});*/
			
			//service.fetchVaccineByCompany("Softition").forEach(System.out::println);
			
			//service.fetchVaccineByPriceRange(600.0,5000.0).forEach(System.out::println);
			
			/*service.fetchVaccineDataByCompanies("Softition", "Softi", "Solution").forEach(vacc->{
				System.out.println("Name :"+vacc[0]+" "+"Company :"+vacc[1]+" "+"Price :"+vacc[2]);
			});*/
			
			/*	service.fetchVaccinePriceByNames("MJ", "Kumar").forEach(vacc->{
					System.out.println("Price :"+vacc);
				});*/
			
			/*Optional<CoronaVaccine> optional=service.fetchVaccineByName("MJ");
			if(optional.isPresent())
				System.out.println(optional.get());
			else
				System.out.println("Vaccine not found");*/
			
			
			/*Object object=service.fetchVaccineDataByName("MJ");
			Object obj[]=(Object[])object;
			for (Object object2 : obj) {
				System.out.print(object2+" ");
			}
			System.out.println();*/
			
			//System.out.println(service.fetchVaccineCountryByName("MJ"));
			
			/*System.out.println(service.fetchVaccinesCount());
			System.out.println("===================================");
			Object object[]=(Object[])service.fetchVaccinesAggregateDataByPriceRange(600.0, 2000.0);
			System.out.println("Vaccine count of price range 600 and 200 :"+object[0]);
			System.out.println("Max price range 600 and 200 :"+object[1]);
			System.out.println("Min price range 600 and 200 :"+object[2]);
			System.out.println("Sum of price range 600 and 200 :"+object[3]);
			System.out.println("Avg of price range 600 and 200 :"+object[4]);*/
			
			//System.out.println("====================Non-select operations===================");
			/*int count=service.modifyVaccinePriceByCountry(200.0, "India");
			System.out.println("No of records updated ::"+count);*/
			
			//System.out.println("No of records delete ::"+service.removeVaccineByPriceRange(200.0, 2000.0));
			
			System.out.println("=========== Native-SQL operations ================");
			
			/*int count=service.registerVaccine("Physer", "India", "Covaxin", 600.0, 4);
			if(count==0)
			{
				System.out.println("Record not inserted");
			}
			else
			{
				System.out.println("Record inserted");
			}*/
			
			//System.out.println("System Date ::"+service.fetchSystemDate());
			
			int count=service.createTempTable();
			if(count==0)
			{
				System.out.println("table created");
			}
			else
			{
				System.out.println("table not created");
			}
			
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
