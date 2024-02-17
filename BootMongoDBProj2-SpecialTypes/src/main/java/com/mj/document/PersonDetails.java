package com.mj.document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PersonDetails {
	@Id
	private Long pid;
	private String pname;
	private String padd;
	private LocalDateTime dob;
	private Boolean maritalStatus;
	private Set<Long> mobileNumbers;
	public Map<String, Long> bankAccounts;
	public String[] nickNames;
	public List<String> academics;
	public Properties idDetails;
}
