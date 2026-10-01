//package com.redbus.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class HomePage extends BasePage {
//
//    private By products =
//            By.id("products");
//
//    public HomePage(WebDriver driver) {
//
//        super(driver);
//    }
//
//    public ProductPage clickProducts() {
//
//        driver.findElement(products)
//                .click();
//
//        return new ProductPage(driver);
//    }
//}