package com.mj.beans;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Named("stud")
public final class Student {
	//@Inject
	@Resource(name = "courseId")
	//@Named("courseId")
	ICourseMaterial material;//HAS-A property
	public Student() {
		System.out.println("Student.Student()");
	}
	public void preparation(String examName)
	{
		System.out.println("Preparation started for "+examName);
		String courseContent=material.courseContent();
		double price =material.price();
		System.out.println("preparation is going on for "+examName+" with course content "+courseContent+" and price "+price);
		System.out.println("Preparation for "+examName+" completed");
	}

}
