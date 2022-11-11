package com.coderscampus.assignment_4;

import java.io.IOException;


import com.coderscampus.myapp.service.FileService;
import com.coderscampus.myapp.service.StudentService;

public class Requirements {
	
	public static void main(String[] args) throws IOException {

		Student[] allStudents = new Student[100];
		Student[] compSci = new Student[101];
		Student[] stat = new Student[101];
		Student[] apmth = new Student[101];
		
		StudentService studentService = new StudentService(); 
		FileService fileService = new FileService();

		fileService.readStudentFileToArrays(); 
		
		fileService.sortStudentsIntoCorrectClass();

		Student[] finalCleanedCompSciArray = studentService.compSciSort(fileService.getCompSciStudents());
		Student[] finalCleanedStatArray = studentService.statSort(stat);
		Student[] finalCleanedApmthArray = studentService.apmthSort(apmth);

		fileService.writeStudentArrayToFile("compsci-student-master.csv", finalCleanedCompSciArray);
		fileService.writeStudentArrayToFile("apmth-student-master.csv", finalCleanedStatArray);
		fileService.writeStudentArrayToFile("stat-student-master.csv", finalCleanedApmthArray);
		
	}
	
}
