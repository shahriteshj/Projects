package com.smita.webdriver.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxUtil {
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(){
		String geckoDriverKey="webdriver.gecko.driver";
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		String geckoDriverPathValue = ".\\driver\\geckodriver.exe";
		System.setProperty(geckoDriverKey, geckoDriverPathValue);
		//WebDriver driver = new FirefoxDriver();
		DesiredCapabilities capabilities =DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
	/*	FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(FirefoxDriverLogLevel.WARN);
		options.setCapability(FirefoxDriver.MARIONETTE, true);*/
		WebDriver driver =  new FirefoxDriver(capabilities);		//new FirefoxDriver(options);
		return driver;
	}
	public static void main(String[] args) {
		getDriver();
	}
}
