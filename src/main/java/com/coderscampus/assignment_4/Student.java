package com.coderscampus.assignment_4;

public class Student {
	private String studentname; 
	private String coursename; 
	private Integer grade; 
	private Integer studentId;
	
	public String getStudentname() {
		return studentname;
	} 
	
	public void setStudentName(String studentname) {
		this.studentname = studentname;
	}
	
	public String getCoursename( ) {
		return coursename;
	} 
	
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Integer getGrade( ) {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public Integer getStudentId( ) {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
}
