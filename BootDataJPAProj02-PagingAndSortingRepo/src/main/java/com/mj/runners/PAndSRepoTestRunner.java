package com.mj.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.mj.entity.CoronaVaccine;
import com.mj.service.ICoronaVaccineMgmtService;
@Component
public class PAndSRepoTestRunner implements CommandLineRunner {
	@Autowired
	ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			Iterable<CoronaVaccine> vaccines=service.fetchDetails(true, "price","name");
			vaccines.forEach(System.out::println);
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.fetchDetailsByPageNo(2,2,true,"price").forEach(System.out::println);
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			service.fetchDetailsByPagination(3);
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
