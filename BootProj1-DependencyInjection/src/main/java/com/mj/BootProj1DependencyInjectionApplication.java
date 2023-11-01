package com.mj;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.mj.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj1DependencyInjectionApplication {
	//bean id : ldt
	@Bean(name="ldt")
	//bean id : createLocalDate
	//@Bean
	//still it is declared as prototype , it's instance will be created for dependency injection
	//@Scope("prototype")
	public LocalDateTime createLocalDate()
	{
		System.out.println("BootProj1DependencyInjectionApplication.createLocalDate()");
		LocalDateTime ldt=LocalDateTime.now();
		return ldt;
	}

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj1DependencyInjectionApplication.class, args);
		//get target bean class object
		WishMessageGenerator wmg=ctx.getBean("wmg",WishMessageGenerator.class);
		//WishMessageGenerator wmg=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
		//invoke b.method
		String result=wmg.generateMessage("Manoj");
		System.out.println(result);
		System.out.println("================================");
		System.out.println("All bean ids: "+Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println("================================");
		((ConfigurableApplicationContext)ctx).close();
		
	}

}
