package com.epam.training.student_anastasiia_tsyvina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormyTest {

    private WebDriver driver;
    private FormyPage formyPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/114.0.0.0 Safari/537.36");

        driver = new ChromeDriver(options);
        formyPage = new FormyPage(driver);
    }

    @Test
    @Order(1)
    public void testFormSubmission() {
        formyPage.open();
        formyPage.fillForm("Hello from WebDriver", "helloweb", "2-4", "AQA");
        assertTrue(formyPage.isConfirmationVisible());
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}