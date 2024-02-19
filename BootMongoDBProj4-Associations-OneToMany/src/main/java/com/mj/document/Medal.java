package com.mj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Medal {
	@Id
	private String mid;
	private MedalType type;
	private String sportName;
	private Double prizeMoney;
	private String eventName;
	public Medal() {
		System.out.println("Medal.Medal()");
	}
	@Override
	public String toString() {
		return "Medal [mid=" + mid + ", type=" + type + ", sportName=" + sportName + ", prizeMoney=" + prizeMoney
				+ ", eventName=" + eventName + "]";
	}
	
}
