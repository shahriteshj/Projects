package com.jp.jpa.client;

import javax.persistence.EntityManager;

import com.jp.jpa.entity.Address;
import com.jp.jpa.entity.Employee;
import com.jp.jpa.util.JPAUtil;

public class OTOClient {
	
	public static void main(String[] args) {
	
		EntityManager em = JPAUtil.getEntityManager();
		
		Address a = new Address();
		a.setAddressId(1L);
		a.setCity("Mumbai");
		a.setState("Maharashtra");
		a.setStreet("Marol");
		a.setZipcode("400060");
		
		Employee e = new Employee();
		e.setEmpId(3L);
		e.setEmpName("John");
		e.setEmpSal(123456D);
		e.setAddress(a);
		
		a.setEmployee(e);
		
		Address a1 = new Address();
		a1.setAddressId(1L);
		a1.setCity("Mumbai");
		a1.setState("Maharashtra");
		a1.setStreet("Marol");
		a1.setZipcode("400060");
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
	}
	

}
