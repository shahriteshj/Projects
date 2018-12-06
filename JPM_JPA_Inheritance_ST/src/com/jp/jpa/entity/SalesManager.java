package com.jp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SALESMGR")
public class SalesManager extends Manager {


	private static final long serialVersionUID = -8542644942870017530L;

	@Column(name="COMMISSION")
	private Double commission;
	
	
	
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}

	public SalesManager(String empName, Double empSal, Double bonus) {
		super(empName, empSal, bonus);
		// TODO Auto-generated constructor stub
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "SalesManager [commission=" + commission + ", toString()=" + super.toString() + "]";
	}

	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+ commission;
	}
	
	
	

}
