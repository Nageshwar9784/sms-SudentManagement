package com.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repositry.StudentReprositry;



@Service
public class StudentServicesImp implements StudentServices {


	StudentReprositry srepo;

	public StudentServicesImp(StudentReprositry srepo) {
		super();
		this.srepo = srepo;
	}
	public String addStudent(Student s) {
		srepo.save(s);
		return "Student Added";

	}
	public Student getStudent(String kodId) {
		
		Student st=srepo.findById(kodId).get();
		return st;

	}
	public List<Student> getAllStudents(){
		List<Student> slist=srepo.findAll();
		return slist;

	}
	public String updateStudent(Student s) {
		srepo.save(s);

		return "Student Updated";

	}
	public String deleteStudent(String kodId) {
		srepo.deleteById(kodId);

		return "Student Deleted!";

	}

}
