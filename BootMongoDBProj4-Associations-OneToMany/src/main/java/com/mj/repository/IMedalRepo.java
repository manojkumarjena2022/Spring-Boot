package com.mj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.Medal;

public interface IMedalRepo extends MongoRepository<Medal, String> {

}
