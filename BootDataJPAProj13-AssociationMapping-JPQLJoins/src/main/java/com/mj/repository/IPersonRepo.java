package com.mj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mj.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Long> {
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type FROM Person p inner join p.contactDetails ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type FROM Person p left join p.contactDetails ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type FROM Person p right join p.contactDetails ph")
	@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type FROM Person p full join p.contactDetails ph")
	public List<Object[]> fetchDataUsingJoinsByParent();
}
