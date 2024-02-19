package com.mj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.Sport;

public interface ISportRepo extends MongoRepository<Sport, Integer> {

}
