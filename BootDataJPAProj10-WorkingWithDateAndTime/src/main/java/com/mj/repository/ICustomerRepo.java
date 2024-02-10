package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mj.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
