package com.jp.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.DaoEmployee;


@Repository("daoDS")
public class DaoEmployeeImplJPA implements DaoEmployee {


	private static final long serialVersionUID = -9033895157218277382L;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Emp> getEmpList() throws HrException {
		String sql = "SELECT e FROM empRecord e";
		TypedQuery<Emp> qry = entityManager.createQuery(sql, Emp.class);
		List<Emp> empList = qry.getResultList();
		return empList;
		
	}

	@Override
	public List<Dept> getDeptList() throws HrException {
		String sql = "SELECT d FROM deptRec d";
		TypedQuery<Dept> qry = entityManager.createQuery(sql, Dept.class);
		List<Dept> deptList = qry.getResultList();
		return deptList;
	}

	@Override
	public Emp getEmpDetails(int empId) throws HrException {
		Emp emp = entityManager.find(Emp.class, empId);
		return emp;
	}

/*	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		entityManager.persist(emp);
		Employee empNew = entityManager.find(Employee.class, emp.getEmpId());
		if(empNew !=null){
		return true;
		}else{
			return false;
		}
	}
*/
}
