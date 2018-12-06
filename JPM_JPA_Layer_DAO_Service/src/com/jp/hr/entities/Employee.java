package com.jp.hr.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMP_JPA")
public class Employee {
	
	@Id
	@SequenceGenerator(name="EMP_GEN", sequenceName="emp_master_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="EMP_GEN")
	private int empId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	public Employee(String firstName, String lastName) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(int empId,String firstName, String lastName) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Employee() {

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirst_Name(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
