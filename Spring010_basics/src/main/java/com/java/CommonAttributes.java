package com.java;

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
	
	public CommonAttributes(String companyName, String address, int niftyRank) {
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
	
	
	

}
