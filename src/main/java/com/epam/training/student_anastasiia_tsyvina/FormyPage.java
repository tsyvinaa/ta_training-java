package com.epam.training.student_anastasiia_tsyvina;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormyPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FormyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='job-title']")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//select[@id='select-menu']")
    private WebElement experienceDropdown;

    @FindBy(xpath = "//a[contains(@class,'btn-primary')]")
    private WebElement submitButton;

    public void open() {
        driver.get("https://formy-project.herokuapp.com/form");
    }

    public void fillForm(String firstName, String lastName, String experienceText, String jobTitle) {
        try {
            safeType(firstNameInput, firstName);
            safeType(lastNameInput, lastName);
            safeType(jobTitleInput, jobTitle);

            scrollToCenter(experienceDropdown);

            Select select = new Select(experienceDropdown);

            if ("2-4".equals(experienceText)) {
                select.selectByVisibleText(experienceText);
                Thread.sleep(1000); // Delay
            } else {
                select.selectByVisibleText(experienceText);
            }

            scrollToCenter(submitButton);
            submitButton.click();

        } catch (StaleElementReferenceException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isConfirmationVisible() {
        try {
            return wait.until(ExpectedConditions.urlContains("/thanks"));
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void safeType(WebElement element, String text) {
        scrollToCenter(element);
        element.clear();
        for (char c : text.toCharArray()) {
            element.sendKeys(Character.toString(c));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void scrollToCenter(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element);
    }
}
