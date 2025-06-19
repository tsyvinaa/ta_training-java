# String Pattern Analyzer Automation

## 📘 Project Description

This project is a part of an automation assignment using **Selenium WebDriver**, **JUnit**, and **Page Object** pattern. It includes:

1. Java logic for string pattern analysis  
2. Unit tests with FIRST and AAA principles  
3. End-to-end UI automation using Selenium (optional extension)

---

## Functional Goals

### Implement 3 analysis methods:
- **Max number of unequal consecutive characters**  
- **Max number of consecutive identical Latin letters**  
- **Max number of consecutive identical digits**

### Provide full JUnit test coverage:
- Each method must be tested with multiple edge cases  
- Use **AAA** and **FIRST** testing principles

---

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/epam/training/student_anastasiia_tsyvina/
│           └── StringAnalyzer.java
└── test/
    └── java/
        └── com/epam/training/student_anastasiia_tsyvina/
            └── StringAnalyzerTest.java
```

---

## Key Classes and Methods

### `StringAnalyzer.java`

```java
int maxUnequalConsecutiveChars(String input);
int maxConsecutiveIdenticalLetters(String input);
int maxConsecutiveIdenticalDigits(String input);
```

- Uses simple iteration to analyze input.  
- Null-safe and handles empty input.

### `StringAnalyzerTest.java`

- Uses **JUnit 5**  
- Tests follow **AAA** (Arrange-Act-Assert) format  
- Example:

```java
@Test
void maxConsecutiveIdenticalLetters_whenNoLetters_thenZero() {
    String input = "11223344";
    int result = analyzer.maxConsecutiveIdenticalLetters(input);
    assertEquals(0, result);
}
```

---

## Test Execution

```bash
mvn clean test
```

- Output includes test results for all 3 logic units.  
- Designed to run quickly and independently.

---

## Author

**Anastasiia Tsyvina**  
Automation Trainee @ EPAM  
Technologies: Java, JUnit, Selenium  
