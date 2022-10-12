package com.coderscampus.assignment_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import com.coderscampus.myapp.service.StudentService;

public class Requirements {

	public static void main(String[] args) throws IOException {

		BufferedReader studentInfo = null;

		Student[] allStudents = new Student[100];
		Student[] compSci = new Student[101];
		Student[] stat = new Student[101];
		Student[] apmth = new Student[101];

		int i = 0;
		int j = 0;

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
		} finally {
			if (studentInfo != null)
				studentInfo.close();
		}

		BufferedWriter writer = null;

		Student[] cleanedCompSci = Arrays.stream(compSci).filter(Objects::nonNull).toArray(Student[]::new);
		try {

			writer = new BufferedWriter(new FileWriter("compsci-student-master.txt"));
			writer.write("Student Id | Student Name | Course | Grade\n");
			for (int d = 0; d < cleanedCompSci.length; d++) {

				writer.write(cleanedCompSci[d].getStudentId() + " | " + cleanedCompSci[d].getStudentname() + " | "
						+ cleanedCompSci[d].getCoursename() + " | " + cleanedCompSci[d].getGrade() + "\n");
			}
		} finally {
			writer.close();
		}

		BufferedWriter writer1 = null;

		Student[] cleanedStat = Arrays.stream(stat).filter(Objects::nonNull).toArray(Student[]::new);
		try {

			writer1 = new BufferedWriter(new FileWriter("stat-student-master.txt"));
			writer1.write("Student Id | Student Name | Course | Grade\n");
			for (int a = 0; a < cleanedStat.length; a++) {

				writer1.write(cleanedStat[a].getStudentId() + " | " + cleanedStat[a].getStudentname() + " | "
						+ cleanedStat[a].getCoursename() + " | " + cleanedStat[a].getGrade() + "\n");
			}
		} finally {
			writer1.close();
		}

		BufferedWriter writer2 = null;

		Student[] cleanedApmth = Arrays.stream(apmth).filter(Objects::nonNull).toArray(Student[]::new);
		try {

			writer2 = new BufferedWriter(new FileWriter("apmth-student-master.txt"));
			writer2.write("Student Id | Student Name | Course | Grade\n");
			for (int k = 0; k < cleanedApmth.length; k++) {

				writer2.write(cleanedApmth[k].getStudentId() + " | " + cleanedApmth[k].getStudentname() + " | "
						+ cleanedApmth[k].getCoursename() + " | " + cleanedApmth[k].getGrade() + "\n");
			}
		} finally {
			writer2.close();
		}

	}

}
