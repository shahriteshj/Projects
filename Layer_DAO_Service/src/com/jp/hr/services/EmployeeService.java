package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;

public interface EmployeeService {
	public ArrayList<Employee> getEmpList() throws HRException;

}
