package com.mj.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
public class AlertServiceRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AlertServiceRunner2.run()");
		System.out.println("Commandline Args are :");
		for(String arg:args)
		{
			System.out.println(arg);
		}
		
	}

}
