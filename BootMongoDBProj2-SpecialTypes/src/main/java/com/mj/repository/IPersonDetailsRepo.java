package com.mj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.PersonDetails;

public interface IPersonDetailsRepo extends MongoRepository<PersonDetails, String> {
}
