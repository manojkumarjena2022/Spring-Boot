package com.mj.service;

import java.util.List;

import com.mj.entity.Person;
import com.mj.entity.PhoneNumber;

public interface IPersonMgmtService {
	public String savePerson(Person person);
	public String savePhoneNumbers(Iterable<PhoneNumber> phones);
	public List<Person> fetchByPerson();
	public List<PhoneNumber> fetchByPhoneNumber();
	public String deleteByPerson(Long personId);
	public String deleteAllPhoneNumbersByPerson(Long personId);
}
