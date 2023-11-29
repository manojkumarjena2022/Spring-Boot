package com.mj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.mj.entity.CoronaVaccine;
import com.mj.service.CoronaVaccineMgmtServiceImpl;

@SpringBootApplication
public class BootDataJpaProj01CrudRepositoryApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx= SpringApplication.run(BootDataJpaProj01CrudRepositoryApplication.class, args);
		//get service class object
		CoronaVaccineMgmtServiceImpl service=ctx.getBean("serviceMgmt",CoronaVaccineMgmtServiceImpl.class);
		//invoke methods
		
		/*try {
			//CoronaVaccine vaccine=new CoronaVaccine(1L, "Manoj", "Softition", "India", 300.0, 2);
			CoronaVaccine vaccine=new CoronaVaccine("Manoj", "Softition", "India", 200.0, 2);
			String output=service.registerVaccine(vaccine);
			System.out.println(output);
			
		} catch (DataAccessException datae) {
			datae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		((ConfigurableApplicationContext)ctx).close();
	}

}
