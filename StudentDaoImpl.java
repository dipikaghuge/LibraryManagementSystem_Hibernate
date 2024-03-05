package com.dipika.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.dipika.library.entity.Student;

public class StudentDaoImpl implements StudentDao
{
	EntityManager entityManager=MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction=entityManager.getTransaction();
    Query query;

	public String registerStudent(Student student) 
	{
	    entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();				
		return "Student Regestration done\nStudentId :"+student.getStudentId();
	}
	public Student getStudentById(Integer studentId) 
	{
		return entityManager.find(Student.class, studentId);
	}
	public List<Student> getAllStudents() {
		String jpql="select s from Student s";
		query=entityManager.createQuery(jpql);
		List<Student> list=query.getResultList();
		return list;
	}

}
