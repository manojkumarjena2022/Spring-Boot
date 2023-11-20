package com.mj.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class AlertServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AlertServiceRunner.run()");
		System.out.println("Commandline Args are :");
		for(String arg:args)
		{
			System.out.println(arg);
		}
		
	}

}
