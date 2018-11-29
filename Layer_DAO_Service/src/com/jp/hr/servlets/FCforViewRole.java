package com.jp.hr.servlets;

import com.jp.hr.exceptions.HRException;
import com.jp.hr.services.EmployeeServiceImpl;
import com.jp.hr.services.ViewRole;

public class FCforViewRole {

	public static void main(String[] args) {
		try {
			ViewRole role = new EmployeeServiceImpl();
		} catch (HRException e) {
			e.printStackTrace();
		}

	}

}
