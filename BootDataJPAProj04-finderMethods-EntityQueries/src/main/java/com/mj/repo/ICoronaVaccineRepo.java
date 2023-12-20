package com.mj.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mj.entity.CoronaVaccine;
public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Long> {
	//public List<CoronaVaccine> findByCompany(String company);
	//public List<CoronaVaccine> findByCompanyEquals(String company);
	public List<CoronaVaccine> findByCompanyIs(String company);
}
