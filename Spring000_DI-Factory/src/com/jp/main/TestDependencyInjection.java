package com.jp.main;

import com.jp.dao.MyApplDao;
import com.jp.factory.ObjectFactory;
import com.jp.service.MyApplServices;

public class TestDependencyInjection {

	public static void main(String[] args) {

		ObjectFactory factory = new ObjectFactory();
		// Constructor Injection
		//MyApplDao dao = factory.getDao();
		//MyApplServices services = factory.getService();
		
		MyApplDao dao1 = (MyApplDao)factory.getBean("dao");
		MyApplServices services1 = (MyApplServices)factory.getBean("service");
		
		
	}

}
