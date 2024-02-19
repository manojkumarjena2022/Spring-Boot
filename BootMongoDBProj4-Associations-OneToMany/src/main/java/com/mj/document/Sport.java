package com.mj.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Sport {
	@Id
	private Integer sid;
	private String sname;
	private Boolean isTeamSport;
	private Boolean isOlympicSport;
	private String[] kitItems;
	public Sport() {
		System.out.println("Sport.Sport()");
	}
	@Override
	public String toString() {
		return "Sport [sid=" + sid + ", sname=" + sname + ", isTeamSport=" + isTeamSport + ", isOlympicSport="
				+ isOlympicSport + ", kitItems=" + Arrays.toString(kitItems) + "]";
	}
	
}
