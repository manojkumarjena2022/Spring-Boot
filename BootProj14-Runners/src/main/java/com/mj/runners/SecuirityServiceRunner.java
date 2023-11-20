package com.mj.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(-30)
public class SecuirityServiceRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SecuirityServiceRunner.run()");
		System.out.println("Commandline Args are :");
		for(String arg:args)
		{
			System.out.println(arg);
		}
		
	}

	@Override
	public int getOrder() {
		return 16;
	}

}
