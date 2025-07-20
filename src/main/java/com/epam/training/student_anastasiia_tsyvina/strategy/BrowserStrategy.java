
package com.epam.training.student_anastasiia_tsyvina.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserStrategy {
    public static WebDriver createDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
            default:
                return new ChromeDriver();
        }
    }
}
