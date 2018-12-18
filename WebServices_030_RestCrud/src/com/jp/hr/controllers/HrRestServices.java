package com.jp.hr.controllers;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.utilities.ServiceFactory;

@Path("/emps")
public class HrRestServices {
	
	private ServiceEmployee services;
	
	public HrRestServices() {
		services = ServiceFactory.getService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Employee> getEmpList() throws HrException{
		ArrayList<Employee> empList = (ArrayList<Employee>) services.getEmpList();
		return empList;
	}
	
	@POST
	public boolean  addNewEmployee(@FormParam("txtEmpId") int empId
			, @FormParam("txtFirstName") String firstName, @FormParam("txtLastName") String lastName) throws HrException {
		boolean isSuccess = services.addNewEmployee(new Employee(empId,firstName,lastName));
		return isSuccess;
	}
	
}
