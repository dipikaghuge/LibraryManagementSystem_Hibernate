package com.dipika.library.dao;

import java.util.List;

import com.dipika.library.entity.Student;

public interface StudentDao 
{
	String registerStudent(Student student);
	Student getStudentById(Integer studentId);
    List<Student> getAllStudents();

}
