package com.mj.service;

import java.util.List;
import java.util.Optional;

import com.mj.entity.CoronaVaccine;
import com.mj.type.ResultView;

public interface ICoronaVaccineMgmtService {
	public List<ResultView> fetchVaccineByPriceGreaterThanEqualOrderByPrice(Double price);
	
}
