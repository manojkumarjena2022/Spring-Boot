package com.mj.runner;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.document.DrivingLicence;
import com.mj.document.Person;
import com.mj.service.IRTOMgmtService;
@Component
public class SpringDataMongoDBRunner implements CommandLineRunner {
	@Autowired
	private IRTOMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//============== PARENT TO CHILD ===================
		/*// prepare objects
		//prepare parent object
		Person details=new Person();
		details.setPid(new Random().nextInt(10000));
		details.setPname("MJ");
		details.setPadd("SORO");
		//prepare child object
		DrivingLicence licence=new DrivingLicence();
		licence.setLid(Long.valueOf(new Random().nextInt(2000)));
		licence.setType("HDD");
		licence.setExpiryDate(LocalDateTime.of(2017, 11, 21, 11, 31));
		details.setLicence(licence);
		System.out.println(service.registerPerson(details));*/
		//============== CHILD TO PARENT ===================
		/*// prepare objects
		//prepare child object
		DrivingLicence licence=new DrivingLicence();
		licence.setLid(Long.valueOf(new Random().nextInt(2000)));
		licence.setType("IUGD");
		licence.setExpiryDate(LocalDateTime.of(2004, 5, 24, 12, 22));
		//prepare parent object
		Person details=new Person();
		details.setPid(new Random().nextInt(10000));
		details.setPname("Moogly");
		details.setPadd("BBSR");
		licence.setPerson(details);
		System.out.println(service.registerDrivingLicence(licence));*/
		System.out.println("===========PARENT TO CHILD ==================");
		service.fetchAllPersons().forEach(person->{
			System.out.println(person);
		});
		System.out.println("===========CHILD TO PARENT ==================");
		service.fetchAllDrivingLicences().forEach(System.out::println);

	}

}
