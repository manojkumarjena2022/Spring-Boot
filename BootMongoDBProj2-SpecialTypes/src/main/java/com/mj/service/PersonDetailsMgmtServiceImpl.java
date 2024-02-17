package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.document.PersonDetails;
import com.mj.repository.IPersonDetailsRepo;

@Service("personService")
public class PersonDetailsMgmtServiceImpl implements IPersonDetailsMgmtService {
	@Autowired
	IPersonDetailsRepo repo;
	
	@Override
	public String registerPerson(PersonDetails doc) {
		return "Person registered with id :"+repo.save(doc).getPid();
	}
	@Override
	public List<PersonDetails> findAllPersons() {
		return repo.findAll();
	}

}
