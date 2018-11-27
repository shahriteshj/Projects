package com.jp.hr.dao;

import java.util.ArrayList;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HRException;

public interface EmployeeDAO {

	public ArrayList<Employee> getEmployeeList() throws HRException;
}
