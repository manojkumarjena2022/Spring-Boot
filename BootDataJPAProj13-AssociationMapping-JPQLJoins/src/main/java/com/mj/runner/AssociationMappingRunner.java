package com.mj.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.service.IPersonMgmtService;
@Component
public class AssociationMappingRunner implements CommandLineRunner {
	@Autowired
	IPersonMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		service.fetchDataUsingJoinsByParent().forEach(row->{
			for(Object val:row)
			{
				System.out.print(val+" ");
			}
			System.out.println();
		});
	}

}
