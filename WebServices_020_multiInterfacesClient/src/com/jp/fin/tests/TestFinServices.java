package com.jp.fin.tests;

import com.jp.fin.exceptions.FinException;
import com.jp.fin.locator.LocateServices;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.EmpSoapServicesUpdate;
import com.jp.hr.interfaces.EmpSoapServicesView;;

public class TestFinServices {
	public static void main(String[] args) {
		try {
			EmpSoapServicesView soapServicesView = LocateServices.getEmpServices();
			System.out.println(soapServicesView.getEmpDetails(1));

			System.out.println(soapServicesView.getEmpList());

			EmpSoapServicesUpdate soapServicesUpdate = LocateServices.getEmpUpdateServices();
			System.out.println(soapServicesUpdate.getEmpDetails(1));

		} catch (HrException e) {
			e.printStackTrace();
		} catch (FinException e) {
			e.printStackTrace();
		}
	}
}
