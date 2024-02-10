package com.mj.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "OTM_PHONENUMBER")
public class PhoneNumber implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "regno_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Long regno;
	@NonNull
	private Long phoneNo;
	@NonNull
	@Column(length = 20)
	private String provider;
	@NonNull
	@Column(length = 20)
	private String type;
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")//FK column
	private Person person;//for Many to one
	
	public PhoneNumber() {
		System.out.println("PhoneNumber.PhoneNumber()");
	}

	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type+"]";
	}

	

}
