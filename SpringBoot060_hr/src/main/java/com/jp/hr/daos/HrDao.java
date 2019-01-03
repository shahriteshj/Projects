package com.jp.hr.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

@Repository("hrDao")
public class HrDao implements IHrDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7247112152146450033L;

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Employee getEmpDetails(int empNo) throws HrException {
		
		Employee emp = em.find(Employee.class, empNo);
		return emp;
	}

}
