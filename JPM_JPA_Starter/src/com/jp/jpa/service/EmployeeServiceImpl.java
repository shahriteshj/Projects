package com.jp.jpa.service;

import java.util.List;
import com.jp.jpa.dao.EmployeeDao;
import com.jp.jpa.dao.EmployeeDaoImpl;
import com.jp.jpa.entities.Employee;
import com.jp.jpa.exception.EmployeeException;


public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao.beginTransaction();
		employeeDao = new EmployeeDaoImpl();
		employeeDao.commitTransaction();
	}
	
	
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		employeeDao.beginTransaction();
		Long empId =  employeeDao.addEmployee(employee);
		employeeDao.commitTransaction();
		return empId;
		
	}

	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		employeeDao.beginTransaction();
		employeeDao.commitTransaction();
		return null;
	}


	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		employeeDao.beginTransaction();
		Employee emp = employeeDao.getEmployeeById(empId);
		employeeDao.commitTransaction();
		return emp;
	}


	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		employeeDao.beginTransaction();
		Employee emp =  employeeDao.updateEmployee(employee);
		employeeDao.commitTransaction();
		return emp;
	}


	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		employeeDao.beginTransaction();
		empId =  employeeDao.deleteEmployeeById(empId);
		employeeDao.commitTransaction();
		return empId;
	}
	
	

}
