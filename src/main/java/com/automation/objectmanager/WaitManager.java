package com.automation.objectmanager;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class WaitManager {

    WebDriverWait wait;
    WebDriver driver;

    public WaitManager(WebDriver driver){
        this.driver =  driver;
    }

    public WebDriverWait applyImplicitWait(int waitTime){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        return wait;
    }

    public void applyWait(long waitTime) throws InterruptedException{
        Thread.sleep(waitTime);
    }

    public void waitForElementToBePresent(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            log.error("Element not found");
        }
    }
}
