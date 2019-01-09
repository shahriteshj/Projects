package com.smita.webdriver.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.NightlyFirefoxUtil;

/**
 * @author Smita
 *
 */
public class TestNightly {

	public static void main(String[] args) {
		WebDriver driver = NightlyFirefoxUtil.getDriver();
		System.out.println("launching Nightly browser....");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		System.out.println("Opening Google page.....");
		driver.get("http://www.google.com");
		System.out.println("Title " + driver.getTitle());
		//if(driver!=null) { driver.close(); }
		 
	}

}
