/**
 * 
 */
package com.smita.webdriver.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author brije
 *
 */
public class NightlyFirefoxUtil {
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(){
		String geckoDriverKey="webdriver.gecko.driver";
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Nightly\\firefox.exe");
		String geckoDriverPathValue = "driver\\geckodriver.exe";
		System.setProperty(geckoDriverKey, geckoDriverPathValue);
		//WebDriver driver = new FirefoxDriver();
		DesiredCapabilities desiredCapabilities =DesiredCapabilities.firefox();//new FirefoxOptions().setProfile(new FirefoxProfile()).addTo(DesiredCapabilities.firefox());//
		desiredCapabilities.setCapability(FirefoxDriver.MARIONETTE, true);
		WebDriver driver = new FirefoxDriver(desiredCapabilities);
		return driver;
	}
	
}
