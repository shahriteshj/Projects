package com.jp.jpa.client;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jp.jpa.entity.Department;
import com.jp.jpa.entity.Employee;
import com.jp.jpa.util.JPAUtil;

public class OTM_Client {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
	/*	Department department = new Department();
		department.setDeptId(20l);
		department.setDeptName("IT");
		
		Employee e1 = new Employee();
		e1.setEmpId(101l);
		e1.setEmpName("John");
		e1.setEmpSal(500.99);
		e1.setDepartment(department);
		
		Employee e2 = new Employee();
		e2.setEmpId(102l);
		e2.setEmpName("Will");
		e2.setEmpSal(1500.0);
		e2.setDepartment(department);
		
		
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(e1);
		employees.add(e2);
		
		department.setEmployeeSet(employees);*/
		
		
		
		em.getTransaction().begin();
		Department department = em.find(Department.class, 20L);
		//department.setDeptId(30L);
		department.setDeptName("IT");
		System.out.println(department.getEmployeeSet());
		//em.persist(department);
		em.merge(department);
		em.getTransaction().commit();
		em.close();
	}

}
