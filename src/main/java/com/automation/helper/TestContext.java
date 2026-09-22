package com.automation.helper;


import com.automation.objectmanager.DriverManager;
import com.automation.objectmanager.PageObjectManager;
import lombok.Getter;

@Getter
public class TestContext {

    private final ScenarioContext scenarioContext;
    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }


}
