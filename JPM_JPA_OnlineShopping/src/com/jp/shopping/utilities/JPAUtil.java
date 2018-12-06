package com.jp.shopping.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	static { // static block to initialize only static variable
		// invoked before object creation i.e. before constructor
		factory = Persistence.createEntityManagerFactory("JPA-PU");
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	
	public static void closeFactory() {
		if (factory == null || !factory.isOpen()) {
			factory.close();
		}
	}
}
