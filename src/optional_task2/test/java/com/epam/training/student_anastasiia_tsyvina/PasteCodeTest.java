package com.epam.training.student_anastasiia_tsyvina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PasteCodeTest {

    private WebDriver driver;
    private PasteCodePage pastePage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        pastePage = new PasteCodePage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void repeatPasteCreationFiveTimes() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";
        String title = "how to gain dominance among developers";

        pastePage.open();

        for (int i = 0; i < 5; i++) {
            pastePage.createPaste(code, "15 Minutes", title);

            WebElement snippetLink = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a#snippet_created_link"))
            );
            assertNotNull(snippetLink, "Snippet creation link not found, paste failed at iteration " + (i + 1));

            pastePage.clickCreateNewButton();
        }
    }
}
