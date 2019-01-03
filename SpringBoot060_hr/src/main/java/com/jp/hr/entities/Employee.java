package com.jp.hr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp_JT")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 5785938573200676462L;
	
	private int empNo;
	private String empNm;
	private float empSal;
	
	public Employee(){
		
	}
	
	public Employee(int empNo, String empNm, float empSal) {
		super();
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal = empSal;
	}
	
	@Id
	@Column(name="EMP_ID")
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	@Column(name="EMP_NAME")
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	
	@Column(name="EMP_SAL")
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empNm=" + empNm + ", empSal=" + empSal + "]";
	}
	
	
}
