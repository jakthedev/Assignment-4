package com.coderscampus.myapp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.coderscampus.assignment_4.Student;

public class FileService {

	BufferedWriter writer = null;
	BufferedReader studentInfo = null;
	
	Student[] allStudents = new Student[100];
	Student[] compSci = new Student[101];
	Student[] stat = new Student[101];
	Student[] apmth = new Student[101];

	int i = 0;
	int j = 0;

	public void writeStudentArrayToFile(String fileName, Student[] students) throws IOException {

		try {

			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("Student Id,Student Name,Course,Grade\n");
			for (int d = 0; d < students.length; d++) {

				writer.write(students[d].getStudentId() + "," + students[d].getStudentname() + ","
						+ students[d].getCoursename() + "," + students[d].getGrade() + "\n");
			}

		} catch (IOException e) {
			System.out.println(e);
		} finally {

			if (writer != null) {
				writer.close();
			}

		}
	}

	public Student[] readStudentFileToArrays() throws IOException {

		try {
			studentInfo = new BufferedReader(new FileReader("student-master-list.csv"));
			studentInfo.readLine();

			while (i < 100) {
				String info = studentInfo.readLine();

				String[] allStudentInfo = info.split(",");

				Student student = StudentService.createStudent(Integer.valueOf(allStudentInfo[0]), allStudentInfo[1],
						allStudentInfo[2], Integer.valueOf(allStudentInfo[3]));

				allStudents[i++] = student;
			}

		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (studentInfo != null) {
				studentInfo.close();
			}
		}
		return allStudents;

	}
	
	public void sortStudentsIntoCorrectClass() {
	
		for (Student stu : allStudents) {
		
						if (stu.getCoursename().startsWith("COMP")) {
							compSci[j] = stu;
							stu = allStudents[j];
							j++;
						}
						if (stu.getCoursename().startsWith("STAT")) {
							stat[j] = stu;
							stu = allStudents[j];
							j++;
						}
						if (stu.getCoursename().startsWith("APMTH")) {
							apmth[j] = stu;
							stu = allStudents[j];
							j++;
						}
					}
	}
	
	public Student[] getCompSciStudents() {
		return compSci;
	}
	
	

}
