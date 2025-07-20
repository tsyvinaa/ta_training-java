package com.epam.training.student_anastasiia_tsyvina.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverSingleton() {}

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            switch (browser.toLowerCase()) {
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "chrome":
                default:
                    driver.set(new ChromeDriver());
                    break;
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
