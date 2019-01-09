package com.jp.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxUtil {


	public static WebDriver getDriver() {
		WebDriver driver = null;
		// step 1: driver class
		String driverClassKey = "webdriver.gecko.driver";
		// step 2 : driver path
		String driverPathValue=".\\driver\\geckodriver.exe";
		
		// step 3 : Set system class properties (K,V)
		System.setProperty(driverClassKey, driverPathValue);
		
		//step 4 : set the capabilities of the browser
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		
		//step 5 : get the driver instance by passing the desicercapabilities
		//object to FirefoxDriver
		driver = new FirefoxDriver(capabilities);
		
		
		return driver;
	}
}
