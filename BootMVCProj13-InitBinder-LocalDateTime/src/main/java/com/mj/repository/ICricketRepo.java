package com.mj.repository;

import org.springframework.data.repository.CrudRepository;

import com.mj.model.Cricketer;

public interface ICricketRepo extends CrudRepository<Cricketer,Integer> {

}
