package com.automation.stepdefinition;

import com.automation.helper.TestContext;
import com.automation.pageobjects.orangehrm.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

    TestContext testContext;
    LoginPage loginPage;

    public LoginStepDefinition(TestContext testContext){
        this.testContext = testContext;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }
    @Given("user open orange HRM application")
    public void userOpenOrangeHRMApplication() throws InterruptedException{
        loginPage.openApplication();
    }

    @When("User enter {string} and {string}")
    public void userEnterAnd(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("User Click on sign in button")
    public void userClickOnSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("User verify login")
    public void userVerifyLogin() {
       loginPage.verifyClientLogoIsPresent();
    }
}
