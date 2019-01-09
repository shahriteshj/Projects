package com.jp.selenium.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smita.webdriver.util.ChromeDriverUtil;

public class PriorityDemo {

	private String baseUrl = "https://www.twitter.com";
	private WebDriver driver;

	/*
	 * @Test(priority=0) public void logIn(){ System.out.println("In logIn...");
	 * }
	 */

	@Test(priority = 1)
	public void helpCenter() throws InterruptedException {
		System.out.println("In helpCenter...");
		driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[3]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Help Center", title);
	}

	@Test(priority = 4)
	public void signUp() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[2]/div[2]/div/a[1]")).click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Sign up for Twitter / Twitter", title);
	}

	/*
	 * @Test(priority=2) public void logOut(){
	 * System.out.println("In logOut..."); }
	 */

	@BeforeMethod
	public void GotoHomePage() throws InterruptedException {
		System.out.println("in GotoHomePage...");
		String expectedTitle = "Twitter. It's what's happening.";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(3000);
	}

	@AfterMethod
	public void BackToHomePage() throws InterruptedException {
		System.out.println("in BackToHomePage...");
		driver.navigate().to(baseUrl);
		Thread.sleep(3000);
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("in launchBrowser...");
		driver = ChromeDriverUtil.getDriver();
		driver.get(baseUrl);
	}

	@AfterTest
	public void terminateBrowser() throws InterruptedException {
		System.out.println("in terminateBrowser...");
		Thread.sleep(1000);
		driver.close();
	}

}
