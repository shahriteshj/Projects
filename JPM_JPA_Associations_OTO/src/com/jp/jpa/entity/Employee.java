package com.jp.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_OTO")
public class Employee implements Serializable,Comparable<Employee> {

	private static final long serialVersionUID = -3830958221519052671L;

	@Id
	@Column(name = "EMP_ID")
	private Long empId;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_SAL")
	private Double empSal;

	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID") // Name of column to be created in employee
	//@PrimaryKeyJoinColumn
	private Address address;

	public Employee() {

	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}



	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", address=" + address
				+ "]";
	}

	@Override
	public int hashCode() {
		return empId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		return obj.hashCode()==this.hashCode();
	}

	@Override
	public int compareTo(Employee o) {
		return (int) (this.empId - o.empId);
	}
	
	
	

}
