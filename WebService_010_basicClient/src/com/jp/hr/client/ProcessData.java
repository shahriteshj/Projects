package com.jp.hr.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.EmpSoapServices;

public class ProcessData {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:9898/hr?wsdl");
			QName qname = new QName("http://soap.hr.jp.com/", "EmpSoapServicesImplService");

			Service service = Service.create(url, qname);

			// Extract the endpoint interface, the service "port".
			EmpSoapServices soapServices = service.getPort(EmpSoapServices.class);
			
			System.out.println(soapServices.getTestInteger(10));
			Employee emp = soapServices.getEmpDetails(1);
			System.out.println(emp);

			ArrayList<Employee> empList = (ArrayList<Employee>) soapServices.getEmpList();

			for (Employee emp1 : empList) {
				System.out.println(emp1);
			}

			Employee empNew = new Employee(2, "Adam", "Smith");
			soapServices.addNewEmployee(empNew);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
