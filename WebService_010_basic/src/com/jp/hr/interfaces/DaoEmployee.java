package com.jp.hr.interfaces;

import java.util.List;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface DaoEmployee {
	public List<Employee> getEmpList() throws HrException;

	public Employee getEmpDetails(int empId) throws HrException;

	public boolean insertNewRecord(Employee emp) throws HrException;
}
