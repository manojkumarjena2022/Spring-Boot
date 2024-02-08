package com.mj.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.service.IEmpMgmtService;
@Component
public class StoredProcedureRunner implements CommandLineRunner {
	@Autowired
	IEmpMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		service.serachEmpsByDesgs("CLERK","MANAGER").forEach(System.out::println);
	}

}
