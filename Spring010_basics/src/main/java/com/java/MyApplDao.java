package com.java;

import org.springframework.stereotype.Repository;

//@Component("dao")
@Repository("dao")
public class MyApplDao {
	
	public MyApplDao() {
		System.out.println("Object of class MyApplDao() is created.");
	}

}
