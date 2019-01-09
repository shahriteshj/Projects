package com.jp.selenium.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.ChromeDriverUtil;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = ChromeDriverUtil.getDriver();
		
		driver.get("http://www.gcrit.com/build3/admin/login.php");
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin@123");
		driver.findElement(By.id("tdb1")).click();
		
		Thread.sleep(2000);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		if(url.equals("http://www.gcrit.com/build3/admin/index.php")){
			System.out.println("Login Passed");
		}else{
			System.err.println("Login Failed");
		}
		
		driver.close();

	}

}
