package com.jp.hr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="deptRec")
@Table(name="DEPT")
public class Dept {
	
	private int deptNo;
	private String deptNm;
	
	@Id
	@Column(name="DEPTNO")
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Column(name="DNAME")
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptNm=" + deptNm + "]";
	}
	
	

}
