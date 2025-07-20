
package com.epam.training.student_anastasiia_tsyvina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.xpath("//input[@class='input_error form_input'][@data-test='username']");
    private final By passwordField = By.xpath("//input[@class='input_error form_input'][@data-test='password']");
    private final By loginButton = By.xpath("//input[@data-test='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
