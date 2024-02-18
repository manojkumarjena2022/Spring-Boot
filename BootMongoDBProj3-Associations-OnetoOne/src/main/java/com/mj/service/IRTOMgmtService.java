package com.mj.service;

import java.util.List;

import com.mj.document.DrivingLicence;
import com.mj.document.Person;

public interface IRTOMgmtService {
	public String registerPerson(Person details);
	public String registerDrivingLicence(DrivingLicence licence);
	public List<Person> fetchAllPersons();
	public List<DrivingLicence> fetchAllDrivingLicences();
}
