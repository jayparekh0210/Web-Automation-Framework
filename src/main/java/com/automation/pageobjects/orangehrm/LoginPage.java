package com.automation.pageobjects.orangehrm;

import com.automation.objectmanager.FileReaderManager;
import com.automation.objectmanager.WaitManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

@Slf4j
public class LoginPage {

    WebDriver driver;
    WaitManager wait;

    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement username;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//img[@alt=\"client brand logo\"]")
    private WebElement clientLogo;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitManager(driver);
    }

    private void enterUsername(String usernameVal){
        wait.waitForElementToBePresent(username);
        username.sendKeys(usernameVal);
    }

    private void enterPassword(String passwordVal){
        password.sendKeys(passwordVal);
    }

    public void enterCredentials(String usernameVal, String passwordVal){
        enterUsername(usernameVal);
        enterPassword(passwordVal);
    }

    public void openApplication() throws InterruptedException {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
        wait.applyWait(1000);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void verifyClientLogoIsPresent(){
        wait.waitForElementToBePresent(clientLogo);
        driver.quit();
    }
}
