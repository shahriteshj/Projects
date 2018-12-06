package com.jp.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="MGR_TPC")
@AttributeOverrides({ 
	@AttributeOverride(column=@Column(name="MGR_ID"),name="empId"),
	@AttributeOverride(column=@Column(name="MGR_NAME"),name="empName"),
	@AttributeOverride(column=@Column(name="MGR_SAL"),name="empSal"),
})
public class Manager extends Employee {

	private static final long serialVersionUID = -1033163623801911376L;
	@Column(name="BONUS")
	private Double bonus;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Double getBonus() {
		return bonus;
	}



	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}


	public Manager(String empName, Double empSal, Double bonus) {
		super(empName, empSal);
		this.bonus = bonus;
	}



	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
	}



	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+bonus;
	}

	
	
	
	

}
