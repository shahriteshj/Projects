package com.jp.hr.soap;

import javax.xml.ws.Endpoint;

import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.EmpSoapServices;

public class PublishEmpServices {

	public static void main(String[] args) {

		try {
			EmpSoapServices soapServices = new EmpSoapServicesImpl();
			Endpoint.publish("http://localhost:9898/hr", soapServices);
			System.out.println("Services started.");
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
