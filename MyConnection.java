package com.dipika.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection 
{
  private MyConnection() {}
 
	
	private static EntityManagerFactory entityManagerFactory; //object create
	private static EntityManager entityManager;
	
	//we used entity manager getEntityManagerObject method
	public static EntityManager getEntityManagerObject() {
		if(entityManager==null) {
			entityManagerFactory=Persistence.createEntityManagerFactory("Dipu");
			entityManager=entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
