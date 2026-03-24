package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.beans.Course;

public class CourseApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Course course = context.getBean("course", Course.class);

		System.out.println("Course Details:");
		System.out.println(course);

	}
}