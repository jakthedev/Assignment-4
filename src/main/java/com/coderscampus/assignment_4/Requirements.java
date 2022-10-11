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
		Student[] compSci = new Student[101];
		Student[] stat = new Student[101];
		Student[] apmth = new Student[101];

		int i = 0;
		
		try {
			studentInfo = new BufferedReader(new FileReader("student-master-list.csv"));
			studentInfo.readLine();
			while (i < 100) {
				String info = studentInfo.readLine();
				String[] allStudentInfo = info.split(",");

				Student student = StudentService.createStudent(Integer.valueOf(allStudentInfo[0]), allStudentInfo[1],
						allStudentInfo[2], Integer.valueOf(allStudentInfo[3]));

				allStudents[i++] = student;
				System.out.println(i);
			}

			

				for (Student stu : allStudents) {

					for (int j = 0; j < allStudents.length; j++) {

						if (stu.getCoursename().startsWith("COMP")) {
							compSci[j++] = stu;
							stu = allStudents[j++];

						}
						if (stu.getCoursename().startsWith("STAT")) {
							stat[j++] = stu;
							stu = allStudents[j++];

						}
						if (stu.getCoursename().startsWith("APMTH")) {
							apmth[j++] = stu;
							stu = allStudents[j++];

						} 
					}
				}
			

		} finally {
			if (studentInfo != null)
				studentInfo.close();
		}
	}

}
