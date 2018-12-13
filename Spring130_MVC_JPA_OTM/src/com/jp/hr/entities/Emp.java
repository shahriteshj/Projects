package com.jp.hr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="empRecord")
@Table(name="EMP")
public class Emp {
	private int empNo;
	private String empNm;
	private Float empSal;

	
	//Association field
	private Dept dept;
	

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
	public Float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Float empSal) {
		this.empSal = empSal;
	}

	@OneToOne()
	@JoinColumn(name="DEPT_NO")
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + ", empSal=" + empSal + "]";
	}


	
	
	
}
