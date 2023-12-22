package com.mj.runners;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.mj.service.ICoronaVaccineMgmtService;
import com.mj.type.ResultView1;
import com.mj.type.ResultView2;
import com.mj.type.ResultView3;
@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			List<ResultView1> resultViewList=service.fetchVaccineByCompany("Softition",ResultView1.class);
			resultViewList.forEach(vaccine->{
				System.out.println(vaccine.getName()+" "+vaccine.getCountry());
			});
			System.out.println("==============================================");
			service.fetchVaccineByCompany("Softition",ResultView2.class).forEach(vaccine->{
				System.out.println(vaccine.getPrice());
			});
			System.out.println("==============================================");
			service.fetchVaccineByCompany("Softition",ResultView3.class).forEach(vaccine->{
				System.out.println(vaccine.getName()+" "+vaccine.getCountry()+" "+vaccine.getPrice());
			});
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
