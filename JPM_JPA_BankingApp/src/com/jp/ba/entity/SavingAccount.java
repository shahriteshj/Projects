package com.jp.ba.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SAVINGS")
public class SavingAccount extends Account {


	private static final long serialVersionUID = 5401576842089920539L;

	@Column(name="RATE_OF_INTEREST")
	private Float rateOfInterest; 
	
	
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public SavingAccount(Float balance, Customer customer, Float rateOfInterest) {
		super(balance, customer);
		this.rateOfInterest = rateOfInterest;
	}

	public Float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	@Override
	public String toString() {
		return "SavingAccount [rateOfInterest=" + rateOfInterest + "]";
	}
	
	

}
