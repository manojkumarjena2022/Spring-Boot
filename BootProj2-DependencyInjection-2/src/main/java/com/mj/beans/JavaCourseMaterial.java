package com.mj.beans;

import org.springframework.stereotype.Component;

@Component("java")
public final class JavaCourseMaterial implements ICourseMaterial {

	@Override
	public String courseContent() {
		System.out.println("JavaMaterial.courseContent()");
		return "1.OOPS Concept, 2.Exception Handling, 3.Collection Framework";
	}

	@Override
	public double price() {
		System.out.println("JavaMaterial.price()");
		return 400;
	}
	public JavaCourseMaterial() {
		System.out.println("JavaMaterial.JavaMaterial()");
	}

}
