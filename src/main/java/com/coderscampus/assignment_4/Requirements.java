package com.coderscampus.assignment_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

		List<Student> finalCleanedCompSci = Arrays.stream(cleanedCompSci).collect(Collectors.toList());

		finalCleanedCompSci.sort((o2, o1) -> o1.getGrade().compareTo(o2.getGrade()));

		Student[] finalCleanedCompSciArray = finalCleanedCompSci.toArray(new Student[0]);

		try {

			writer = new BufferedWriter(new FileWriter("compsci-student-master.csv"));
			writer.write("Student Id,Student Name,Course,Grade\n");
			for (int d = 0; d < finalCleanedCompSciArray.length; d++) {

				writer.write(
						finalCleanedCompSciArray[d].getStudentId() + "," + finalCleanedCompSciArray[d].getStudentname()
								+ "," + finalCleanedCompSciArray[d].getCoursename() + ","
								+ finalCleanedCompSciArray[d].getGrade() + "\n");
			}
		} finally {
			System.out.println(" Program as created CompSci-Student-Master.csv ");
			writer.close();
		}

		BufferedWriter writer1 = null;

		Student[] cleanedStat = Arrays.stream(stat).filter(Objects::nonNull).toArray(Student[]::new);

		List<Student> finalCleanedStat = Arrays.stream(cleanedStat).collect(Collectors.toList());

		finalCleanedStat.sort((o2, o1) -> o1.getGrade().compareTo(o2.getGrade()));

		Student[] finalCleanedStatArray = finalCleanedStat.toArray(new Student[0]);

		try {

			writer1 = new BufferedWriter(new FileWriter("stat-student-master.csv"));
			writer1.write("Student Id,Student Name,Course,Grade\n");
			for (int a = 0; a < finalCleanedStatArray.length; a++) {

				writer1.write(finalCleanedStatArray[a].getStudentId() + "," + finalCleanedStatArray[a].getStudentname()
						+ "," + finalCleanedStatArray[a].getCoursename() + "," + finalCleanedStatArray[a].getGrade()
						+ "\n");
			}
		} finally {
			System.out.println(" Program as created Stat-Student-Master.csv ");
			writer1.close();
		}

		BufferedWriter writer2 = null;

		Student[] cleanedApmth = Arrays.stream(apmth).filter(Objects::nonNull).toArray(Student[]::new);

		List<Student> finalCleanedApmth = Arrays.stream(cleanedApmth).collect(Collectors.toList());

		finalCleanedApmth.sort((o2, o1) -> o1.getGrade().compareTo(o2.getGrade()));

		Student[] finalCleanedApmthArray = finalCleanedApmth.toArray(new Student[0]);
		try {

			writer2 = new BufferedWriter(new FileWriter("apmth-student-master.csv"));
			writer2.write("Student Id,Student Name,Course,Grade\n");
			for (int k = 0; k < finalCleanedApmthArray.length; k++) {

				writer2.write(finalCleanedApmthArray[k].getStudentId() + "," + finalCleanedApmthArray[k].getStudentname() + ","
						+ finalCleanedApmthArray[k].getCoursename() + "," + finalCleanedApmthArray[k].getGrade() + "\n");
			}
		} finally {
			System.out.println(" Program as created Apmth-Student-Master.csv ");
			writer2.close();
		}

	}

}
