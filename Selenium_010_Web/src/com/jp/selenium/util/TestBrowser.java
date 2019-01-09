package com.jp.selenium.util;

import org.openqa.selenium.WebDriver;

public class TestBrowser {


	public static void main(String[] args) throws InterruptedException {

		ChromeBrowser();
	}

	public static void FirefoxBrowser() throws InterruptedException{
		WebDriver driver = FirefoxUtil.getDriver();
		System.out.println("Loading the browser....");
		//Driver get command
		driver.get("https://www.google.com/");
		System.out.println("Opening maps.google.com");
		System.out.println("Title " + driver.getTitle());
		Thread.sleep(10000);
		driver.close();
	}
	
	
	public static void ChromeBrowser() throws InterruptedException{
		WebDriver driver = ChromeDriverUtil.getDriver();
		System.out.println("Loading the browser....");
		//Driver get command
		driver.get("https://www.google.com/");
		System.out.println("Opening maps.google.com");
		System.out.println("Title " + driver.getTitle());
		Thread.sleep(10000);
		driver.close();
	}
	
	
}
