package com.mj.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class EmailServiceRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailServiceRunner.run()");
		System.out.println("Non option args :"+args.getNonOptionArgs());//only value will be there no keys
		System.out.println("option arg names/keys :"+args.getOptionNames());//contains --key=val gives only keys
		System.out.println("source args :"+args.getSourceArgs());

	}

}
