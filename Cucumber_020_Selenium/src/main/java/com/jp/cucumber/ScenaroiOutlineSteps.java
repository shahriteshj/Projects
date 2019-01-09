package com.jp.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.ChromeDriverUtil;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class ScenaroiOutlineSteps {
	
	WebDriver driver;

	@Given("^OutlineI am on facebook login page$")
	public void I_am_on_facebook_login_page() {
		System.out.println("Opening Facebook Login Page...");
	    driver = ChromeDriverUtil.getDriver();
	    driver.get("https://www.facebook.com/login/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I enter Username as \"([^\"]*)\"$")
	public void I_enter_Username_as(String arg1) {
		System.out.println("Entering username...");
	    driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^Password as \"([^\"]*)\"$")
	public void Password_as(String arg1) {
		 System.out.println("Entering password...");
		    driver.findElement(By.id("pass")).sendKeys(arg1);
		    driver.findElement(By.id("loginbutton")).click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^Logins should fail$")
	public void Login_should_fail() {
	    System.out.println("Login failed with incorrect username and password");
	    if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100")){
	    	System.out.println("Test Passed");
	    }
	    else{
	    	System.out.println("Test Failed");
	    }
	    driver.close();
	}

}
