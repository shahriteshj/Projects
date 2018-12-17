package com.jp.hr.soap;

import javax.jws.WebService;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.EmpSoapServicesUpdate;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.utilities.ServiceFactory;

@WebService(endpointInterface = "com.jp.hr.interfaces.EmpSoapServicesUpdate")
public class EmpSoapServicesUpdateImpl implements EmpSoapServicesUpdate {

	private ServiceEmployee services;

	public EmpSoapServicesUpdateImpl() throws HrException {
		services = ServiceFactory.getService();
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		return services.getEmpDetails(empId);
	}

	@Override
	public boolean addNewEmployee(Employee emp) throws HrException {
		return services.addNewEmployee(emp);
	}
}
