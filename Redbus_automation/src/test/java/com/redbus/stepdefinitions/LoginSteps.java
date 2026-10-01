package com.redbus.stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.redbus.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {


    // ============================================================
    // GIVEN
    // ============================================================

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {

        // Browser is already opened by Hooks @Before

        System.out.println("User is on login page");
    }


    // ============================================================
    // WHEN
    // ============================================================

    @When("the user enters valid login credentials")
    public void userEntersValidLoginCredentials() {

        // Enter email
        Hooks.driver.findElement(By.id("userEmail"))
                .sendKeys("hnellori@gmail.com");

        // Enter password
        Hooks.driver.findElement(By.id("userPassword"))
                .sendKeys("Hemu@1234");

        // Click Login
        Hooks.driver.findElement(By.cssSelector("[value='Login']"))
                .click();

        System.out.println("Valid credentials entered");
    }


    // ============================================================
    // THEN
    // ============================================================

    @Then("the user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {

        // Get current URL
        String currentUrl = Hooks.driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        // Validate that login page changed
        Assert.assertNotEquals(
                currentUrl,
                "https://rahulshettyacademy.com/client"
        );

        System.out.println("User logged in successfully");
    }
}