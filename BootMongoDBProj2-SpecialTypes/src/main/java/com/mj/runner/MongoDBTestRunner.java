package com.mj.runner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.document.PersonDetails;
import com.mj.service.IPersonDetailsMgmtService;
@Component
public class MongoDBTestRunner implements CommandLineRunner {
	@Autowired
	IPersonDetailsMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//prepare Document object
		/*PersonDetails details=new PersonDetails();
		details.setPid(Long.valueOf(new Random().nextInt(1000)));
		details.setPname("Manoj");
		details.setPadd("Soro");
		details.setDob(LocalDateTime.of(1996, 4, 29, 23, 10));
		details.setMaritalStatus(true);
		details.setNickNames(new String[] {"MJ","Kumar"});
		details.setMobileNumbers(Set.of(8328914097L,8594903469L,9876453456L));
		details.setAcademics(List.of("BSE","HSE","B.Tech"));
		details.setBankAccounts(Map.of("SBI",34567456L,"PNB",98764534L));
		Properties props=new Properties();
		props.put("PAN", "BLPPJ9614L");
		props.put("Aadhar", "512040109798");
		details.setIdDetails(props);
		System.out.println(service.registerPerson(details));*/
		service.findAllPersons().forEach(System.out::println);
	}

}
