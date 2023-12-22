package com.mj.runners;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.mj.service.ICoronaVaccineMgmtService;
import com.mj.type.ResultView;
@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			List<ResultView> resultViewList=service.fetchVaccineByPriceGreaterThanEqualOrderByPrice(1000.0);
			resultViewList.forEach(vaccine->{
				System.out.println(vaccine.getClass());
				System.out.println(Arrays.toString(vaccine.getClass().getDeclaredMethods()));
				System.out.println(vaccine.getName()+" "+vaccine.getCountry());
			});
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
