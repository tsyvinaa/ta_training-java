package com.epam.training.student_anastasiia_tsyvina.steps;

import com.epam.training.student_anastasiia_tsyvina.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class SauceDemoSteps {
    private final LoginPage loginPage;

    public SauceDemoSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void loginWithCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    public String getErrorMessage() {
        return loginPage.getErrorMessage();
    }
}
