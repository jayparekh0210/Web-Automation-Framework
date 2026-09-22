package com.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com/automation/stepdefinition"},
        tags = "@Smoke",
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:test-output/Automation-report"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
