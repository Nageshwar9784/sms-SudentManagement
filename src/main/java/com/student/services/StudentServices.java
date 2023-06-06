package com.student.services;

import java.util.List;

import com.student.entity.Student;

public interface StudentServices {
	
	String addStudent(Student s);
	Student getStudent(String kodId);
	List<Student> getAllStudents();
	String updateStudent(Student s);
	String deleteStudent(String kodId);
	
}
	