package com.mj.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.Person;
import com.mj.entity.PhoneNumber;
import com.mj.repository.IPersonRepo;
import com.mj.repository.IPhoneNumberRepo;
@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	IPersonRepo repo;
	@Autowired
	IPhoneNumberRepo phoneRepo;
	@Override
	public String savePerson(Person person) {
		Person personData=repo.save(person);
		return "Person and Phone Numbers are saved with id value :"+personData.getPid();
	}
	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> phones) {
		for (PhoneNumber phoneNumber : phones) {
			phoneRepo.save(phoneNumber);
		}
		return ((Set<PhoneNumber>)phones).size()+" phone numbers are inserted";
	}
	@Override
	public List<Person> fetchByPerson() {
		return repo.findAll();
	}
	@Override
	public List<PhoneNumber> fetchByPhoneNumber() {
		return phoneRepo.findAll();
	}
	@Override
	public String deleteByPerson(Long personId) {
		//Load parent object
		Optional<Person> opt=repo.findById(personId);
		if(opt.isPresent())
		{
			repo.delete(opt.get());
			return "Person and Phone numbers are deleted";
		}
		return "Person not found";
	}
	@Override
	public String deleteAllPhoneNumbersByPerson(Long personId) {
		//Load parent object
				Optional<Person> opt=repo.findById(personId);
				if(opt.isPresent())
				{
					//get all child of parent
					Set<PhoneNumber> phoneList=opt.get().getContactDetails();
					phoneRepo.deleteAll(phoneList);
					return phoneList.size()+" phone numbers of "+personId+" person are deleted";
				}
				return personId+" Person not found";
	}

}
