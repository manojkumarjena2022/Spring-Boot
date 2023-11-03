package com.mj.beans;

import javax.inject.Named;

@Named("dotNet")
public final class DotNetCourseMaterial implements ICourseMaterial {

	@Override
	public String courseContent() {
		System.out.println("DotNetCourseMaterial.courseContent()");
		return "1.c#,2.oops,3.Exception Handling etc";
	}

	@Override
	public double price() {
		System.out.println("DotNetCourseMaterial.price()");
		return 500;
	}
	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial.DotNetCourseMaterial()");
	}

}
