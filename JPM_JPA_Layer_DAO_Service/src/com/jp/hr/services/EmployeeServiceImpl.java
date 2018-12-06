package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.dao.EmployeeDAO;
import com.jp.hr.dao.EmployeeDAOImpl;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDAO;

	public EmployeeServiceImpl() throws HRException {
		empDAO = new EmployeeDAOImpl();
	}

	@Override
	public ArrayList<Employee> getEmpList() throws HRException {
		empDAO.beginTransaction();
		ArrayList<Employee> employees = empDAO.getEmployeeList(); 
		empDAO.commitTransaction();
		return employees;
	}

	@Override
	public Employee getEmpDetails(int empId) throws HRException {
		empDAO.beginTransaction();
		Employee employee = empDAO.getEmpDetails(empId); 
		empDAO.commitTransaction();
		return employee;
	}

	@Override
	public boolean joinNewEmployee(Employee emp) throws HRException {
		empDAO.beginTransaction();
		empDAO.insertNewRecord(emp); 
		empDAO.commitTransaction();
		return true;
	}

}
