package com.mj.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
@Component
public class JDBCServiceRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("JDBCServiceRunner.run()");
		System.out.println("Commandline Args are :");
		for(String arg:args)
		{
			System.out.println(arg);
		}
		
	}

	@Override
	public int getOrder() {
		return -2;
	}

}
