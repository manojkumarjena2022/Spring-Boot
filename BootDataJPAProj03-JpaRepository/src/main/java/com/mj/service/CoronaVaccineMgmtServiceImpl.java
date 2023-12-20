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
	public List<CoronaVaccine> searchVaccineByGivenData(CoronaVaccine vaccine, boolean ascOrder, String... props) {
		//prepare Example object
		Example example=Example.of(vaccine);
		//prepare sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC, props);
		List<CoronaVaccine> listEntities=repo.findAll(example, sort);
		return listEntities;
	}
	@Override
	public CoronaVaccine getVaccineByRegNo(Long regNo) {
		return repo.getById(regNo);
	}
	@Override
	public String removeVaccinesByRegNos(Iterable<Long> regNos) {
		Iterable<CoronaVaccine> listEntities= repo.findAllById(regNos);
		if(((List)listEntities).size()!=0)
		{
			repo.deleteAllInBatch(listEntities);
			return ((List)listEntities).size()+" no of records are deleted";
		}
		else
		{
			System.out.println("Record not found for deletion");
		}
		return null;
	}

}
