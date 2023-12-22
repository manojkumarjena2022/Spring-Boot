package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.repo.ICoronaVaccineRepo;
import com.mj.type.View;
@Service("serviceMgmt")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public <T extends View> List<T> fetchVaccineByCompany(String company, Class<T> clazz) {
		return repo.findByCompanyOrderByCompanyDesc(company, clazz);
	}



	
}
