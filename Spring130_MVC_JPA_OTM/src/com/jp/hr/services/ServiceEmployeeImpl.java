package com.jp.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
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
public class ServiceEmployeeImpl implements ServiceEmployee {
	
	private DaoEmployee daoEmp;
	
	public ServiceEmployeeImpl() throws HrException {
		//daoEmp = new DaoEmployeeImpl();
	}

	@Autowired
	public ServiceEmployeeImpl(@Qualifier("daoDS") DaoEmployee daoEmp) throws HrException {
		this.daoEmp = daoEmp;
	}
	
	@Override
	public List<Emp> getEmpList() throws HrException {
		return daoEmp.getEmpList();
	}

	@Override
	public List<Dept> getDeptList() throws HrException {
		return daoEmp.getDeptList();
	}

	@Override
	public Emp getEmpDetails(int empId) throws HrException {
		return daoEmp.getEmpDetails(empId);
	}

	@Override
	public Dept getDeptDetails(int deptId) throws HrException {
		return daoEmp.getDeptDetails(deptId);
	}
/*	@Override
	public boolean addNewEmployee(Emp emp) throws HrException {
		return daoEmp.insertNewRecord(emp);
	}*/

}
