package com.automation.objectmanager;

import com.automation.pageobjects.orangehrm.LoginPage;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class PageObjectManager {

    private final WebDriver driver;
    private LoginPage loginPage = null;



    public LoginPage getLoginPage(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }


}
