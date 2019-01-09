package com.jp.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverUtil {

	public static WebDriver getDriver() {
		WebDriver driver = null;
		// step 1: driver class
		String driverClassKey = "webdriver.chrome.driver";
		// step 2 : driver path
		String driverPathValue=".\\driver\\chromedriver.exe";
		
		// step 3 : Set system class properties (K,V)
		System.setProperty(driverClassKey, driverPathValue);
		
		//step 4 : set the options of the browser
		ChromeOptions options = new ChromeOptions();
		
		//step 5 : get the driver instance by passing the options
		//object to ChromeDriver
		driver = new ChromeDriver(options);
		
		
		return driver;
	}

}
