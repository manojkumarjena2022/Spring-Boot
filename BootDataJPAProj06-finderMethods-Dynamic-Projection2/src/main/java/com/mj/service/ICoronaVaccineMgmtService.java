package com.mj.service;

import java.util.List;

import com.mj.type.View;

public interface ICoronaVaccineMgmtService {
	public <T extends View> List<T> fetchVaccineByCompany(String company,Class<T> clazz);
	
}
