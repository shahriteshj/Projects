package com.jp.ba.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT_JPA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACC_TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="ACCOUNT")
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 5313891596027679037L;

	@Id
	@GeneratedValue(generator = "acct_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "acct_gen", sequenceName = "acct_seq", allocationSize = 1)
	private	Long accountId;
	
	@Column(name="BALANCE")
	private Float balance;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID") // Name of column to be created in employee
	private Customer customer;
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(Float balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", customer=" + customer + "]";
	}

	
	

}
