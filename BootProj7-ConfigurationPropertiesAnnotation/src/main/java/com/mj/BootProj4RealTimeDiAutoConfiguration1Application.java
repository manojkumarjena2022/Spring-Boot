package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mj.beans.CompanyDetails;
import com.mj.beans.CompanyDetails2;

@SpringBootApplication
public class BootProj4RealTimeDiAutoConfiguration1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(BootProj4RealTimeDiAutoConfiguration1Application.class, args);
		CompanyDetails company1=applicationContext.getBean("company1",CompanyDetails.class);
		System.out.println(company1);
		System.out.println("---------------------------");
		CompanyDetails2 company2=applicationContext.getBean("company2",CompanyDetails2.class);
		System.out.println(company2);
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
