package com.mj.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenerator {
	@Value("#{info.dosaPrice+info.idlyPrice+info.pohaPrice}")
	private double total;
	@Value("Paradise")
	private String hotelName;
	@Autowired
	private  ItemInfo itemInfo;
	
	@Override
	public String toString() {
		return "BillGenerator [total=" + total + ", hotelName=" + hotelName + ", itemInfo=" + itemInfo + "]";
	}
	
}
