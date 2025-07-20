
package com.epam.training.student_anastasiia_tsyvina.steps;

import com.epam.training.student_anastasiia_tsyvina.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public String getErrorMessage() {
        return loginPage.getErrorMessage();
    }

    public String getCurrentUrl() {
        return loginPage.getCurrentUrl();
    }
}
