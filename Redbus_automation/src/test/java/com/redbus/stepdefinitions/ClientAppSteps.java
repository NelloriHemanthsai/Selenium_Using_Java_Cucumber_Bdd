package com.redbus.stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.redbus.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ClientAppSteps {

    WebDriverWait wait;


    // ============================================================
    // GIVEN
    // ============================================================

    @Given("the user is on the client application login page")
    public void userIsOnClientApplicationLoginPage() {

        // Browser and application are already opened by Hooks

        System.out.println("User is on the login page");

        // Create explicit wait
        wait = new WebDriverWait(
                Hooks.driver,
                Duration.ofSeconds(10)
        );
    }


    // ============================================================
    // WHEN - LOGIN
    // ============================================================

    @When("the user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {

        // Enter email
        Hooks.driver.findElement(
                By.id("userEmail")
        ).sendKeys("hnellori@gmail.com");


        // Enter password
        Hooks.driver.findElement(
                By.id("userPassword")
        ).sendKeys("Hemu@1234");


        // Click Login
        Hooks.driver.findElement(
                By.cssSelector("[value='Login']")
        ).click();


        System.out.println("User logged in successfully");
    }


    // ============================================================
    // WHEN - SELECT PRODUCT
    // ============================================================

    @When("the user selects the product {string}")
    public void userSelectsTheProduct(String productName) {

        // Wait until products are visible
        List<WebElement> productList =
                wait.until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By.cssSelector(".card-body")
                                )
                );


        System.out.println(
                "Products found: " + productList.size()
        );


        // Search for required product
        for (WebElement product : productList) {

            String productNameFromPage =
                    product.findElement(
                            By.cssSelector("h5 b")
                    )
                    .getText()
                    .trim();


            System.out.println(
                    "Product found: " + productNameFromPage
            );


            // Compare product name
            if (productNameFromPage.equalsIgnoreCase(productName)) {

                // Click Add to Cart
                product.findElement(
                        By.cssSelector("button:nth-of-type(2)")
                ).click();


                // Wait for spinner to disappear
                wait.until(
                        ExpectedConditions
                                .invisibilityOfElementLocated(
                                        By.cssSelector(
                                                ".ngx-spinner-overlay"
                                        )
                                )
                );


                System.out.println(
                        productName + " added to cart"
                );

                break;
            }
        }
    }


    // ============================================================
    // WHEN - CHECKOUT
    // ============================================================

    @When("the user proceeds to checkout")
    public void userProceedsToCheckout() {

        // Wait for Cart button
        wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                By.cssSelector(
                                        "button[routerlink='/dashboard/cart']"
                                )
                        )
        ).click();


        System.out.println("Cart opened");


        // Click Checkout
        Hooks.driver.findElement(
                By.xpath("//button[text()='Checkout']")
        ).click();


        System.out.println("Checkout page opened");
    }


    // ============================================================
    // WHEN - COUNTRY
    // ============================================================

    @When("the user selects country {string}")
    public void userSelectsCountry(String countryName) {

        // Find country input
        WebElement country =
                Hooks.driver.findElement(
                        By.cssSelector(
                                "input[placeholder='Select Country']"
                        )
                );


        // Enter country
        country.sendKeys("IND");


        // Select India from dropdown
        wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                By.xpath(
                                        "//button[contains(@class,'ta-item') and normalize-space(.)='"
                                        + countryName
                                        + "']"
                                )
                        )
        ).click();


        System.out.println(
                "Country selected: " + countryName
        );
    }


    // ============================================================
    // THEN
    // ============================================================

    @Then("the user should be able to complete the checkout details")
    public void userShouldBeAbleToCompleteCheckoutDetails() {

        // Verify that checkout page is still displayed
        String currentUrl = Hooks.driver.getCurrentUrl();

        System.out.println(
                "Current URL: " + currentUrl
        );


        // Basic validation
        Assert.assertTrue(
                currentUrl.contains("dashboard"),
                "User is not on the expected checkout flow"
        );


        System.out.println(
                "Checkout details are displayed successfully"
        );
    }
}