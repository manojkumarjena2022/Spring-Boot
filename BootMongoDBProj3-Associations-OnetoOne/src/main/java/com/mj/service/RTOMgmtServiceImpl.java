package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.document.DrivingLicence;
import com.mj.document.Person;
import com.mj.repository.IDrivingLicenceRepo;
import com.mj.repository.IPersonRepo;
@Service("rtoService")
public class RTOMgmtServiceImpl implements IRTOMgmtService {
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IDrivingLicenceRepo licenceRepo;
	@Override
	public String registerPerson(Person details) {
		return "Person registered with id:"+personRepo.save(details).getPid();
	}

	@Override
	public String registerDrivingLicence(DrivingLicence licence) {
		return "Driving Licence registered with id:"+licenceRepo.save(licence).getLid();
	}

	@Override
	public List<Person> fetchAllPersons() {
		return personRepo.findAll();
	}

	@Override
	public List<DrivingLicence> fetchAllDrivingLicences() {
		return licenceRepo.findAll();
	}

}
