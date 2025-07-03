package com.epam.training.student_anastasiia_tsyvina;

import com.epam.training.student_anastasiia_tsyvina.DriverManager;
import com.epam.training.student_anastasiia_tsyvina.steps.SauceDemoSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoLoginTest {
    private WebDriver driver;
    private SauceDemoSteps steps;

    private static final Logger logger = LoggerFactory.getLogger(SauceDemoLoginTest.class);

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Launching browser: {}", browser);
        driver = DriverManager.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        steps = new SauceDemoSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");
        DriverManager.quitDriver();
    }

    @Test
    public void testEmptyCredentials() {
        logger.info("UC-1: Test login with empty credentials");
        steps.loginWithCredentials("", "");
        assertThat(steps.getErrorMessage()).contains("Username is required");
    }

    @Test
    public void testOnlyUsernameProvided() {
        logger.info("UC-2: Test login with username only");
        steps.loginWithCredentials("standard_user", "");
        assertThat(steps.getErrorMessage()).contains("Password is required");
    }

    @Test(dataProvider = "validCredentials")
    public void testValidLogin(String username, String password) {
        logger.info("UC-3: Test valid login with {}", username);
        steps.loginWithCredentials(username, password);
        assertThat(driver.getTitle()).contains("Swag Labs");
    }

    @DataProvider(name = "validCredentials", parallel = true)
    public Object[][] provideValidCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }
}
