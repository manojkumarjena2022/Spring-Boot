package com.mj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.CoronaVaccine;
import com.mj.repo.ICoronaVaccineRepo;
@Service("serviceMgmt")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("CoronaVaccineMgmtServiceImpl.registerVaccine()-"+repo.getClass());
		CoronaVaccine savedVaccine=null;
		if (vaccine!=null) {
			savedVaccine=repo.save(vaccine);
		}
		return savedVaccine!=null ? "Vaccine update/registered successfully":"Vaccine registration failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
		System.out.println("CoronaVaccineMgmtServiceImpl.registerInBatch()");
		if (vaccines!=null) {
			return repo.saveAll(vaccines);
		}
		else {
			throw new IllegalArgumentException("batch insertion not done");
		}
	}

	@Override
	public Long getVccinesCount() {
		return repo.count();
	}

	@Override
	public Boolean checkVaccineAvailabilityByRegNo(Long regNo) {
		return repo.existsById(regNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return repo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(List<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long id) {
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Long regNo) {
		Optional<CoronaVaccine> opt=repo.findById(regNo);
		if(opt.isPresent())
		{
			repo.deleteById(regNo);
			return "RegNo "+regNo+" vaccine deleted";
		}
		else
			return "Record not found";
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		Optional<CoronaVaccine> opt=repo.findById(vaccine.getRegNo());
		if(opt.isPresent())
		{
			repo.delete(vaccine);
			return "RegNo "+vaccine.getRegNo()+" vaccine deleted";
		}
		else
			return "Record not found";
	}

	@Override
	public String removeVaccinesByIds(Iterable<Long> ids) {
		Iterable<CoronaVaccine> optList=repo.findAllById(ids);
		int count=((List)ids).size();
		if(count==(((List)optList).size()))
		{
			repo.deleteAllById(ids);
			return count+" no of records are deleted";
		}
		return "Problem in deleteing records";
	}

	@Override
	public String removeVaccinesByObjects(Iterable<CoronaVaccine> vaccineList) {
		  // Extracting IDs from vaccineList
        List<Long> idList = StreamSupport.stream(vaccineList.spliterator(), false)
            .map(CoronaVaccine::getRegNo)
            .collect(Collectors.toList());
		Iterable<CoronaVaccine> optList=repo.findAllById(idList);
		int count=((List)vaccineList).size();
		if(count==(((List)optList).size()))
		{
			repo.deleteAll(vaccineList);
			return count+" no of records are deleted";
		}
		return "Problem in deleteing records";
	}

	@Override
	public String removeAll() {
		Iterable<CoronaVaccine> list=repo.findAll();
		int count=((List)list).size();
		if(count!=0)
		{
			repo.deleteAll();
			return count +" no of records deleted";
		}
		return "no records found to deleted";	
	}

}
