package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mj.models.Employee;

@SpringBootApplication
public class BootProj8InjectingValuesAllTypeOfSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj8InjectingValuesAllTypeOfSpringBeanPropertiesApplication.class, args);
		Employee employee=ctx.getBean("emp",Employee.class);
		System.out.println(employee);
		((ConfigurableApplicationContext)ctx).close();
	}

}
