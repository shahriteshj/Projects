package com.jp.selenium.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smita.webdriver.util.ChromeDriverUtil;

public class LocatorMain {


	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = ChromeDriverUtil.getDriver();
		driver.get("file:\\D:\\Projects\\060SeleniumWebDriver\\src\\Locators.html");
		
		WebElement webElement = driver.findElement(By.id("user"));
		Thread.sleep(1000);
		webElement.sendKeys("ABCD");
		Thread.sleep(5000);
		driver.findElement(By.name("admin")).sendKeys("EFGH");
		Thread.sleep(5000);
		webElement=driver.findElement(By.linkText("How to use locators?"));
		// ^ - Beginning of the text
		//$ - end of the text
		//* - any text
		Thread.sleep(5000);
		System.out.println();
		driver.close();
	}

}
