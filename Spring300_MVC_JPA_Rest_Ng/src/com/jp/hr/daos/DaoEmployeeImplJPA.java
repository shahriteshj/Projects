package com.jp.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.DaoEmployee;


@Repository("daoDS")
public class DaoEmployeeImplJPA implements DaoEmployee {


	private static final long serialVersionUID = -9033895157218277382L;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmpList() throws HrException {
		String sql = "SELECT e FROM empRec e";
		TypedQuery<Employee> qry = entityManager.createQuery(sql, Employee.class);
		List<Employee> empList = qry.getResultList();
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		return entityManager.find(Employee.class, empId);
		
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		entityManager.persist(emp);
		Employee empNew = entityManager.find(Employee.class, emp.getEmpId());
		if(empNew !=null){
		return true;
		}else{
			return false;
		}
	}

}
