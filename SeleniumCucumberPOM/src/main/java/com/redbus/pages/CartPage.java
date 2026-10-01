package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	
	private By checkoutButton = By.xpath("//button[text()='Checkout']");
	
	public void clickCheckout() {
		driver.findElement(checkoutButton).click();
	}

}
