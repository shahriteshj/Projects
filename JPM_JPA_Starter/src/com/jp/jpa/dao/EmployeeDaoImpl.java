package com.jp.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.jp.jpa.entities.Employee;
import com.jp.jpa.exception.EmployeeException;
import com.jp.jpa.util.JPAUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	public EmployeeDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		entityManager.persist(employee);
		return employee.getEmployeeId();
	}

	@Override
	public List<Employee> getEmployeeList(Long employeeId) throws EmployeeException {
		//entityManager.persist(employee);
		return null;
	}

	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		return entityManager.find(Employee.class, empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		return entityManager.merge(employee);
	}

	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		Employee e = getEmployeeById(empId);
		entityManager.remove(e);
		return e.getEmployeeId();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().commit();
		
	}

}
