package com.mj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.model.Cricketer;
import com.mj.repository.ICricketRepo;
@Service
public class CricketerMgmtServiceImpl implements ICricketerMgmtService {
	@Autowired
	private ICricketRepo repo;

	@Override
	public String registerCricketer(Cricketer cricketer) {
		return "Cricketer registered with Id :"+repo.save(cricketer).getCid();
	}

}
