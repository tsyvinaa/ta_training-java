package com.epam.training.student_anastasiia_tsyvina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver create() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
