package com.jp.hr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jp.hr.daos.IHrDao;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

@Service("hrService")
public class HrService implements IHrService {

	private static final long serialVersionUID = 5299475650203080069L;

	@Autowired(required=true)
	@Qualifier("hrDao")
	private IHrDao hrDao;
	
	@Override
	public Employee getEmpDetails(int empNo) throws HrException {
		return hrDao.getEmpDetails(empNo);
	}

}
