package com.infy.tests;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class infyPractiseTest2 {
	WebDriver  driver;
	
	@BeforeMethod
	public void launch() {
		
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void Test() throws IOException, Exception {
		String productName = "ZARA COAT 3";
		driver.findElement(By.id("userEmail")).sendKeys("hnellori@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hemu@1234");
	//	driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".left.mt-1")));
		
		
		//Thread.sleep(Duration.ofSeconds(5));
	
		Assert.assertEquals(driver.getTitle(),"Let's Shop");
		String pageName = driver.getTitle();
		System.out.println(pageName);
		
		
		//Scrreshot code
		
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\heman\\OneDrive\\Desktop\\application_Data\\screenshots\\first.png"));
		System.out.println("screenshot taking succesfuuly");
		
		//selecting particualr element
		@Nullable
		List<WebElement> AllProductElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-body")));
		
		for(WebElement ProductList:AllProductElements) {
			System.out.println("Enter the for loop");
			String productNameInLoop = ProductList.findElement(By.cssSelector("h5 b")).getText().trim();
			System.out.println(productNameInLoop);
			if(productNameInLoop.equalsIgnoreCase(productName)) {
				ProductList.findElement(By.cssSelector("button:nth-of-type(2)")).click();
				break;
			}
			
		}
		
		Thread.sleep(Duration.ofSeconds(5));
		
		//clicking cart btn
		driver.findElement(By.cssSelector(".fa.fa-shopping-cart")).click();
		
		//Thread.sleep(Duration.ofSeconds(5));
		//clicking checkout btn
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item') and normalize-space(.)='India']")).click();
		
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		//Thread.sleep(Duration.ofSeconds(5));
		
		String finalmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertEquals(finalmsg, "THANKYOU FOR THE ORDER.");
		
		System.out.println(finalmsg);
		
		File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("C:\\Users\\heman\\OneDrive\\Desktop\\application_Data\\screenshots\\ThankyouOrder.png"));
			System.out.println("screenshot taking succesfuuly");
		
		
		
		
		
		
	}

}
