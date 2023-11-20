package com.mj;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootProj14RunnersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProj14RunnersApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner createRunner1() {
		CommandLineRunner clr=(String ...cargs)->{
			System.out.println("CommandLineRunner.main()");
		};
		return clr;
	}
	@Bean
	public ApplicationRunner createRunner2() {
		ApplicationRunner ar=(ApplicationArguments args)->{
			System.out.println("ApplicationRunner.main()");
		};
		return ar;
	}

}
