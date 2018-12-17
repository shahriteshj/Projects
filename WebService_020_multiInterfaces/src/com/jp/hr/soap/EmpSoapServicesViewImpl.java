package com.jp.hr.soap;

import java.util.List;

import javax.jws.WebService;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.EmpSoapServicesView;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.utilities.ServiceFactory;

@WebService(endpointInterface = "com.jp.hr.interfaces.EmpSoapServicesView")
public class EmpSoapServicesViewImpl implements EmpSoapServicesView {

	private ServiceEmployee services;

	public EmpSoapServicesViewImpl() throws HrException {
		services = ServiceFactory.getService();
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		return services.getEmpDetails(empId);
	}

	@Override
	public List<Employee> getEmpList() throws HrException {
		return services.getEmpList();
	}
}
