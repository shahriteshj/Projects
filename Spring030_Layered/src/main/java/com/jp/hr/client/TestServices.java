package com.jp.hr.client;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;

public class TestServices {

	public static void main(String[] args) {

		/*
		 * try { ServiceEmployee empService = new ServiceEmployeeImpl();
		 * ArrayList<Employee> empList = empService.getEmpList(); for(Employee
		 * emp: empList){ System.out.println(emp); }
		 * System.out.println(empService.getEmpList()); } catch (HrException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
			ServiceEmployee empService = (ServiceEmployee) ctx.getBean("service");
			ArrayList<Employee> empList = empService.getEmpList();
			for (Employee emp : empList) {
				System.out.println(emp);
			}
			System.out.println(empService.getEmpList());
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
