package com.coderscampus.assignment_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.coderscampus.myapp.service.StudentService;

public class Requirements {

//	public String filterStudents() throws IOException {
//		BufferedReader studentInfo = null; 
//		
//		try {
//			studentInfo = new BufferedReader(new FileReader("student-master-list.csv"));
//			System.out.println(studentInfo.readLine());
//		} finally {
//			if (studentInfo != null ) studentInfo.close();
//		}
//	}

	public static void main(String[] args) throws IOException {
		// I need to separate data into 3 different CVS files, each file should contain
		// a list of students
		// specific to that particular course (grouping the students by course)

		// for each of the 3 CVS files, need to sort the students by grade in descending
		// order

		// need to import the data from CVS, sort the data, then create new files with
		// the appropriate information
		// in the file

		BufferedReader studentInfo = null; 
		Boolean matchFound;
		Integer[] numMatch = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Student[] allStudents = new Student[100];

		try {
			studentInfo = new BufferedReader(new FileReader("student-master-list.csv"));
			while (studentInfo.readLine() != null) {
				String info = studentInfo.readLine();
				String[] allStudentInfo = info.split(",");   
				
				for (String data : allStudentInfo ) {
					for (int i = 0; i < numMatch.length; i++) {
					if ( Integer.valueOf(data)== numMatch[i]) {
						Integer intData = Integer.valueOf(data);
						
				Student students = StudentService.createStudent(allStudentInfo[intData], allStudentInfo[1],
								allStudentInfo[2], allStudentInfo[intData]); 
				allStudents[i] = students;
					}
					
					//Student students = StudentService.createStudent()
					}
				}
				
				Student students = StudentService.createStudent(allStudentInfo[0], allStudentInfo[1],
						allStudentInfo[2], allStudentInfo[3]);
				for (String st : finalStudentInfo) {
				System.out.println(st);
				}
			}
		} finally {
			if (studentInfo != null)
				studentInfo.close();
		}
		
		
	}

}
