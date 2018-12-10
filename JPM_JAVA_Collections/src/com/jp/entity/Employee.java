package com.jp.entity;

public class Employee implements Comparable<Employee> {

	private int empId;
	private String empName;
	private double empSal;
	private static int numId;
	private static final String CO_NAME;// blank final
	// static block which is used to initialise the static variable

	static {
		numId = (int) (100 + Math.random() * 123.123);
		CO_NAME = "JP Morgan";
	}

	// initializer block-used to initialize instance var before
	{
		empId = numId++;
	}

	public Employee(String empName, double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public static int getNumId() {
		return numId;
	}

	public static void setNumId(int numId) {
		Employee.numId = numId;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empId - o.empId;
	}

	@Override
	public int hashCode() {
		return getEmpId();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();
	}
	
	

}
