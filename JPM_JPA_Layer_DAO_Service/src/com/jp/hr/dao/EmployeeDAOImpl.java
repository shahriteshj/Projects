package com.jp.hr.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;
import com.jp.hr.utilities.JPAUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl() throws HRException {
		entityManager = JPAUtil.getEntityManager();

	}

	@Override
	public ArrayList<Employee> getEmployeeList() throws HRException {
		TypedQuery<Employee> q = entityManager.createQuery("from Employee",Employee.class);
		return (ArrayList<Employee>)q.getResultList();
	}

	@Override
	public Employee getEmpDetails(int empId) throws HRException {
		return entityManager.find(Employee.class, empId);
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HRException {
		entityManager.persist(emp);
		return true;
	}
	
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

}
