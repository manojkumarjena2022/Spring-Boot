package com.mj.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stud")
public final class Student {
	@Autowired
	//@Qualifier("java")
	//@Qualifier("${course.choose}")//error
	//@Qualifier(Value("${course.choose}"))//error
	@Qualifier("courseId")
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
