package com.jp.hr.entities;

public class Employee {
	private int empId;
	private String first_Name;
	private String lastName;

	public Employee(int empId, String first_Name, String lastName) {
		super();
		this.empId = empId;
		this.first_Name = first_Name;
		this.lastName = lastName;
	}

	public Employee(){
		
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", first_Name=" + first_Name + ", lastName=" + lastName + "]";
	}

}
