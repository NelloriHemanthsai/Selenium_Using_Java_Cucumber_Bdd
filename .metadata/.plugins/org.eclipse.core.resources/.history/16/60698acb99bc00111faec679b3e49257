package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	  WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	private By countryInput = By.cssSelector( "input[placeholder='Select Country']");
	
    private By indiaOption =
            By.xpath(
                    "//button[contains(@class,'ta-item') and normalize-space(.)='India']"
            );
    
    public void selectCountry(String country){
    	
    	  driver.findElement(countryInput)
          .sendKeys(country);

  driver.findElement(indiaOption)
          .click();
    	
    }

}
