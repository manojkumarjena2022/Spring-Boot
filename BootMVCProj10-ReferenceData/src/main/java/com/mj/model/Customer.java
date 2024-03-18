package com.mj.model;


import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String gender="Male";
	private String country="India";
	private String[] languages=new String[]{"Hindi","English"};
	private String[] hobbies=new String[] {"Playing Cricket","Dancing"};
}
