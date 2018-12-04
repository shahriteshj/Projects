package com.jp.jpa.client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jp.jpa.entities.Employee;

public class EmployeeJPAClient {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Employee Name: ");
		String empName = scan.next();
		System.out.println("Enter Employee Salary: ");
		double empSal = scan.nextDouble();

		String persistenceUnitName = "JPA-PU";

		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emFactory.createEntityManager();
		Employee e = new Employee(empName, empSal);

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();

		Employee e1 = em.find(Employee.class, e.getEmployeeId());
		System.out.println("Employee: " + e1.toString());

		em.close();
		emFactory.close();
		scan.close();

	}

}
