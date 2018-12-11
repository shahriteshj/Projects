package com.jp.hr.beans;

public class ServiceBean {
	
	private int x;
	
	public ServiceBean(int x){
		this.x = x;
		System.out.println("In constructor.");
	}
	
	public void setValueX(int x){
		this.x = x;
		System.out.println("In setter.");
	}

}
