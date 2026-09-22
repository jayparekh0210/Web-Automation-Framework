package com.automation.objectmanager;

import com.automation.enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class DriverManager {
    private final DriverType driverType;
    private WebDriver driver;

    public DriverManager(){
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver(){
        if(driver == null){
            driver = createDriver();
        }

        return driver;
    }

    private WebDriver createDriver(){

        switch(driverType){
            case FIREFOX -> driver = new FirefoxDriver();
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito", "--window-size=1366,768");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("no-sandbox");
                options.addArguments("--disable-extensions");
                driver = new ChromeDriver(options);
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("inPrivate");
                driver = new EdgeDriver(options);
            }
            case CHROME_HEADLESS -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--window-size=1366,768");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
            case INTERNET_EXPLORER -> driver = new InternetExplorerDriver();
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitWait()));
        return driver;
    }

    public void closeDriver(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.close();
        driver.quit();
    }
}
