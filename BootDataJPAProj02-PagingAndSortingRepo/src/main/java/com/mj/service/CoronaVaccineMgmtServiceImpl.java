package com.mj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... props) {
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, props);
		Iterable<CoronaVaccine> listEnities=repo.findAll(sort);
		return listEnities;
	}

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... props) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(pageNo, pageSize, asc?Direction.ASC:Direction.DESC, props);
		Page<CoronaVaccine> page=repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		long count=repo.count();
		long pageCount=count/pageSize;
		pageCount=count/pageSize==0?pageCount:++pageCount;
		for (int i = 0; i < pageCount; i++) {
			Pageable pageable=PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page=repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("-------------"+(i+1)+" of "+page.getTotalPages()+"---------------");
		}
	}

	
}
