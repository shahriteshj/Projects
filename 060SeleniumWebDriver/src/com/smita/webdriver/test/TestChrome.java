package com.smita.webdriver.test;


import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.ChromeDriverUtil;
/**@author brije**/
public class TestChrome {

	public static void main(String[] args) {
		
		WebDriver driver=ChromeDriverUtil.getDriver();
		System.out.println("Loading chrome brower....");
		driver.manage().window().maximize();
		//delete all cookies
		driver.manage().deleteAllCookies();
		System.out.println("Deleting all cookies....");
		driver.get("http://www.gmail.com/");
		System.out.println("opening Gmail....");
	}
}
