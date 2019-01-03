package com.jp.hr.daos;

import java.io.Serializable;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface IHrDao extends Serializable {

	public Employee getEmpDetails(int empNo) throws HrException;
	
}
