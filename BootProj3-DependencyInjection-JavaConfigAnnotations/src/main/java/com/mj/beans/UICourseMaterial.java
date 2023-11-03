package com.mj.beans;

import javax.inject.Named;

@Named("ui")
public final class UICourseMaterial implements ICourseMaterial {

	@Override
	public String courseContent() {
		System.out.println("UICourseMaterial.courseContent()");
		return "1.HTML,2.JavaScript,3.React etc";
	}

	@Override
	public double price() {
		System.out.println("UICourseMaterial.price()");
		return 200;
	}
	public UICourseMaterial() {
		System.out.println("UICourseMaterial.UICourseMaterial()");
	}

}
