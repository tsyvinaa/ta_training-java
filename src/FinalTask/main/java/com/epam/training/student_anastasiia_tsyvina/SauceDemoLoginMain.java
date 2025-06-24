package com.epam.training.student_anastasiia_tsyvina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginMain {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com/");
            System.out.println("UC-1: Empty credentials");
            login(driver, "", "");
            checkError(driver, "Username is required");

            driver.get("https://www.saucedemo.com/");
            System.out.println("UC-2: Only username provided");
            login(driver, "standard_user", "");
            checkError(driver, "Password is required");

            driver.get("https://www.saucedemo.com/");
            System.out.println("UC-3: Valid login");
            login(driver, "standard_user", "secret_sauce");
            String title = driver.getTitle();
            if (title.contains("Swag Labs")) {
                System.out.println("UC-3 Passed");
            } else {
                System.out.println("UC-3 Failed: Wrong title: " + title);
            }

        } finally {
            driver.quit();
        }
    }

    public static void login(WebDriver driver, String username, String password) {
        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));

        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public static void checkError(WebDriver driver, String expected) {
        WebElement errorBox = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String actual = errorBox.getText();
        if (actual.contains(expected)) {
            System.out.println("Passed: " + expected);
        } else {
            System.out.println("Failed: Expected [" + expected + "] but got [" + actual + "]");
        }
    }
}

