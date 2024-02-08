package com.mj.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.entity.CoronaVaccine;
import com.mj.service.IVaccineMgmt;
@Component
public class StoredProcedureRunner implements CommandLineRunner {
	@Autowired
	IVaccineMgmt service;
	@Override
	public void run(String... args) throws Exception {
		/*List<CoronaVaccine> list=service.serachVaccinesByPriceRange(100.0, 2000.0);
		System.out.println(list);*/
		//System.out.println(service.authenticate("MJ", "1234"));
		Object obj[]=service.getEmpDetailsByEmpNo(7902);
		System.out.println(obj[0]);
		System.out.println(obj[1]);
		System.out.println(obj[2]);
		System.out.println(obj[3]);
	}

}
