package com.redbus.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowHandeling {
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
	               "https://www.hyrtutorials.com/p/window-handles-practice.html "
	        );
		  
		  driver.navigate().refresh();
		
	}
	
	@Test
	public void test() {
		String mainwindow = driver.getWindowHandle();
		WebElement newtabbtn = driver.findElement(By.xpath("//*[@id=\"newWindowBtn\"]"));
		newtabbtn.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		for(String mpWindows:windowHandles) {
			if(!mpWindows.equals(mainwindow)) {
				driver.switchTo().window(mpWindows);
				driver.manage().window().maximize();
				break;
			}
		}
		
		
		
		driver.findElement( By.id("firstName") ).sendKeys("Hemanth");
		driver.findElement( By.id("lastName") ).sendKeys("Nellori");
		driver.findElement( By.id("femalerb") ).click();
		driver.findElement( By.id("englishchbx") ).click();
		driver.findElement( By.id("email") ).sendKeys("hemanth@example.com");
		driver.findElement( By.id("password") ).sendKeys("Test@1234");
		driver.findElement( By.id("registerbtn") ).click();
		
		WebElement message = driver.findElement( By.id("msg") );
		String actualMessage = message.getText();
		System.out.println( "Registration Message: " + actualMessage );
		Assert.assertTrue( message.isDisplayed(), "Registration success message is NOT displayed" ); 
		System.out.println( "Registration successful message is displayed" );
		driver.switchTo().window(mainwindow);
		
		
//		```java
//		String mainWindow = driver.getWindowHandle();
//
//		Set<String> allWindows = driver.getWindowHandles();
//
//		for (String window : allWindows) {
//
//		    if (!window.equals(mainWindow)) {
//
//		        driver.switchTo().window(window);
//
//		        driver.manage().window().maximize();
//
//		        break;
//		    }
//		}
//		```
//
//		::`
//
//		Here:
//
//		```text
//		mainWindow
//		    ↓
//		Window 1
//
//		other window
//		    ↓
//		Window 2
//		```
//
//		So Selenium switches to the **second window**.
//
//		---
//
//		## 2. If you have 3 windows
//
//		Suppose:
//
//		```text
//		Window 1 → Main
//		Window 2 → First new window
//		Window 3 → Second new window
//		```
//
//		You can use a counter.
//
//		```java
//		Set<String> allWindows = driver.getWindowHandles();
//
//		int count = 1;
//
//		for (String window : allWindows) {
//
//		    if (count == 3) {
//
//		        driver.switchTo().window(window);
//
//		        driver.manage().window().maximize();
//
//		        break;
//		    }
//
//		    count++;
//		}
//		```
//
//		::`
//
//		The loop works like this:
//
//		```text
//		count = 1 → Window 1
//		count = 2 → Window 2
//		count = 3 → Window 3 ← SWITCH HERE
//		```
//
//		---
//
//		## 3. Easier way to understand
//
//		Think of the windows as an array/list:
//
//		```text
//		Window 1
//		Window 2
//		Window 3
//		Window 4
//		```
//
//		You can count them:
//
//		```java
//		int count = 1;
//
//		for (String window : allWindows) {
//
//		    if (count == 3) {
//		        driver.switchTo().window(window);
//		        break;
//		    }
//
//		    count++;
//		}
//		```
//
//		Change only this:
//
//		```java
//		if (count == 2)
//		```
//
//		➡️ 2nd window
//
//		```java
//		if (count == 3)
//		```
//
//		➡️ 3rd window
//
//		```java
//		if (count == 4)
//		```
//
//		➡️ 4th window
//
//		### ⭐ But one important interview point
//
//		Don't depend too much on **2nd/3rd position** in real projects because window-handle order isn't the best way to identify a particular window.
//
//		A better approach is to identify the window using something meaningful, such as its **title or URL**:
//
//		```java
//		for (String window : driver.getWindowHandles()) {
//
//		    driver.switchTo().window(window);
//
//		    if (driver.getTitle().contains("Registration")) {
//		        break;
//		    }
//		}
//		```
//
//		So remember:
//
//		```text
//		getWindowHandle()   → current/one window
//		getWindowHandles()  → all windows
//		switchTo().window() → move to required window
//		```
//
//		And if you need a specific **2nd/3rd window for practice**, use the counter approach first—it is easier to learn.

	}
}