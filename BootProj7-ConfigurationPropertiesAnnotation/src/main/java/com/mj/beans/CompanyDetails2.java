package com.mj.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company2")
@ConfigurationProperties(prefix = "org.softi")
@Data
public class CompanyDetails2 {
	private String type;
	private String name;
	@Value("${my.app}")
	private String location;
	private String product;
	@Override
	public String toString() {
		return "CompanyDetails2 [type=" + type + ", name=" + name + ", addrs=" + location + ", product=" + product + "]";
	}
	
}
