package com.coderscampus.myapp.service;

import com.coderscampus.assignment_4.Student;

public class StudentService {

	public static Student createStudent(Integer studentId, String studentname, 
			String coursename, Integer grade) {
		
		Student student = new Student(); 
		student.setStudentId(studentId); 
		student.setStudentName(studentname); 
		student.setCoursename(coursename);  
		student.setGrade(grade); 
		return student;
	}
}
