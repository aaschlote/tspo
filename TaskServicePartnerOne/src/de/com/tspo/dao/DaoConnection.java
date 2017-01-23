package de.com.tspo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoConnection {
	
	private EntityManagerFactory factory; 
	private EntityManager manager;
	
	public DaoConnection(){
		factory = new Persistence().createEntityManagerFactory("connection");
		manager = factory.createEntityManager();
	}

	public EntityManager getManager() {
		return manager;
	}

}
