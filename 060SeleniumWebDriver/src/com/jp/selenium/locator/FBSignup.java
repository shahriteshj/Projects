package com.jp.selenium.locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.smita.webdriver.util.ChromeDriverUtil;

public class FBSignup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = ChromeDriverUtil.getDriver();
		
		driver.get("http://www.facebook.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("FirstName");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_l\"]")).sendKeys("LastName");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_o\"]")).sendKeys("abc@abc.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_r\"]")).sendKeys("abc@abc.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_v\"]")).sendKeys("password");
		 List<WebElement> radioElem = driver.findElements(By.name("sex"));
		 
		 for(WebElement webElem: radioElem){
			 String radioSelection;
			 radioSelection = webElem.getAttribute("value").toString();
			 System.out.println(radioSelection);
			 if(radioSelection.equals("2")){
				 webElem.click();
			 }
		 }
		 
		 Select selectByIndex = new Select(driver.findElement(By.id("day")));
		 selectByIndex.selectByIndex(10);
		 
		 Select selectByVisibleText = new Select(driver.findElement(By.id("month")));
		 selectByVisibleText.selectByVisibleText("Oct");
		 
		 Select selectByValue = new Select(driver.findElement(By.id("year")));
		 selectByValue.selectByValue("1980");
		 
		 Thread.sleep(5000);
		
		 
		 
		driver.close();

	}

}
