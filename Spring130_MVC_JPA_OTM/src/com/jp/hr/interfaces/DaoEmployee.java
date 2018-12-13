package com.jp.hr.interfaces;

import java.io.Serializable;
import java.util.List;

import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
import com.jp.hr.exceptions.HrException;

public interface DaoEmployee extends Serializable {
	public List<Emp> getEmpList() throws HrException;

	public List<Dept> getDeptList() throws HrException;

	public Emp getEmpDetails(int empId) throws HrException;
	/*
	 * public Employee getEmpDetails(int empId) throws HrException;
	 * 
	 * public boolean insertNewRecord(Employee emp) throws HrException;
	 */
}
