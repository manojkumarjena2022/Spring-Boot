package com.mj.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.document.Customer;
import com.mj.generator.IdGenerator;
import com.mj.service.ICustomerMgmtService;
@Component
public class MongoDBTestRunner implements CommandLineRunner {
	@Autowired
	private ICustomerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//======== INSERT OPERATION ===============
		/*Customer cust=new Customer();
		cust.setCno(1001);
		cust.setCname("manoj");
		cust.setCadd("Soro");
		cust.setBillAmt(3000.0);
		System.out.println(service.registerCustomer(cust));*/
		
		/*Customer cust=new Customer();
		cust.setCno(1002);
		cust.setCname("kumar");
		System.out.println(service.registerCustomer(cust));*/
		//======== UPDATE OPERATION ===============
		/*Customer cust=new Customer();
		cust.setCno(1004);
		cust.setCname("mj");
		cust.setCadd("bls");
		cust.setMobileNo(0L);
		System.out.println(service.registerCustomer(cust));*/
		
		/*Customer cust=new Customer();
		cust.setId("65cfa8c0e3d1a204afd78914");
		cust.setCno(1004);
		cust.setCname("mj");
		cust.setCadd("bls");
		cust.setMobileNo(8654546456L);
		System.out.println(service.registerCustomer(cust));*/
		//======== SAVE OPERATION USING CUSTOM ID GENERATOR ===============
		/*Customer cust=new Customer();
		cust.setId(IdGenerator.generateId());
		cust.setCno(1004);
		cust.setCname("mj2");
		cust.setCadd("bls2");
		cust.setMobileNo(86545464562L);
		System.out.println(service.registerCustomer(cust));*/
		//======== READ OPERATION ===============
		/*service.findAllCustomers().forEach(cust->{
			System.out.println(cust);
		});*/
		//======== DELETE OPERATION ===============
		//System.out.println(service.removeCustomerById("fa9f7d8b-7"));
		//======== FINDER METHODS OPERATION ===============
		//service.fetchCustomersByBillAmtRange(1000.0, 6000.0).forEach(System.out::println);
		service.fetchCustomersByUsingCaddAndHavingMobileNo("bls","Soro").forEach(System.out::println);
	}

}
