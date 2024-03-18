package com.mj.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mj.model.HumanActivity;

public interface IHumanActivitiesRepo extends CrudRepository<HumanActivity, String> {
	@Query("SELECT hobbies FROM HumanActivity")
	public Set<String> fetchAllHobbies();

}
