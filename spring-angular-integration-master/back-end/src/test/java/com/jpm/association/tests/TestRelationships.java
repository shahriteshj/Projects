package com.jpm.association.tests;

import com.jpm.association.entities.Employee;
import com.jpm.association.entities.Profile;

public class TestRelationships {

	public static void main(String[] args) {
		Employee emp1 = new Employee(100, "aaaa", 30000);
		
		Profile prof1 = new Profile("Mumbai", "1111111111");
		
		emp1.setProfile(prof1);
		
		System.out.println(emp1);
		
		
	}
}
