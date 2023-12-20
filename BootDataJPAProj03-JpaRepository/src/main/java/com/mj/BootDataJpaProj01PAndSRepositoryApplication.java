package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.mj.entity.CoronaVaccine;
import com.mj.service.CoronaVaccineMgmtServiceImpl;

@SpringBootApplication
public class BootDataJpaProj01PAndSRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj01PAndSRepositoryApplication.class, args);
	}

}
