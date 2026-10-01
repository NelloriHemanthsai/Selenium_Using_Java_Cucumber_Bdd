package com.redbus.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.redbus.stepdefinitions",
                "com.redbus.hooks"
        },
        plugin = "pretty",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}