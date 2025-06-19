# PasteCode.io Automation Test

This project automates the creation of a new code snippet on [PasteCode.io](https://pastecode.io) using Selenium WebDriver and JUnit5. It follows the Page Object Model pattern.

## Tools & Technologies

- Java 11+
- Selenium WebDriver 4.21.0
- JUnit 5
- WebDriverManager
- Maven
- ChromeDriver

## Test Scenario

The automated test performs the following steps:

1. Opens `https://pastecode.io`
2. Fills the **code field** with:
   ```sh
   git config --global user.name  "New Sheriff in Town"
   git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
   git push origin master --force
   ```
3. Sets syntax highlighting to `sh`
4. Sets paste expiration to **15 Minutes**
5. Sets the paste title to: `how to gain dominance among developers`
6. Scrolls to the top and waits 3 seconds before clicking **"Save Snippet"**
7. Waits until the snippet creation confirmation link appears
8. Closes the browser

> The test repeats this scenario 5 times by clicking the **"Create Another Snippet"** button.

If a pop-up appears, it is detected and closed automatically.

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com.epam.training.student_anastasiia_tsyvina/
│           └── PasteCodePage.java
├── test/
│   └── java/
│       └── com.epam.training.student_anastasiia_tsyvina/
│           └── PasteCodeTest.java
```

## How to Run

```bash
mvn test
```

Make sure:
- You have [Maven](https://maven.apache.org/) installed
- Chrome is up-to-date on your system

## Notes

- WebDriverManager handles ChromeDriver automatically
- All ads are ignored or removed where possible
- The test checks that the snippet was successfully created based on element visibility
- The test exits cleanly after each run
