package com.infy.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class infyPractiseTest1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchingBrowser() {
		System.out.println("launching the browser");
	}
	
	@BeforeClass
	public void launchingChromeBroswer() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void test() throws Exception {
		String path = "C:\\Users\\heman\\OneDrive\\Desktop\\application_Data\\Applicationdetails.xlsx";
		
		  FileInputStream fi = new FileInputStream(path);
		   XSSFWorkbook workBook = new XSSFWorkbook(fi);
		   XSSFSheet sheet = workBook.getSheetAt(0);
		   int rows = sheet.getLastRowNum()-sheet.getFirstRowNum();
		   System.out.println(rows);
		   
		   for(int i=1;i<=rows;i++) {
			   String ProductName = sheet.getRow(i).getCell(0).getStringCellValue();
			   String emailId = sheet.getRow(i).getCell(1).getStringCellValue();
			   String passWord = sheet.getRow(i).getCell(2).getStringCellValue();
			   
			   driver.findElement(By.id("userEmail")).sendKeys(emailId);
			   driver.findElement(By.id("userPassword")).sendKeys(passWord);
			   driver.findElement(By.cssSelector("[value='Login']")).click();
			   driver.findElement(By.cssSelector(".fa.fa-sign-out")).click();
			   
			   System.out.println(i + "completed");
		   }
		   
		  FileOutputStream fo = new FileOutputStream(path);
		  workBook.write(fo);
		  workBook.close();
		  fo.close();
		   
	}

}
