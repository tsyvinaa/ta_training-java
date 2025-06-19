package com.epam.training.student_anastasiia_tsyvina;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAnalyzerTest {

    private final StringAnalyzer analyzer = new StringAnalyzer();

    @Test
    void maxUnequalConsecutiveChars_whenMixed_thenCorrect() {
        // Arrange
        String input = "abcaaadefgh";

        // Act
        int result = analyzer.maxUnequalConsecutiveChars(input);

        // Assert
        assertEquals(6, result); // defgh
    }

    @Test
    void maxConsecutiveIdenticalLetters_whenHasRepeated_thenCorrect() {
        // Arrange
        String input = "aaabbcccdeeef";

        // Act
        int result = analyzer.maxConsecutiveIdenticalLetters(input);

        // Assert
        assertEquals(3, result); // aaa or bbb or eee
    }

    @Test
    void maxConsecutiveIdenticalDigits_whenDigitsPresent_thenCorrect() {
        // Arrange
        String input = "112233333221";

        // Act
        int result = analyzer.maxConsecutiveIdenticalDigits(input);

        // Assert
        assertEquals(5, result); // 33333
    }

    @Test
    void maxConsecutiveIdenticalDigits_whenNoDigits_thenZero() {
        // Arrange
        String input = "abcdef";

        // Act
        int result = analyzer.maxConsecutiveIdenticalDigits(input);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void maxConsecutiveIdenticalLetters_whenNoLetters_thenZero() {
        // Arrange
        String input = "1233344455";

        // Act
        int result = analyzer.maxConsecutiveIdenticalLetters(input);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void maxUnequalConsecutiveChars_whenAllSame_thenOne() {
        // Arrange
        String input = "aaaaaa";

        // Act
        int result = analyzer.maxUnequalConsecutiveChars(input);

        // Assert
        assertEquals(1, result);
    }
}
