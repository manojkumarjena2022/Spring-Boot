package com.mj.runners;

import java.util.List;

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


		/*try {
			//CoronaVaccine vaccine=new CoronaVaccine("MJ", "Softition", "India", 1000.0,2);
			//CoronaVaccine vaccine=new CoronaVaccine(2);
			CoronaVaccine vaccine=new CoronaVaccine();
			vaccine.setCompany("Softi");
			service.searchVaccineByGivenData(vaccine, true, "price").forEach(System.out::println);
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		/*try {

			CoronaVaccine vaccine=service.getVaccineByRegNo(1005L);
			if(vaccine!=null)
			{
				System.out.println(vaccine);
			}
			else
			{
				System.out.println("Record not found");
			}

		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		try {
			System.out.println(service.removeVaccinesByRegNos(List.of(1004L,1002L)));

		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
