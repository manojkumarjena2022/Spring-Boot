package com.mj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mj.entity.CoronaVaccine;
import com.mj.repo.ICoronaVaccineRepo;
import com.mj.type.ResultView;
@Service("serviceMgmt")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<ResultView> fetchVaccineByPriceGreaterThanEqualOrderByPrice(Double price) {
		System.out.println(repo.getClass());
		return repo.findByPriceGreaterThanEqualOrderByPrice(price);
	}

	
}
