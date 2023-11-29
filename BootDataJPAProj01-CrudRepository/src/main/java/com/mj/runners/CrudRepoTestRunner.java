package com.mj.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.mj.entity.CoronaVaccine;
import com.mj.service.ICoronaVaccineMgmtService;
@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {


		try {

			/*Iterable<CoronaVaccine> listVaccines=service.registerInBatch(List.of(
					new CoronaVaccine("MKJ1", "Softition", "India", 200.0, 2),
					new CoronaVaccine("MKJ2", "Softition", "India", 200.0, 2),
					new CoronaVaccine("MKJ3", "Softition", "India", 200.0, 2)));*/

			/*Iterable<CoronaVaccine> listVaccines=service.registerInBatch(Arrays.asList(
					new CoronaVaccine("MKJ1", "Softition", "India", 200.0, 2),
					new CoronaVaccine("MKJ2", "Softition", "India", 200.0, 2),
					new CoronaVaccine("MKJ3", "Softition", "India", 200.0, 2)));
			System.out.println("Reg Nos are :");
			listVaccines.forEach(vaccine->System.out.println(vaccine.getRegNo()));*/

			/*System.out.println(service.getVccinesCount());
			System.out.println("7 regNo vaccine available?"+service.checkVaccineAvailabilityByRegNo(7));*/

			/*System.out.println("===========findAll()===============");
			Iterable<CoronaVaccine> vaccinesList=service.fetchAllDetails();
			vaccinesList.forEach(vaccine->{  //forEach with Lambda 
				System.out.println(vaccine);
				});

			System.out.println("================== improved forEach with Lambda =================");
			service.fetchAllDetails().forEach(vaccine->System.out.println(vaccine));//improved forEach with Lambda
			System.out.println("================== forEach with method reference =================");
			service.fetchAllDetails().forEach(System.out::println); //forEach with method reference
			System.out.println("================== using streaming API =================");
			Arrays.asList(service.fetchAllDetails()).stream().forEach(System.out::println); //using streaming API
			System.out.println("================== using streaming API =================");
			Arrays.asList(service.fetchAllDetails()).stream().map(vac1->vac1).forEach(System.out::println); //using streaming API
			 */

			/*System.out.println("===========findAllById()===============");
			Iterable<CoronaVaccine> vaccinesList=service.fetchAllDetailsByIds(List.of(2L,5L,10L,3L));
			vaccinesList.forEach(vaccine->{  //forEach with Lambda 
				System.out.println(vaccine);
				});

			System.out.println("================== improved forEach with Lambda =================");
			service.fetchAllDetailsByIds(List.of(2L,5L,10L,3L)).forEach(vaccine->System.out.println(vaccine));//improved forEach with Lambda
			System.out.println("================== forEach with method reference =================");
			service.fetchAllDetailsByIds(List.of(2L,5L,10L,3L)).forEach(System.out::println); //forEach with method reference
			System.out.println("================== using streaming API =================");
			Arrays.asList(service.fetchAllDetailsByIds(List.of(2L,5L,10L,3L))).stream().forEach(System.out::println); //using streaming API
			System.out.println("================== using streaming API =================");
			Arrays.asList(service.fetchAllDetailsByIds(List.of(2L,5L,10L,3L))).stream().map(vac1->vac1).forEach(System.out::println); //using streaming API
			 */

			/*System.out.println("===========findById()===============");
			Optional<CoronaVaccine> vaccineOptional=service.fetchVaccineById(8L);
			if (vaccineOptional.isPresent()) {
				System.out.println(vaccineOptional.get());
			}
			
			System.out.println("==========================");
			Optional<CoronaVaccine> vaccineOptional2=service.fetchVaccineById(9L);
			if (vaccineOptional2.isPresent()) 
				System.out.println(vaccineOptional2.get());
			vaccineOptional2.orElseThrow(()->new IllegalArgumentException("Record not found"));
			System.out.println("==========================");
			CoronaVaccine vaccine=service.fetchVaccineById(3L).orElseThrow(()->new IllegalArgumentException("Record not found"));
			System.out.println(vaccine);
			System.out.println("==========================");
			CoronaVaccine vaccine1=service.fetchVaccineById(33L).orElse(new CoronaVaccine());
			System.out.println(vaccine1);
			System.out.println("==========================");
			CoronaVaccine vaccine2=service.fetchVaccineById(33L).orElseGet(()->new CoronaVaccine());
			System.out.println(vaccine2);*/

			/*System.out.println("===========deleteById()===============");
			System.out.println(service.removeVaccineById(15L));*/
				
			/*System.out.println("===========deleteByObject()===============");
			CoronaVaccine vaccine=new CoronaVaccine();
			vaccine.setRegNo(6L);
			System.out.println(service.removeVaccineByObject(vaccine));*/
			
			/*System.out.println("===========deleteByIds()===============");
			System.out.println(service.removeVaccinesByIds(List.of(1L,4L,8L)));*/
			
			/*System.out.println("===========deleteByObjects()===============");
			CoronaVaccine vaccine1=new CoronaVaccine();
			vaccine1.setRegNo(3L);
			CoronaVaccine vaccine2=new CoronaVaccine();
			vaccine2.setRegNo(2L);
			System.out.println(service.removeVaccinesByObjects(List.of(vaccine1,vaccine2)));*/
			
			System.out.println("===========deleteAll()===============");
			System.out.println(service.removeAll());
			
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}



		/*try {
			//CoronaVaccine vaccine=new CoronaVaccine(1L, "Manoj", "Softition", "India", 300.0, 2);
			CoronaVaccine vaccine=new CoronaVaccine("Mj", "Softition", "India", 700.0, 2);
			String output=service.registerVaccine(vaccine);
			System.out.println(output);

		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/

	}

}
