package com.mj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
	public List<Customer> findByBillAmtBetween(Double start,Double end);
	public List<Customer> findByCaddInAndMobileNoIsNotNull(String ...addresses);
}
