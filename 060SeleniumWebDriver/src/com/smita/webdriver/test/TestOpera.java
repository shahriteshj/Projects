package com.smita.webdriver.test;


import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.OperaUtil;

/**
 * @author Smita
 *
 */
public class TestOpera {

	public static void main(String[] args) {
		WebDriver driver = OperaUtil.getDriver();
		System.out.println("launching Opera browser....");
		driver.manage().window().maximize();
		System.out.println("Opening Google page.....");
		driver.get("http://www.google.com");
		System.out.println("Title " + driver.getTitle());
		//if(driver!=null) { driver.close(); }
		 
	}

}
