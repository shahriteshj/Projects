package com.jp.selenium.util;

import org.openqa.selenium.WebDriver;

public class FirefoxMain {


	public static void main(String[] args) {
		WebDriver driver = FirefoxUtil.getDriver();
		System.out.println("Loading the browser....");
		//Driver get command
		driver.get("https://www.google.com/");
		System.out.println("Opening maps.google.com");
		driver.close();

	}

}
