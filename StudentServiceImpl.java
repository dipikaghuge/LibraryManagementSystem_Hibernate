package com.dipika.library.service;

import java.util.List;

import com.dipika.library.dao.StudentDao;
import com.dipika.library.dao.StudentDaoImpl;
import com.dipika.library.entity.Student;

public class StudentServiceImpl implements StudentService
{
    StudentDao studentDao=new StudentDaoImpl();
    
	public Student getStudentById(Integer studentId) 
	{
		return studentDao.getStudentById(studentId);
	}
	public String registerStudent(Student student) 
	{
		return studentDao.registerStudent(student);
	}
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

}
