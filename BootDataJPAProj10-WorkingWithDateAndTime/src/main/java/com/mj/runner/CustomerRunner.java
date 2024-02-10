package com.mj.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.entity.Customer;
import com.mj.service.ICustomerMgmtService;
@Component
public class CustomerRunner implements CommandLineRunner {
	@Autowired
	private ICustomerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*String result=service.registerCustomer(new Customer("MJ", "Balasore", 
				LocalDateTime.of(1997, 4, 29, 11, 10), 
				LocalTime.now(), 
				LocalDate.now()));
		System.out.println(result);*/
		service.getAllCustomer().forEach(System.out::println);
		
	}

}
