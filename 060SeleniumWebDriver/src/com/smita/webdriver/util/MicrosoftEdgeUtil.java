/**
 * 
 */
package com.smita.webdriver.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Smita B Kumar
 *
 */
public class MicrosoftEdgeUtil {
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(){
		WebDriver driver;
		String edgeDriverPathValue="driver\\MicrosoftWebDriver.exe";
		String edgeDriverKey="webdriver.edge.driver";
		System.out.println("launching Microsoft Edge browser");
		System.setProperty(edgeDriverKey, edgeDriverPathValue);
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		driver = new EdgeDriver(capabilities);
		/*EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
		driver = new EdgeDriver(options);*/
		return driver;
	}
}
