# Selenium WebDriver Automation: Formy Form Submission

This project demonstrates automated form submission using **Selenium WebDriver**, **JUnit 5**, and the **Page Object Model**.  
The test scenario replicates the process of creating a "paste" by filling out a form on the website [formy-project.herokuapp.com/form](https://formy-project.herokuapp.com/form).

---

## Scenario Description

Automated actions include:

1. Open the Formy form page.
2. Fill in the following fields:
    - **First Name**: `Hello from WebDriver`
    - **Last Name**: `helloweb`
    - **Job Title**: `10 Minutes`
3. Click the Submit button.
4. Verify the form submission leads to a "Thank You" confirmation page.

---

## Project Structure

- `pages/FormyPage.java` — Page Object class encapsulating form interactions.
- `tests/FormSubmissionTest.java` — JUnit test class executing the scenario.
- `pom.xml` — Maven build configuration and dependencies.

---

## Technologies Used

- Java 17+ (or Java 11+)
- Selenium WebDriver 4.21.0
- JUnit 5.10.2
- Maven

---

## How to Run

1. Clone the repository.
2. Ensure ChromeDriver is in your system path.
3. Run tests using Maven:

```bash
mvn clean test
