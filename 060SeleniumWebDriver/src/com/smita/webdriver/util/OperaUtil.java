/**
 * 
 */
package com.smita.webdriver.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 * @author Smita B Kumar
 *
 */
public class OperaUtil {
	public static WebDriver getDriver() {
		WebDriver driver=null;
		String path = "driver\\operadriver.exe";
		OperaOptions options = new OperaOptions();
		options.setBinary("C:\\Program Files\\Opera\\57.0.3098.106\\opera.exe");
		System.setProperty("webdriver.opera.driver", path);
		driver = new OperaDriver(options);

		return driver;
	}
}
