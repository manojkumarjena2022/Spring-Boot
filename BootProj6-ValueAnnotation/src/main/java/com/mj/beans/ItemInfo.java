package com.mj.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("info")
@PropertySource("com/mj/commons/input.properties")
public class ItemInfo {
	@Value("${dosa.price}")
	public double dosaPrice;
	@Value("${idly.price}")
	public double idlyPrice;
	@Value("${poha.price}")
	public double pohaPrice;
	
	@Override
	public String toString() {
		return "ItemInfo [dosaPrice=" + dosaPrice + ", idlyPrice=" + idlyPrice + ", pohaPrice=" + pohaPrice + "]";
	}
	
	
}
