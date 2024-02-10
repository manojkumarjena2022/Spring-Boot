package com.mj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mj.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {

}
