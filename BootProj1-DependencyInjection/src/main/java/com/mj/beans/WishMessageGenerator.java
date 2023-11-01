package com.mj.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//bean id : wmg
@Component("wmg")
//bean id : wishMessageGenerator
//@Component
public class WishMessageGenerator {
	@Autowired
	LocalDateTime datetime;
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
	}
	//b.method
	public String generateMessage(String user)
	{
		int hour=datetime.getHour();
		if(hour<12)
			return "Good morning "+user;
		else if(hour<16)
			return "Good afternoon "+user;
		else if(hour<20)
			return "Good evening "+user;
		else
			return "Good night "+user;
	}
}
