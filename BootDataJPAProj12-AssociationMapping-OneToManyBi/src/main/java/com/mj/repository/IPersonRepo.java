package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mj.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Long> {

}
