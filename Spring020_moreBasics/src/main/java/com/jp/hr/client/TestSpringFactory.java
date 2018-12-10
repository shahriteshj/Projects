package com.jp.hr.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jp.hr.dao.MyApplDao;
import com.jp.hr.services.MyApplServices;

public class TestSpringFactory {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		System.out.println("Context created");
		
		MyApplDao dao1 = (MyApplDao)ctx.getBean("dao");
		System.out.println("dao1: " + dao1.hashCode());
		MyApplDao dao2 = (MyApplDao)ctx.getBean("dao");
		System.out.println("dao2: " + dao2.hashCode());
		
		MyApplServices service1 = (MyApplServices)ctx.getBean("service");
		System.out.println("service1: " + service1.hashCode());

		MyApplServices service2 = (MyApplServices)ctx.getBean("service");
		System.out.println("service2: " + service2.hashCode());
		

				
	}

}
