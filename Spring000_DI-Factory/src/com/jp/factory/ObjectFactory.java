package com.jp.factory;

import com.jp.dao.MyApplDao;
import com.jp.service.MyApplServices;

// Factory class
public class ObjectFactory {

	private MyApplDao dao;
	private MyApplServices service;

	public ObjectFactory() {
		dao = new MyApplDao();
		service = new MyApplServices(dao);
	}

	// Factory Method
	public MyApplDao getDao() {
		return dao;
	}

	public MyApplServices getService() {
		return service;
	}

	public Object getBean(String beanName) {
		switch (beanName) {
		case "dao": {
			return dao;
		}
		case "service": {
			return service;
		}
		default: {
			return null;
		}
		}
	}

}
