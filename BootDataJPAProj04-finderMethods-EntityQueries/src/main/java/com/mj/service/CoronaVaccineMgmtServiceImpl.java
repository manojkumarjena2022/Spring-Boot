package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mj.entity.CoronaVaccine;
import com.mj.repo.ICoronaVaccineRepo;
@Service("serviceMgmt")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccineByCompany(String company) {
		System.out.println(repo.getClass()+" "+repo.getClass().getDeclaredMethods());
		//return repo.findByCompany(company);
		//return repo.findByCompanyEquals(company);
		return repo.findByCompanyIs(company);
	}
}
