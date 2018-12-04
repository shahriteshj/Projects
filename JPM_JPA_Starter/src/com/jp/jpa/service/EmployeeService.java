package com.jp.jpa.service;

import java.util.List;

import com.jp.jpa.entities.Employee;
import com.jp.jpa.exception.EmployeeException;

public interface EmployeeService {
	
	public Long addEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> getEmployeeList() throws EmployeeException;
	
	public Employee getEmployeeById(Long empId)throws EmployeeException;//S-search

	public Employee updateEmployee(Employee employee)throws EmployeeException;//U-update
	
	public Long deleteEmployeeById(Long empId)throws EmployeeException;//D-delete
	

}
