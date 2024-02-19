package com.mj.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.service.ICustomerMgmtService;
@Component
public class SpringBootMongoDBRunner implements CommandLineRunner {
	@Autowired
	ICustomerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*service.fetchCustomersDataByCadd("bls").forEach(doc->{
			for (Object attr : doc) {
				System.out.println(attr+" ");
			}
			System.out.println();
		});*/
		
		/*service.fetchCustomersByCadd("bls").forEach(doc->{
			for (Object attr : doc) {
				System.out.println(attr+" ");
			}
			System.out.println();
		});*/
		
		/*service.fetchCustomersByCaddAndCname("bls","mj").forEach(doc->{
			for (Object attr : doc) {
				System.out.println(attr+" ");
			}
			System.out.println();
		});*/
		
		/*service.fetchCustomersByCaddOrCname("bls","mj").forEach(doc->{
			for (Object attr : doc) {
				System.out.println(attr+" ");
			}
			System.out.println();
		});*/
		
		/*service.fetchCustomersByBillAmtRange(1000.0,5000.0).forEach(doc->{
			for (Object attr : doc) {
				System.out.println(attr+" ");
			}
			System.out.println();
		});*/
		
		//service.fetchCustomersByRegCadd("^S").forEach(System.out::println);
		//service.fetchCustomersByRegCadd("s$").forEach(System.out::println);
		
		//System.out.println("Count By Range ::"+service.fetchCustomersCountByBillAmtRange(1000.0, 6000.0));
		
		//service.fetchCustomersSortedByBillAmt().forEach(System.out::println);
		
		//System.out.println("Deleted record Count ::"+service.removeCustomersWithNoBillAmt());
		
		System.out.println("Exist ::"+service.checkCustomersExistanceWithBillAmtRange(8000.0, 9000.0));
	}

}
