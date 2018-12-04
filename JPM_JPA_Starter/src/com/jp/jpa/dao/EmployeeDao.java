package com.jp.jpa.dao;

import java.util.List;

import com.jp.jpa.entities.Employee;
import com.jp.jpa.exception.EmployeeException;

public interface EmployeeDao {
	
	public Long addEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> getEmployeeList(Long employeeId) throws EmployeeException;
	
	public Employee getEmployeeById(Long empId)throws EmployeeException;//S-search

	public Employee updateEmployee(Employee employee)throws EmployeeException;//U-update
	
	public Long deleteEmployeeById(Long empId)throws EmployeeException;//D-delete
	
	public void commitTransaction();
	
	public void beginTransaction();

}
