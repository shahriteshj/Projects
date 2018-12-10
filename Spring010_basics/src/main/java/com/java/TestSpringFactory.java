package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringFactory {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext();
		MyApplDao dao = (MyApplDao)ctx.getBean("dao");
		

	}

}
