# SauceDemo Login Test Automation

This project automates login form validation for [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver, TestNG, and Maven.

## Launch URL
https://www.saucedemo.com/

## Use Cases Covered

### UC-1: Login with empty credentials
- Type any credentials in the "Username" and "Password" fields.
- Clear both inputs.
- Click the "Login" button.
- Expected: "Username is required" error message is displayed.

### UC-2: Login with Username only
- Type any credentials in the "Username" field.
- Enter any password.
- Clear the "Password" input.
- Click the "Login" button.
- Expected: "Password is required" error message is displayed.

### UC-3: Login with valid credentials
- Use a valid username (e.g., `standard_user`).
- Use the password `secret_sauce`.
- Click the "Login" button.
- Expected: The page title contains "Swag Labs".

## Technologies Used

| Component        | Value                          |
|------------------|--------------------------------|
| Programming Language | Java 17                    |
| Build Tool       | Maven                          |
| Test Framework   | TestNG                          |
| Automation Tool  | Selenium WebDriver              |
| Browsers         | Chrome, Firefox                 |
| Element Locators | CSS                             |
| Assertions       | AssertJ                         |
| Logging          | SLF4J                           |
| Test Parameterization | TestNG DataProvider         |
| Parallel Execution | Enabled via DataProvider     |

## Optional Design Patterns and Practices

- Singleton pattern
- Adapter pattern
- Strategy pattern
- BDD-style test structure (optionally with Cucumber)
## Run:   
-mvn clean test -DsuiteXmlFile=testng.xml


