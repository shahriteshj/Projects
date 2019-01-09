package com.smita.webdriver.test;
/**
 * 
 */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.FirefoxUtil;

/**
 * @author brije
 *
 */
public class TestFirefox {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =FirefoxUtil.getDriver();
		System.out.println("launching Firefox browser....");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		System.out.println("Opening Google page.....");
		driver.get("http://www.google.com");
		System.out.println("Title " + driver.getTitle());
		Thread.sleep(1000);
		driver.close();

	}

}
