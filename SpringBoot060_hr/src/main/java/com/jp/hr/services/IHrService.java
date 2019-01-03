package com.jp.hr.services;

import java.io.Serializable;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface IHrService extends Serializable {
	
	public Employee getEmpDetails(int empNo) throws HrException;
	
}
