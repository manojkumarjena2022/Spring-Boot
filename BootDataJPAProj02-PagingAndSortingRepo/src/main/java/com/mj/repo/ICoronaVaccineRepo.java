package com.mj.repo;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mj.entity.CoronaVaccine;
public interface ICoronaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine,Long> {

}
