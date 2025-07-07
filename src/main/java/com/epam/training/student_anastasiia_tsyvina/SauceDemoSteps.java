package com.epam.training.student_anastasiia_tsyvina;

import com.epam.training.student_anastasiia_tsyvina.LoginPage;
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
