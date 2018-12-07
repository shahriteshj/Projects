package com.jp.ba.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CURRENT")
public class CurrentAccount extends Account {


	private static final long serialVersionUID = 5294516866875058610L;

	@Column(name="OVER_DRAFT_LIMIT")
	private Float overDraftLimit;
	

	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public CurrentAccount(Float balance, Customer customer,Float overDraftLimit) {
		super(balance, customer);
		this.overDraftLimit= overDraftLimit;

	}

	public Float getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(Float overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public String toString() {
		return "CurrentAccount [overDraftLimit=" + overDraftLimit + "]";
	}


}
