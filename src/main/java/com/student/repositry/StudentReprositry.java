package com.student.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Student;

public interface StudentReprositry extends JpaRepository<Student, String> {

}
