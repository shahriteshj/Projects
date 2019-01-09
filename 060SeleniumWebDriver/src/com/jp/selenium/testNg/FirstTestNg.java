package com.jp.selenium.testNg;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smita.webdriver.util.ChromeDriverUtil;

public class FirstTestNg {

	private String baseUrl="https://www.twitter.com";
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser(){
		System.out.println("in launchBrowser...");
		driver = ChromeDriverUtil.getDriver();
		assertNotNull(driver, "Driver not loaded...");
	}
	
  @Test
  public void openWebsite() {
		System.out.println("In openWebsite...");
		driver.get(baseUrl);
  }
	
  
	
	
	@AfterTest
	public void terminateBrowser(){
		System.out.println("in terminateBrowser...");
		driver.quit();
		//assertNull(driver,"Driver is still open...");
	}
}
