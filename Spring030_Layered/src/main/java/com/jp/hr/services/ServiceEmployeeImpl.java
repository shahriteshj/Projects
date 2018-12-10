package com.jp.hr.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.DaoEmployee;

/*
 * One layer refers to another layer through interface only.
 * Implementation if business rules should be done here in absence of Business Layer.
 * This layer will also ensure only custom exceptions to come out.
 * 
 * Features:
 * 		* Only one gateway with preserving privacy of all inner classes.
 * 		* One point for implementing security, transaction management, Caching.
 * 		* Multiple interfaces per client to give restricted view of all services.
 * 		* Facade pattern. (GoF pattern)(One point to connect to multiple services)
 * 		* DAO is a JEE pattern.
 * 		* Implemented singleton by creating single object of outermost class.
 * 		* Delegates and controls Cross Cutting Concerns.
 */

@Service("service")
public class ServiceEmployeeImpl implements ServiceEmployee, Role1 {
	
	private DaoEmployee daoEmp;
	
	public ServiceEmployeeImpl() throws HrException {
		//daoEmp = new DaoEmployeeImpl();
	}

	@Autowired
	public ServiceEmployeeImpl(@Qualifier("daoDS") DaoEmployee daoEmp) throws HrException {
		this.daoEmp = daoEmp;
	}
	
	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
		return daoEmp.getEmpList();
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		return daoEmp.getEmpDetails(empId);
	}

	@Override
	public boolean addNewEmployee(Employee emp) throws HrException {
		return daoEmp.insertNewRecord(emp);
	}

}
