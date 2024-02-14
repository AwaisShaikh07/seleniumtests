package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 *  This method is used to initialized the Thread Local Driver on the basis of provided Browser 
	 * @param browser
	 * @return
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is : " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		} else {
			System.out.println("Kindly Pass the Correct Browser " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	
	/**
	 * This is used to get the driver with tread driver
	 * @return
	 */
	
	
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}

}
