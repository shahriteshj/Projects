package com.jp.ba.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_JPA")
public class Customer implements Serializable {


	private static final long serialVersionUID = -177779385595979486L;

	@Id
	@GeneratedValue(generator = "cust_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cust_gen", sequenceName = "cust_seq", allocationSize = 1)
	private Long customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL)
	private Set<Account> accounts;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + ", accounts=" + accounts + "]";
	}

	
	
}
