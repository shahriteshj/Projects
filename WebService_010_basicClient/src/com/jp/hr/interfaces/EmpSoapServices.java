package com.jp.hr.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface EmpSoapServices {

	@WebMethod
	public int getTestInteger(int x) throws HrException;

	@WebMethod
	public Employee getEmpDetails(int empId) throws HrException;

	@WebMethod
	public List<Employee> getEmpList() throws HrException;

	@WebMethod
	public boolean addNewEmployee(Employee emp) throws HrException;
}
