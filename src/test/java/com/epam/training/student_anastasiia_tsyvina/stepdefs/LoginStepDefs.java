
package com.epam.training.student_anastasiia_tsyvina.stepdefs;

import com.epam.training.student_anastasiia_tsyvina.adapter.LoginAssertions;
import com.epam.training.student_anastasiia_tsyvina.driver.DriverSingleton;
import com.epam.training.student_anastasiia_tsyvina.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
    private WebDriver driver;
    private LoginSteps loginSteps;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver("chrome");
        loginSteps = new LoginSteps(driver);
    }

    @Given("I open SauceDemo website")
    public void i_open_sauce_demo_website() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginSteps.login(username, password);
    }

    @Then("I should see error message {string}")
    public void i_should_see_error_message(String expectedMessage) {
        LoginAssertions.assertError(loginSteps.getErrorMessage(), expectedMessage);
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        LoginAssertions.assertSuccessUrl(loginSteps.getCurrentUrl());
    }

    @After
    public void tearDown() {
        DriverSingleton.quitDriver();
    }
}
