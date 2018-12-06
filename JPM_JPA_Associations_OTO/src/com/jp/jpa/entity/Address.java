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
@Table(name="ADDRESS_OTO")
public class Address implements Serializable {

	private static final long serialVersionUID = 8894910732533734237L;
	
/*	@Id
	@Column(name="emp_id", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign", parameters=@Parameter(name="property",value="employee"))
	private Long empId;*/
	
	@Id
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ADDRESS_STREET")
	private String street;
	
	@Column(name="ADDRESS_CITY")
	private String city;

	@Column(name="ADDRESS_STATE")
	private String state;
	
	@Column(name="ADDRESS_ZIPCODE")
	private String zipcode;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="empId")
	//@PrimaryKeyJoinColumn
	private Employee employee;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + "]";
	}

}
