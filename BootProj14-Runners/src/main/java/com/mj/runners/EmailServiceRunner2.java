package com.mj.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class EmailServiceRunner2 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailServiceRunner2.run()");
		System.out.println("Non option args :"+args.getNonOptionArgs());//only value will be there no keys
		System.out.println("option arg names/keys :"+args.getOptionNames());//contains --key=val gives only keys
		System.out.println("source args :"+args.getSourceArgs());

	}

}
