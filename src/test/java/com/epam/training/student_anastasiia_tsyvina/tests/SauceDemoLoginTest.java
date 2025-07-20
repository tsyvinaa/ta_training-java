
package com.epam.training.student_anastasiia_tsyvina.tests;

import com.epam.training.student_anastasiia_tsyvina.driver.DriverSingleton;
import com.epam.training.student_anastasiia_tsyvina.steps.LoginSteps;
import com.epam.training.student_anastasiia_tsyvina.adapter.LoginAssertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class SauceDemoLoginTest {
    private WebDriver driver;
    private LoginSteps loginSteps;
    private static final Logger logger = LoggerFactory.getLogger(SauceDemoLoginTest.class);

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Starting test in browser: {}", browser);
        driver = DriverSingleton.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        loginSteps = new LoginSteps(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = com.epam.training.student_anastasiia_tsyvina.dataprovider.LoginDataProvider.class)
    public void testLogin(String username, String password, String expectedResult) {
        logger.info("Attempting login with username='{}', password='{}'", username, password);
        loginSteps.login(username, password);
        if ("success".equals(expectedResult)) {
            LoginAssertions.assertSuccessUrl(loginSteps.getCurrentUrl());
        } else {
            LoginAssertions.assertError(loginSteps.getErrorMessage(), expectedResult);
        }
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Ending test, closing browser");
        DriverSingleton.quitDriver();
    }
}
