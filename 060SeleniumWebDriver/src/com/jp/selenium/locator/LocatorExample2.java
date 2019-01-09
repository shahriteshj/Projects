package com.jp.selenium.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smita.webdriver.util.ChromeDriverUtil;

public class LocatorExample2 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = ChromeDriverUtil.getDriver();
	
	driver.get("http://demo.opencart.com/");
	Thread.sleep(1000);
	WebElement webElement = driver.findElement(By.name("search"));
	Thread.sleep(1000);
	webElement.sendKeys("phone");
	Thread.sleep(1000);
	driver.findElement(By.className("input-group-btn")).click();
	Thread.sleep(1000);
	
	driver.close();
}
}
