package com.jp.jpa.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jp.jpa.dao.EmployeeDao;
import com.jp.jpa.dao.EmployeeDaoImpl;
import com.jp.jpa.entities.Employee;
import com.jp.jpa.exception.EmployeeException;



public class EmployeeDaoImplTest {
	
	private static EmployeeDao employeeDao;
	
	@BeforeClass
	public static void testDaoObject(){
		employeeDao = new EmployeeDaoImpl();
		Assert.assertNotNull("employeeDao is Null", employeeDao);
	}
	
	@Test
	public void testAddEmployee() throws EmployeeException{
		Employee emp = new Employee("John",999.99);
		Long empId = employeeDao.addEmployee(emp);
		Assert.assertTrue("Employee not added",empId>0);
	}

}
