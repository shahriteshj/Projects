package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringFactory {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/context.xml");
		System.out.println("Context created");
		
		MyApplDao dao1 = (MyApplDao)ctx.getBean("dao");
		System.out.println("dao1: " + dao1.hashCode());
		MyApplDao dao2 = (MyApplDao)ctx.getBean("dao");
		System.out.println("dao2: " + dao2.hashCode());
		
		MyApplServices service1 = (MyApplServices)ctx.getBean("service");
		System.out.println("service1" + service1.hashCode());

		MyApplServices service2 = (MyApplServices)ctx.getBean("service");
		System.out.println("service2" + service2.hashCode());
		
		CommonAttributes common = (CommonAttributes)ctx.getBean("commonData");
		System.out.println("common" + common.toString());
		
	}

}
