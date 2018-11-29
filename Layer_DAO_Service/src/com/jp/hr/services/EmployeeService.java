package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;

public interface EmployeeService {
	public ArrayList<Employee> getEmpList() throws HRException;

	public Employee getEmpDetails(int empId) throws HRException;

	public boolean joinNewEmployee(Employee emp) throws HRException;

}
