package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("commonData")
public class CommonAttributes {
	
	private String companyName;
	private String address;
	private int niftyRank;
	
	public CommonAttributes() {
		super();

	}
	
	public CommonAttributes(int niftyRank,String companyName, String address) {
		super();
		this.companyName = companyName;
		this.address = address;
		this.niftyRank = niftyRank;
	}
	
	@Autowired
	public CommonAttributes(@Value("J. P. Morgan") String companyName,@Value("Mumbai") String address,@Value("40")  int niftyRank) {
		super();
		this.companyName = companyName;
		this.address = address;
		this.niftyRank = niftyRank;
	}
	

	public CommonAttributes(String companyName, int niftyRank) {
		super();
		this.companyName = companyName;
		this.niftyRank = niftyRank;
	}

	@Override
	public String toString() {
		return "CommonAttributes [companyName=" + companyName + ", address=" + address + ", niftyRank=" + niftyRank
				+ "]";
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNiftyRank() {
		return niftyRank;
	}

	public void setNiftyRank(int niftyRank) {
		this.niftyRank = niftyRank;
	}
	
	
	

}
