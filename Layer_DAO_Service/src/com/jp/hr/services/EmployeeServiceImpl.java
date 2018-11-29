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
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getEmployeeList();
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empId) throws HRException {
		return empDAO.getEmpDetails(empId);
	}

	@Override
	public boolean joinNewEmployee(Employee emp) throws HRException {
		return empDAO.insertNewRecord(emp);
	}

}
