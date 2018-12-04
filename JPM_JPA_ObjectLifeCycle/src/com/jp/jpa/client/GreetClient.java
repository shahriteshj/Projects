package com.jp.jpa.client;

import javax.persistence.EntityManager;

import com.jp.jpa.entities.Greet;
import com.jp.jpa.util.JPAUtil;

public class GreetClient {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Greet g = new Greet();
		g.setMessage("Welcome");
		
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		
		
		
		em.close();
		JPAUtil.closeFactory();
		
		
	}

}
