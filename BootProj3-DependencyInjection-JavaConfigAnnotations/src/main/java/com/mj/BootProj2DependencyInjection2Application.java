package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.mj.beans.Student;

@SpringBootApplication
@ImportResource(locations = "com/mj/cfgs/applicationContext.xml")
public class BootProj2DependencyInjection2Application {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx= SpringApplication.run(BootProj2DependencyInjection2Application.class, args);
		//get Target bean class object
		Student stud=ctx.getBean("stud",Student.class);
		//use bean class object and invoke b.method
		stud.preparation("Java Interview");
		//close IOC container
		((ConfigurableApplicationContext)ctx).close();
	}//main

}//class
