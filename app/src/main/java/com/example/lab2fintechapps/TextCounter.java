package com.example.lab2fintechapps;

public class TextCounter {

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String trimmedText = text.trim();
        String[] words = trimmedText.split("\\s+");
        return words.length;
    }

    public int countPunctuationMarks(String text) {
        if (text == null) {
            return 0;
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
}