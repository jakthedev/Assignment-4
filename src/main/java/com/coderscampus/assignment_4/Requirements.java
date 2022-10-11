package com.coderscampus.assignment_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.coderscampus.myapp.service.StudentService;

public class Requirements {

	public static void main(String[] args) throws IOException {

		BufferedReader studentInfo = null;
		Integer stuIdandGrade;
		Student[] allStudents = new Student[100];
		int i = 0;
		try {
			studentInfo = new BufferedReader(new FileReader("student-master-list.csv"));
			studentInfo.readLine();
			while (i < 100) {
				String info = studentInfo.readLine();
				String[] allStudentInfo = info.split(",");

//				for (String data : allStudentInfo) {
//					Boolean numMatch = data.matches("^[1-9][0-9]?$|^100$");
//
//					if (numMatch) {
//						Integer intData = Integer.valueOf(data);
//						stuIdandGrade = intData;
//					}
//				}
				
				Student student = StudentService.createStudent(Integer.valueOf(
						allStudentInfo[0]), 
						allStudentInfo[1],
						allStudentInfo[2],
						Integer.valueOf(allStudentInfo[3]));

				allStudents[i++] = student; 
				System.out.println(i);

			}

		} finally {
			if (studentInfo != null)
				studentInfo.close();
		}

	}

}
