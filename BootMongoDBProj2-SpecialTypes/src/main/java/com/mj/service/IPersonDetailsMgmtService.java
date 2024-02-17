package com.mj.service;

import java.util.List;

import com.mj.document.PersonDetails;


public interface IPersonDetailsMgmtService {
	public String registerPerson(PersonDetails doc);
	public List<PersonDetails> findAllPersons();

}
