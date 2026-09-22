# WebAutomation - Selenium BDD Test Framework

A robust web automation framework built with **Selenium**, **Cucumber (BDD)**, and **TestNG** for automated testing of web applications. This framework follows the **Page Object Model (POM)** design pattern and includes comprehensive test reporting using ExtentReports.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup & Installation](#setup--installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Execution](#test-execution)
- [Test Reports](#test-reports)
- [Framework Architecture](#framework-architecture)
- [Contributing](#contributing)

## 🎯 Project Overview

This is an enterprise-grade automation testing framework designed to provide a scalable, maintainable, and reusable architecture for web application testing. It currently includes automated tests for **OrangeHRM** application login functionality and can be extended to support additional modules and applications.

## ✨ Features

- **Behavior-Driven Development (BDD)**: Written using Gherkin syntax for non-technical stakeholder collaboration
- **Page Object Model (POM)**: Clean separation of page elements and test logic
- **Cross-browser Support**: Chrome, Firefox, Edge, Internet Explorer, and Headless Chrome
- **Automatic WebDriver Management**: Integrated WebDriver Manager for automatic driver downloads
- **Configuration Management**: Environment-based configuration with properties files
- **Wait Mechanisms**: Implicit and explicit waits for robust test execution
- **Logging**: SLF4J integration for comprehensive test logging
- **Test Reports**: ExtentReports integration for detailed HTML test reports
- **Dependency Injection**: PicoContainer for efficient object management
- **Data-Driven Testing**: Support for parameterized test scenarios

## 🛠 Tech Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **Java** | 25 | Programming Language |
| **Maven** | 3.14.1 | Build & Dependency Management |
| **Selenium** | 4.49.0 | Web Automation |
| **Cucumber** | 7.34.8 | BDD Framework |
| **TestNG** | (via cucumber-testng) | Test Framework |
| **Lombok** | 1.18.48 | Code Generation (Boilerplate Reduction) |
| **SLF4J** | 2.0.19 | Logging Framework |
| **ExtentReports** | 1.14.0 | Test Reporting |
| **WebDriverManager** | 6.3.4 | WebDriver Management |
| **Apache POI** | 5.5.1 | Excel/CSV Data Handling |
| **Owner** | 1.0.12 | Configuration Management |
| **SikuliX** | 2.0.5 | Image-based Automation |

## 📁 Project Structure

```
WebAutomation/
├── src/
│   ├── main/java/com/automation/
│   │   ├── pageobjects/           # Page Object Classes
│   │   │   └── orangehrm/
│   │   │       └── LoginPage.java
│   │   ├── objectmanager/         # Manager Classes
│   │   │   ├── DriverManager.java
│   │   │   ├── PageObjectManager.java
│   │   │   ├── WaitManager.java
│   │   │   └── FileReaderManager.java
│   │   ├── datareader/            # Configuration Readers
│   │   │   └── ConfigFileReader.java
│   │   ├── helper/                # Helper Classes
│   │   │   ├── Constant.java
│   │   │   ├── FrameworkConfig.java
│   │   │   ├── ScenarioContext.java
│   │   │   ├── TestContext.java
│   │   │   └── EncodeDecode.java
│   │   └── enums/                 # Enumerations
│   │       └── DriverType.java
│   └── test/
│       ├── java/com/automation/
│       │   ├── runner/            # Test Runner
│       │   │   └── TestRunner.java
│       │   └── stepdefinition/    # Step Definitions
│       │       └── LoginStepDefinition.java
│       └── resources/
│           ├── features/          # Feature Files (Gherkin)
│           │   └── orangehrm/
│           │       └── Login.feature
│           └── config/
│               ├── config.properties
│               └── spark-config.xml
├── pom.xml                        # Maven Configuration
├── target/                        # Build Output
├── test-output/                   # Test Reports
└── README.md                      # This File
```

## 📦 Prerequisites

- **Java JDK 25** or higher
- **Maven 3.6.0** or higher
- **Git** (for version control)
- **A modern web browser** (Chrome, Firefox, Edge)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

## 🚀 Setup & Installation

### 1. Clone the Repository

```bash
git clone <repository-url>
cd WebAutomation
```

### 2. Verify Java Installation

```bash
java -version
```

Ensure you have Java 25 installed. Update your `JAVA_HOME` environment variable if needed.

### 3. Verify Maven Installation

```bash
mvn -version
```

### 4. Install Dependencies

```bash
mvn clean install
```

This command will download all required dependencies and compile the project.

### 5. Build the Project

```bash
mvn clean compile
```

## ⚙️ Configuration

### 1. Update Configuration File

Edit `src/test/resources/config/config.properties`:

```properties
# Environment Configuration
environment=acceptance              # Options: acceptance, staging, production
browser=chrome                       # Options: chrome, firefox, edge, ie, chrome_headless
implicitWait=10                      # Implicit wait in seconds

# Application URLs
acceptance.url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
staging.url=<staging-url>
production.url=<production-url>
```

### 2. Supported Browsers

| Browser | Configuration Value |
|---------|-------------------|
| Google Chrome | `chrome` |
| Firefox | `firefox` |
| Microsoft Edge | `edge` |
| Internet Explorer | `ie` |
| Chrome Headless | `chrome_headless` |

### 3. Environment Configuration

The framework uses **Owner** library for configuration management, which supports:
- System properties
- Configuration properties files
- Environment variables
- Property overrides

### 4. Logging Configuration

Edit `src/test/resources/log4j2.xml` to customize logging levels and output formats.

## ✅ Running Tests

### 1. Run All Tests

```bash
mvn test
```

### 2. Run Specific Test Tag

```bash
mvn test -Dtags="@Smoke"
```

### 3. Run Tests for Specific Feature

```bash
mvn test -Dfeatures="src/test/resources/features/orangehrm/Login.feature"
```

### 4. Run Tests with Specific Browser

```bash
mvn test -Dbrowser=firefox
```

### 5. Run Tests in Headless Mode

```bash
mvn test -Dbrowser=chrome_headless
```

### 6. Run with Custom Configuration

```bash
mvn test -Denvironment=staging -Dbrowser=chrome
```

## 📊 Test Execution

### Example Feature File (Gherkin)

**File**: `src/test/resources/features/orangehrm/Login.feature`

```gherkin
Feature: User check Login feature

  @Smoke
  Scenario Outline: User check Successful Login
    Given user open orange HRM application
    When User enter "<username>" and "<password>"
    And User Click on sign in button
    Then User verify login

    Examples:
      | username | password |
      | Admin    | admin123 |
```

### Step Definitions

Step definitions in `src/test/java/com/automation/stepdefinition/LoginStepDefinition.java` implement the Gherkin steps and interact with page objects.

## 📈 Test Reports

### Report Generation

After test execution, ExtentReports generates detailed HTML reports:

**Report Location**: `test-output/Automation-report/`

### Accessing Reports

1. Open `test-output/Automation-report/index.html` in a web browser
2. Reports include:
   - Test execution summary
   - Pass/Fail status
   - Execution timeline
   - Browser and environment details
   - Screenshots on failure (if configured)

### Report Configuration

Edit `src/test/resources/spark-config.xml` to customize report appearance and content.

## 🏗 Framework Architecture

### 1. Page Object Model (POM)

Each page is represented as a class with:
- **Element Locators** (using @FindBy annotations)
- **Page Actions** (methods for user interactions)
- **Assertions** (verification methods)

**Example**: `com.automation.pageobjects.orangehrm.LoginPage`

```java
public class LoginPage {
    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement username;
    
    public void enterCredentials(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
    }
}
```

### 2. Object Manager Pattern

**PageObjectManager**: Manages all page object instances
- Lazy initialization of page objects
- Singleton pattern implementation
- Centralized page object access

**DriverManager**: Manages WebDriver instances
- Browser initialization
- Driver cleanup
- Cross-browser support

**WaitManager**: Handles explicit waits
- Element presence waits
- Element visibility waits
- Custom wait conditions

**FileReaderManager**: Manages configuration file reading
- Singleton pattern
- Configuration caching
- Property override support

### 3. Helper Classes

- **TestContext**: Manages test-level context and shared resources
- **ScenarioContext**: Manages scenario-specific data
- **FrameworkConfig**: Configuration interface using Owner library
- **EncodeDecode**: Encryption/Decryption utilities for sensitive data
- **Constant**: Framework constants

### 4. Step Definitions

- Bridge between Gherkin scenarios and Java code
- Use dependency injection via PicoContainer
- Interact with page objects through TestContext

## 🔧 Adding New Tests

### 1. Create a New Feature File

```gherkin
Feature: New Feature Name

  @NewTag
  Scenario: Test Scenario
    Given some precondition
    When some action is performed
    Then verify the result
```

### 2. Create a New Page Object

```java
package com.automation.pageobjects.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPage {
    private WebDriver driver;
    
    @FindBy(xpath = "//locator")
    private WebElement element;
    
    public NewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void performAction() {
        // Action implementation
    }
}
```

### 3. Register Page Object in PageObjectManager

```java
public NewPage getNewPage() {
    if(newPage == null) {
        newPage = new NewPage(driver);
    }
    return newPage;
}
```

### 4. Create Step Definition

```java
package com.automation.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class NewStepDefinition {
    
    @Given("step description")
    public void stepName() {
        // Step implementation
    }
}
```

## 🐛 Troubleshooting

### WebDriver Not Found

```bash
# Solution: Ensure WebDriver Manager is downloaded
mvn clean install
```

### Configuration Not Loading

```bash
# Verify config.properties path:
# src/test/resources/config/config.properties exists
```

### Tests Timing Out

```properties
# Increase implicit wait in config.properties
implicitWait=20
```

### Browser Not Starting

```bash
# Verify browser is installed and PATH is set
# Test with headless mode for troubleshooting:
# browser=chrome_headless
```

## 📚 Best Practices

1. **Follow POM Pattern**: Keep page elements separate from test logic
2. **Descriptive Naming**: Use clear, meaningful names for methods and locators
3. **DRY Principle**: Avoid code duplication by creating reusable methods
4. **Explicit Waits**: Use explicit waits instead of Thread.sleep()
5. **Logging**: Log important steps for debugging
6. **Error Handling**: Implement proper exception handling
7. **Data-Driven Tests**: Use Examples in feature files for multiple test cases
8. **Tags**: Use appropriate tags (@Smoke, @Regression, etc.) for test organization

## 🤝 Contributing

To contribute to this project:

1. Create a new branch for your feature
2. Write tests following the existing patterns
3. Ensure all tests pass locally
4. Submit a pull request with detailed description

## 📄 License

This project is proprietary and confidential.

## 📞 Support

For issues or questions, contact the QA team or project maintainer.

---

**Last Updated**: September 2026  
**Framework Version**: 1.0-SNAPSHOT  
**Java Version Required**: 25+  
**Maven Version Required**: 3.6.0+
