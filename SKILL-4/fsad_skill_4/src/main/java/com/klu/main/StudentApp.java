package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.beans.Course;
import com.klu.beans.Student;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student st = context.getBean("stud", Student.class);
		System.out.println("Student Details: ");
		st.display();
	}
}