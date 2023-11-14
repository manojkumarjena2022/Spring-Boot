package com.mj.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company1")
public class CompanyDetails {
	@Value("${org.softi.type}")
	private String type;
	@Value("${org.softi.name}")
	private String name;
	@Value("${org.softi.location}")
	private String location;
	@Override
	public String toString() {
		return "CompanyDetails [type=" + type + ", name=" + name + ", location=" + location + "]";
	}
	
}
