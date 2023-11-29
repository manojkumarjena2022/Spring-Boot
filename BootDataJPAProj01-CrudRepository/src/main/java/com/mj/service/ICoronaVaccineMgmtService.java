package com.mj.service;

import java.util.List;
import java.util.Optional;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public String registerVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
	public Long  getVccinesCount();
	public Boolean checkVaccineAvailabilityByRegNo(Long regNo);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(List<Long> ids);
	public Optional<CoronaVaccine> fetchVaccineById(Long id);
	public String removeVaccineById(Long regNo);
	public String removeVaccineByObject(CoronaVaccine vaccine);
	public String removeVaccinesByIds(Iterable<Long> ids);
	public String removeVaccinesByObjects(Iterable<CoronaVaccine> vaccineList);
	public String removeAll();
}
