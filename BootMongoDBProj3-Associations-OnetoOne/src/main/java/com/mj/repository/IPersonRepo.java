package com.mj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.Person;

public interface IPersonRepo extends MongoRepository<Person, Integer> {

}
