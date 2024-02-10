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
	public List<Object[]> fetchDataUsingJoinsByParent() {
		return repo.fetchDataUsingJoinsByParent();
	}
	
}
