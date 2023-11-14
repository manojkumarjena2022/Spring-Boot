package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mj.beans.BillGenerator;

@SpringBootApplication
public class BootProj4RealTimeDiAutoConfiguration1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(BootProj4RealTimeDiAutoConfiguration1Application.class, args);
		BillGenerator bill=applicationContext.getBean("bill",BillGenerator.class);
		System.out.println(bill);
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
