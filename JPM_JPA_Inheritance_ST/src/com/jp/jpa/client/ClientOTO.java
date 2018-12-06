package com.jp.jpa.client;

import javax.persistence.EntityManager;
import com.jp.jpa.entity.Employee;
import com.jp.jpa.entity.Manager;
import com.jp.jpa.entity.SalesManager;
import com.jp.jpa.util.JPAUtil;

public class ClientOTO {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Employee e1 = new Employee();
		e1.setEmpName("John");
		e1.setEmpSal(99D);
		
		
		Manager m1 = new Manager();
		m1.setEmpName("Smith");
		m1.setEmpSal(88D);
		m1.setBonus(55D);
		
		SalesManager salesMgr = new SalesManager();
		salesMgr.setEmpName("Will");
		salesMgr.setEmpSal(77D);
		salesMgr.setBonus(55D);
		salesMgr.setCommission(10D);
		
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
		
		
		em.getTransaction().begin();
		em.persist(m1);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.persist(salesMgr);
		em.getTransaction().commit();
		
	}

}
