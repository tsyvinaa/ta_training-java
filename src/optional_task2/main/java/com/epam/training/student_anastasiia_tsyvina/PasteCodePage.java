package com.epam.training.student_anastasiia_tsyvina;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PasteCodePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PasteCodePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get("https://pastecode.io/");
    }

    public void createPaste(String code, String expiration, String title) {
        WebElement codeInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("textarea.inputarea")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", codeInput);
        pause(1000);
        codeInput.sendKeys(code);

        WebElement syntaxCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.ant-card-body")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", syntaxCard);

        WebElement syntaxDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select') and @data-sentry-element='Select']")));
        syntaxDropdown.click();

        WebElement syntaxInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input#syntax_selectbox")));
        syntaxInput.sendKeys("sh");

        WebElement shOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option')]//div[text()='sh']")));
        shOption.click();

        WebElement titleInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='Title (Optional)']")));
        titleInput.sendKeys(title);

        WebElement expirationDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(), 'Expire After (Optional)')]/ancestor::div[contains(@class,'ant-select')]")));
        expirationDropdown.click();

        WebElement option15 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option')]//div[text()='15 Minutes']")));
        option15.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        pause(3000);

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[span[text()='Save Snippet']]")));
        saveButton.click();

        closePopupIfPresent();
    }

    public void clickCreateNewButton() {
        WebElement createNewButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[span[text()='Create New']]")));
        createNewButton.click();
    }

    private void closePopupIfPresent() {
        try {
            WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeButton = popupWait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[aria-label='Close']")));
            closeButton.click();
        } catch (TimeoutException ignored) {
        }
    }

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
