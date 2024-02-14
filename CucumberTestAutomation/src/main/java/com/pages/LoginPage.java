package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1.  BY Locators : Object Repo

	private By pwd = By.id("xyz");

	// 2.  Constructor of the same class
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3.  Page actions: Features (Behavior) of the page in the form of methods.
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
}
