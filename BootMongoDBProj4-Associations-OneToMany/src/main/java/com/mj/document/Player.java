package com.mj.document;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Document
@Getter
@Setter
public class Player {
	@Id
	private Long pid;
	private String pname;
	private String padd;
	private Set<Sport> sports;//HAS-A property for One-To-Many
	private Map<String, Medal> medals;//HAS-A property One-To-Many
	public Player() {
		System.out.println("Player.Player()");
	}
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", padd=" + padd + "]";
	}

}
