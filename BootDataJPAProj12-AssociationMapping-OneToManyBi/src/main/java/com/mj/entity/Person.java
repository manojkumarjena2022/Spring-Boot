package com.mj.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "OTM_PERSON")
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	@NonNull
	@Column(length = 20)
	private String pname;
	@NonNull
	@Column(length = 20)
	private String paddrs;
	//@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,mappedBy = "person") (or)
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> contactDetails;//for one to Many
	public Person()
	{
		System.out.println("Person.Person()");
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", contactDetails=" + contactDetails
				+ "]";
	}
	
}
