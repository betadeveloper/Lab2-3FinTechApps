package com.example.lab2fintechapps.util;

import com.example.lab2fintechapps.exception.InvalidInputException;

public class TextCounter {

    public int countWords(String text) throws InvalidInputException {
        if (text == null) {
            throw new InvalidInputException("Input text cannot be null");
        }

        if (text.trim().isEmpty()) {
            return 0;
        }

        String trimmedText = text.trim();
        String[] words = trimmedText.split("\\s+");
        return words.length;
    }

    public int countPunctuationMarks(String text) throws InvalidInputException {
        if (text == null) {
            throw new InvalidInputException("Input text cannot be null");
        }

        int count = 0;
        for (char character : text.toCharArray()) {
            if (isPunctuationMark(character)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPunctuationMark(char character) {
        String punctuationMarks = ".,!?;:\"'()-[]{}…—–/\\";
        return punctuationMarks.indexOf(character) != -1;
    }

    public int countWordsWithLengthValidation(String text) throws InvalidInputException {
        if (text == null) {
            throw new InvalidInputException("Input text cannot be null");
        }

        if (text.length() > 10000) {
            throw new InvalidInputException("Text is too long. Maximum allowed length is 1000 characters");
        }

        if (text.trim().isEmpty()) {
            return 0;
        }

        String trimmedText = text.trim();
        String[] words = trimmedText.split("\\s+");
        return words.length;
    }
}