package com.mj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document
@Data
public class Person {
	@Id
	public Integer pid;
	public String pname;
	public String padd;
	public DrivingLicence licence;
}
