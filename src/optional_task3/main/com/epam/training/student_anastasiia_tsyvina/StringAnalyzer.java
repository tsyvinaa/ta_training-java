package com.epam.training.student_anastasiia_tsyvina;

public class StringAnalyzer {

    public int maxUnequalConsecutiveChars(String input) {
        if (input == null || input.isEmpty()) return 0;
        int max = 1, count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    public int maxConsecutiveIdenticalLetters(String input) {
        if (input == null || input.isEmpty()) return 0;
        int max = 0, count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            char previous = input.charAt(i - 1);
            if (Character.isLetter(current) && current == previous) {
                count++;
            } else {
                count = 1;
            }
            if (Character.isLetter(current)) {
                max = Math.max(max, count);
            }
        }

        return max;
    }

    public int maxConsecutiveIdenticalDigits(String input) {
        if (input == null || input.isEmpty()) return 0;
        int max = 0, count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            char previous = input.charAt(i - 1);
            if (Character.isDigit(current) && current == previous) {
                count++;
            } else {
                count = 1;
            }
            if (Character.isDigit(current)) {
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
