package com.automation.datareader;

import com.automation.enums.DriverType;
import com.automation.helper.EncodeDecode;
import com.automation.helper.FrameworkConfig;
import com.automation.objectmanager.WaitManager;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;
import java.util.Properties;

import static com.automation.helper.Constant.ORANGE_HRM_APP;

@Slf4j
public class ConfigFileReader {

    private static final String PROPERTIES_FILE_PATH = "src/test/resources/config.properties";
    private static final String REPORT_CONFIG_PATH = "src/test/resources/spark-config.xml";
    private final Properties properties;
    EncodeDecode encodeDecode;
    FrameworkConfig frameworkConfig;


    public ConfigFileReader() {
        encodeDecode = new EncodeDecode();
        properties = new Properties();
        frameworkConfig = ConfigFactory.create(FrameworkConfig.class);
    }

    public String getEnvironment() {
        return frameworkConfig.environment();
    }

    public long getImplicitWait() {
        String implicitWait = frameworkConfig.implicitWait();
        log.debug("Implicit wait is set to {}", implicitWait);

        if (implicitWait != null) {
            return Long.parseLong(implicitWait);
        } else {
            throw new InvalidParameterException("implicitWait is not set in config.properties");
        }

    }

    public String getApplicationUrl() {
        String url = frameworkConfig.url();
        log.debug("Application url is set to {}", url);
        if (url != null) {
            return url;
        } else {
            throw new InvalidParameterException("url is not set in config.properties");
        }
    }

    public DriverType getBrowser() {
        String browser = frameworkConfig.browser();
        if (browser == null || browser.equalsIgnoreCase("chrome")) {
            return DriverType.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            return DriverType.FIREFOX;
        } else if (browser.equalsIgnoreCase("edge")) {
            return DriverType.EDGE;
        } else if (browser.equalsIgnoreCase("ie")) {
            return DriverType.INTERNET_EXPLORER;
        } else if (browser.equalsIgnoreCase("chrome_headless")) {
            return DriverType.CHROME_HEADLESS;
        } else {
            throw new InvalidParameterException("Browser is not set in config.properties");
        }
    }
}
