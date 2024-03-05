package com.dipika.library.service;

import java.util.List;

import com.dipika.library.entity.Student;

public interface StudentService 
{
	String registerStudent(Student student);
	Student getStudentById(Integer studentId);
    List<Student> getAllStudents();

}
