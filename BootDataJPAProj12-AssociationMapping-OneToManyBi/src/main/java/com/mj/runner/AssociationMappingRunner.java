package com.mj.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.entity.Person;
import com.mj.entity.PhoneNumber;
import com.mj.service.IPersonMgmtService;
@Component
public class AssociationMappingRunner implements CommandLineRunner {
	@Autowired
	IPersonMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//=====================SAVE OBJECTS PARENT TO CHILD===================
		/*//prepare obj having associated child objs
		//prepare PhoneNumber objects
		PhoneNumber number1=new PhoneNumber(8328914097L, "Jio", "office");
		PhoneNumber number2=new PhoneNumber(8594903469L, "Vodafone", "Home");
		Set<PhoneNumber> phoneSet=Set.of(number1, number2);
		//prepare Person object
		Person person=new Person("MJ", "Soro");
		//parent to child
		number1.setPerson(person);
		number2.setPerson(person);
		//child to parent
		person.setContactDetails(phoneSet);
		//invoke service method
		System.out.println(service.savePerson(person));*/

		//=====================SAVE OBJECTS CHILD TO PARENT===================
		/*//prepare PhoneNumber objects
		PhoneNumber number1=new PhoneNumber(8328913333L, "Jio", "office");
		PhoneNumber number2=new PhoneNumber(8594911111L, "Vodafone", "Home");
		Set<PhoneNumber> phoneSet=Set.of(number1, number2);
		//prepare Person object
		Person person=new Person("MJ", "Soro");
		//parent to child
		number1.setPerson(person);
		number2.setPerson(person);
		//child to parent
		person.setContactDetails(phoneSet);
		//invoke service method
		System.out.println(service.savePhoneNumbers(phoneSet));*/
		//=====================LOAD OBJECTS PARENT TO CHILD===================
		/*service.fetchByPerson().forEach(per->{
			System.out.println(per);
			per.getContactDetails().forEach(contact->{
				System.out.println(contact);
			});
		});*/
		//=====================LOAD OBJECTS CHILD TO PARENT===================
		/*service.fetchByPhoneNumber().forEach(phone->{
			System.out.println(phone);
			System.out.println(phone.getPerson());
		});*/
		//=====================DELETE OPERATION PARENT TO CHILD===================
		//System.out.println(service.deleteByPerson(43L));
		//=====================DELETE OPERATION CHILD TO PARENT===================
				//System.out.println(service.deleteAllPhoneNumbersByPerson(45L));
	}

}
