package com.jp.list;

import java.util.Comparator;

import com.jp.entity.Employee;

public class SortByEmpName implements Comparator<Employee> {

	public SortByEmpName() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmpName().compareTo(o2.getEmpName());
	}

}
