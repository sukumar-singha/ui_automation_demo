# UI Automation Framework

This is a complete Java UI automation framework that demonstrates the implementation of:
- Page Object Model (POM)
- Factory Pattern
- Singleton Pattern
- Builder Pattern

## Project Structure

```
ui-automation-framework/
├── pom.xml
├── src/
    ├── main/java/com/example/framework/
    │   ├── config/
    │   │   ├── ConfigReader.java
    │   │   └── FrameworkConfig.java
    │   ├── driver/
    │   │   ├── DriverFactory.java
    │   │   └── DriverManager.java
    │   ├── pages/
    │   │   ├── BasePage.java
    │   │   ├── HomePage.java
    │   │   └── LoginPage.java
    │   ├── data/
    │   │   └── UserData.java
    │   └── utils/
    │       ├── WaitUtils.java
    │       └── ReportUtils.java
    └── test/java/com/example/tests/
        └── LoginTest.java
```

## Requirements

- Java 11 or higher
- Maven
- Web browsers (Chrome, Firefox, etc.)

## Setup

1. Extract this zip file
2. Make sure you have Maven installed
3. Open a terminal and navigate to the project directory
4. Run `mvn clean install` to download all dependencies

## Running Tests

To run the test suite:
```bash
mvn clean test
```

## Design Patterns Used

- **Page Object Model (POM)**: Encapsulates page elements and actions
- **Factory Pattern**: Creates different browser instances
- **Singleton Pattern**: Manages WebDriver instances
- **Builder Pattern**: Simplifies test data creation

## How Patterns Work Together
1. Page Object Model provides the structure for page interactions (LoginPage, HomePage)

2. Factory Pattern (DriverFactory) creates different browser instances based on configuration

3. Singleton Pattern (DriverManager) ensures a single WebDriver instance per thread

4. Builder Pattern (UserData) simplifies creation of complex test data objects

-----------In the test class, all these patterns are seamlessly integrated------------
// Get test data using Builder Pattern
UserData user = UserData.getStandardUser();

// Get WebDriver using Singleton Pattern (DriverManager utilizes Factory Pattern internally)
driver = DriverManager.getDriver();

// Use Page Object Model for test steps
LoginPage loginPage = new LoginPage(driver);
HomePage homePage = loginPage.login(user.getUsername(), user.getPassword());

