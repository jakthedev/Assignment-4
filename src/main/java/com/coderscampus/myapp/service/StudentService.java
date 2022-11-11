package com.coderscampus.myapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors; 

import com.coderscampus.assignment_4.Student;

public class StudentService {

	public static Student createStudent(Integer studentId, String studentname, 
			String coursename, Integer grade) 
	{
		Student student = new Student(); 
		student.setStudentId(studentId); 
		student.setStudentName(studentname); 
		student.setCoursename(coursename);  
		student.setGrade(grade); 
		return student;
	}
	
	public Student createStudent(String[] allStudentInfo) 
	{
		Student student = new Student(); 
		student.setStudentId(Integer.valueOf(allStudentInfo[0])); 
		student.setStudentName(allStudentInfo[1]); 
		student.setCoursename(allStudentInfo[2]);  
		student.setGrade(Integer.valueOf(allStudentInfo[3]));
		return student;
	}
	
	public Student[] compSciSort(Student[] compSci) 
	{
		Student[] cleanedCompSci = Arrays.stream(compSci).filter(Objects::nonNull).toArray(Student[]::new);

		List<Student> finalCleanedCompSci = Arrays.stream(cleanedCompSci).collect(Collectors.toList());

		finalCleanedCompSci.sort((o2, o1) -> o1.getGrade().compareTo(o2.getGrade()));

		Student[] finalCleanedCompSciArray = finalCleanedCompSci.toArray(new Student[0]);
		return finalCleanedCompSciArray;
	}
	
	public Student[] statSort(Student[] stat) 
	{
		Student[] cleanedStat = Arrays.stream(stat).filter(Objects::nonNull).toArray(Student[]::new);

		List<Student> finalCleanedStat = Arrays.stream(cleanedStat).collect(Collectors.toList());

		finalCleanedStat.sort((o2, o1) -> o1.getGrade().compareTo(o2.getGrade()));

		Student[] finalCleanedStatArray = finalCleanedStat.toArray(new Student[0]);
		return finalCleanedStatArray;
	}
	
	public Student[] apmthSort(Student[] apmth) 
	{
		Student[] cleanedApmth = Arrays.stream(apmth).filter(Objects::nonNull).toArray(Student[]::new);

		List<Student> finalCleanedApmth = Arrays.stream(cleanedApmth).collect(Collectors.toList());

		finalCleanedApmth.sort((o2, o1) -> o1.getGrade().compareTo(o2.getGrade()));

		Student[] finalCleanedApmthArray = finalCleanedApmth.toArray(new Student[0]);
		return finalCleanedApmthArray;
	}
	
}
