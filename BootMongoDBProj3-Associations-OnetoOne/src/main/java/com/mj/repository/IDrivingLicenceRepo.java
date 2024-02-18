package com.mj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.DrivingLicence;

public interface IDrivingLicenceRepo extends MongoRepository<DrivingLicence, Long> {

}
