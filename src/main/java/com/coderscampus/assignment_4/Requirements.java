package com.coderscampus.assignment_4;

import java.io.IOException;


import com.coderscampus.myapp.service.FileService;
import com.coderscampus.myapp.service.StudentService;

public class Requirements {
	
	public static void main(String[] args) throws IOException {
		
		StudentService studentService = new StudentService(); 
		FileService fileService = new FileService();

		fileService.readStudentFileToArrays(); 
		fileService.sortStudentsIntoCorrectClass();

		Student[] finalCleanedCompSciArray = studentService.compSciSort(fileService.getCompSciStudents());
		Student[] finalCleanedStatArray = studentService.statSort(fileService.getStatStudents());
		Student[] finalCleanedApmthArray = studentService.apmthSort(fileService.getApmthStudents());

		fileService.writeStudentArrayToFile("compsci-student-master.csv", finalCleanedCompSciArray);
		fileService.writeStudentArrayToFile("apmth-student-master.csv", finalCleanedStatArray);
		fileService.writeStudentArrayToFile("stat-student-master.csv", finalCleanedApmthArray);
		
	}
	
}
