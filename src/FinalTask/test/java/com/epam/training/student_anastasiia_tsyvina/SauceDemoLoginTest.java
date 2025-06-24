package com.epam.training.student_anastasiia_tsyvina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoLoginTest {
    private WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(SauceDemoLoginTest.class);

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Launching browser: {}", browser);
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }

    private void login(String username, String password) {
        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));

        usernameField.clear();
        passwordField.clear();

        if (username != null) usernameField.sendKeys(username);
        if (password != null) passwordField.sendKeys(password);

        loginButton.click();
    }

    private String getErrorMessage() {
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }

    @Test
    public void testEmptyCredentials() {
        logger.info("UC-1 Test Login form with empty credentials: ");
        login("", "");
        assertThat(getErrorMessage()).contains("Username is required");
    }

    @Test
    public void testOnlyUsernameProvided() {
        logger.info("UC-2 Test Login form with credentials by passing Username: ");
        login("standard_user", "");
        assertThat(getErrorMessage()).contains("Password is required");
    }

    @Test(dataProvider = "validCredentials")
    public void testValidLogin(String username, String password) {
        logger.info("UC-3 Test Login form with credentials by passing Username & Password: {}", username);
        login(username, password);
        assertThat(driver.getTitle()).contains("Swag Labs");
    }

    @DataProvider(name = "validCredentials", parallel = true)
    public Object[][] provideValidCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }
}