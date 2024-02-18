package com.mj.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class DrivingLicence {
	@Id
	public Long lid;
	public String type;
	public LocalDateTime expiryDate;
	public Person person;
}
