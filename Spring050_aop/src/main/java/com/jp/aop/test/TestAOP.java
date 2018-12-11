package com.jp.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jp.aop.services.MyServices;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		MyServices service = (MyServices) ctx.getBean("service");
		service.abcMethod1();
		service.abcMethod2(1);
		service.abcMethod3(1,2);
	}

}
