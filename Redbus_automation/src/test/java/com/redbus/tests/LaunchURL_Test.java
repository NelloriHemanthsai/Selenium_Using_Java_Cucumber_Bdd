package com.redbus.tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchURL_Test {
	 public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println("succesfully opening the page");
		driver.manage().window().maximize();
	}

}
