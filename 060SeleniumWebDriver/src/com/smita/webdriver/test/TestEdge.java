package com.smita.webdriver.test;


import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.MicrosoftEdgeUtil;

/**
 * @author Smita
 *
 */
public class TestEdge {

	public static void main(String[] args) {
		WebDriver driver = MicrosoftEdgeUtil.getDriver();
		System.out.println("launching MicrosoftEdge browser....");/*
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);*/
		System.out.println("Opening Google page.....");
		driver.get("http://www.google.com");
		System.out.println("Title " + driver.getTitle());
		//if(driver!=null) { driver.close(); }
		 
	}

}
