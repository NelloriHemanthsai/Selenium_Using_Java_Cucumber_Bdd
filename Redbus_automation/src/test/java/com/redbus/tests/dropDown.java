package com.redbus.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dropDown {
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions(); 
		// Open Chrome in Incognito mode options.addArguments("--incognito");
		options.addArguments("--incognito");
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(
	               "https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html"
	        );
		  
		  driver.navigate().refresh();
		
	}
	
	@Test
	public void test() {
		// Find dropdown 
		WebElement courseDropdown = driver.findElement(By.id("course")); 
		// Create Select object 
		Select course = new Select(courseDropdown); 
		// Select Dot Net 
		course.selectByVisibleText("Dot Net");
	}
	
}