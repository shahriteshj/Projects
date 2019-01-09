/**
 * 
 */
package com.smita.webdriver.test;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author brije
 *
 */

import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.NightlyFirefoxUtil;

public class SeleniumJunitTest {
	public WebDriver driver;
	
	@Test
	public void launchBrowser() {
		System.out.println("launching firefox browser"); 
		driver = NightlyFirefoxUtil.getDriver();
	}

	@Test
	public void openApplication() {
		System.out.println("Opening Google page"); 
		driver.navigate().to("http://www.google.com");
		System.out.println("Title " + driver.getTitle());
	}
	@Ignore
	@Test
	public void closeDriver() {
		if(driver!=null) {
			System.out.println("Closing firefox browser");
			driver.close();
		}
	}
}