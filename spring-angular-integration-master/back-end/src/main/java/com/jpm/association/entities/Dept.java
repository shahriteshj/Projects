package com.jpm.association.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Dept {
	private int deptNo;
	private String deptNm;
	
	public Dept(int deptNo, String deptNm) {
		super();
		this.deptNo = deptNo;
		this.deptNm = deptNm;
	}

	public Dept() {
		super();
	}

	// Association
	@JsonManagedReference
	private List<Employee> empList;
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptNm=" + deptNm + ", empList=" + empList + "]";
	}
}
