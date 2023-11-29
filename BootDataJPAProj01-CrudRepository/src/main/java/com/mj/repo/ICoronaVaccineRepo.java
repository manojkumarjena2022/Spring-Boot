package com.mj.repo;
import org.springframework.data.repository.CrudRepository;

import com.mj.entity.CoronaVaccine;
public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine,Long> {

}
