package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	//locators 
	private By email = By.id("userEmail");
	
	private By password = By.id("userPassword");
	
	private By loginButton = By.cssSelector("[value='Login']");
	
	//constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//action method
	public void login(String emailAddress,String passwordValue) {
		driver.findElement(email).sendKeys(emailAddress);
		
		driver.findElement(password).sendKeys(passwordValue);
		
		driver.findElement(loginButton).click();
	}
	
}
