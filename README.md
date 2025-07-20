# SauceDemo Login Automation Project

## Description
Automated UI testing of login functionality on [SauceDemo](https://www.saucedemo.com).

## Use Cases
- **UC-1**: Empty credentials → "Username is required"
- **UC-2**: Empty password → "Password is required"
- **UC-3**: Valid login → URL changes to `/inventory.html`

## Features
- Selenium WebDriver + TestNG
- XPath locators
- DataProvider
- Assertions with AssertJ
- Logging with SLF4J
- Patterns: Singleton, Strategy, Adapter
- Optional BDD support

## Run Tests
```
mvn clean test -Dbrowser=chrome
```

## Author
Anastasiia Tsyvina, EPAM Final Task
