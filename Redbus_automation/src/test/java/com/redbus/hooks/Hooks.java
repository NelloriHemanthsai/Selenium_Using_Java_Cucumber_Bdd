package com.redbus.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    // WebDriver object
    public static WebDriver driver;


    // ============================================================
    // @Before
    // ============================================================
    // This method runs BEFORE every Cucumber Scenario
    // ============================================================

    @Before
    public void setUp() {

        // Launch Chrome
        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // Open application
        driver.get("https://rahulshettyacademy.com/client");

        System.out.println("Browser launched");
        System.out.println("Application opened");
    }


    // ============================================================
    // @After
    // ============================================================
    // This method runs AFTER every Cucumber Scenario
    // ============================================================

    @After
    public void tearDown() {

        // Close browser
        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed");
    }
}