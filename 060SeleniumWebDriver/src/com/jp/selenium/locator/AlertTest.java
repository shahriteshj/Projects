package com.jp.selenium.locator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.ChromeDriverUtil;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = ChromeDriverUtil.getDriver();
		driver.get("file:\\D:\\Projects\\060SeleniumWebDriver\\src\\AlertBoxDemos.html");
		Thread.sleep(1000);
		
		driver.findElement(By.id("alert")).click();
		
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Message: " + alert.getText());
		alert.accept();
		Thread.sleep(1000);
		
		driver.findElement(By.id("confirm")).click();
		
		alert = driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Alert Message: " + alert.getText());
		alert.accept();
		Thread.sleep(1000);
		
		driver.findElement(By.id("confirm")).click();
		
		alert = driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Alert Message: " + alert.getText());
		alert.dismiss();
		Thread.sleep(1000);
		
		driver.close();

	}

}
