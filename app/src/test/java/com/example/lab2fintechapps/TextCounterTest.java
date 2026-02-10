package com.example.lab2fintechapps;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.example.lab2fintechapps.exception.InvalidInputException;
import com.example.lab2fintechapps.util.TextCounter;

public class TextCounterTest {

    private TextCounter textCounter;

    @Before
    public void setUp() {
        textCounter = new TextCounter();
    }

    // ==================== WORD COUNT TESTS ====================

    @Test
    public void testCountWords_WithNormalText() throws InvalidInputException {
        String text = "Hello world this is a test";
        int result = textCounter.countWords(text);
        assertEquals(6, result);
    }

    @Test
    public void testCountWords_WithSingleWord() throws InvalidInputException {
        String text = "Hello";
        int result = textCounter.countWords(text);
        assertEquals(1, result);
    }

    @Test
    public void testCountWords_WithEmptyString() throws InvalidInputException {
        String text = "";
        int result = textCounter.countWords(text);
        assertEquals(0, result);
    }

    @Test(expected = InvalidInputException.class)
    public void testCountWords_WithNullInput_ThrowsException() throws InvalidInputException {
        String text = null;
        textCounter.countWords(text);
    }

    @Test
    public void testCountWords_WithOnlySpaces() throws InvalidInputException {
        String text = "     ";
        int result = textCounter.countWords(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountWords_WithOnlyTabs() throws InvalidInputException {
        String text = "\t\t\t";
        int result = textCounter.countWords(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountWords_WithMixedWhitespace() throws InvalidInputException {
        String text = "  \t  \n  ";
        int result = textCounter.countWords(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountWords_WithMultipleSpacesBetweenWords() throws InvalidInputException {
        String text = "Hello    world    test";
        int result = textCounter.countWords(text);
        assertEquals(3, result);
    }

    @Test
    public void testCountWords_WithLeadingAndTrailingSpaces() throws InvalidInputException {
        String text = "   Hello world   ";
        int result = textCounter.countWords(text);
        assertEquals(2, result);
    }

    @Test
    public void testCountWords_WithNewlines() throws InvalidInputException {
        String text = "Hello\nworld\ntest";
        int result = textCounter.countWords(text);
        assertEquals(3, result);
    }

    @Test
    public void testCountWords_WithTabsBetweenWords() throws InvalidInputException {
        String text = "Hello\tworld\ttest";
        int result = textCounter.countWords(text);
        assertEquals(3, result);
    }

    @Test
    public void testCountWords_WithPunctuationInText() throws InvalidInputException {
        String text = "Hello, world! How are you?";
        int result = textCounter.countWords(text);
        assertEquals(5, result);
    }

    @Test
    public void testCountWords_WithNumbersAsWords() throws InvalidInputException {
        String text = "I have 3 apples and 5 oranges";
        int result = textCounter.countWords(text);
        assertEquals(7, result);
    }

    @Test
    public void testCountWords_WithSingleCharacterWords() throws InvalidInputException {
        String text = "I a m";
        int result = textCounter.countWords(text);
        assertEquals(3, result);
    }

    @Test
    public void testCountWords_WithLongText() throws InvalidInputException {
        String text = "This is a very long sentence with many words " +
                "to test if the counter works properly with larger texts";
        int result = textCounter.countWords(text);
        assertEquals(19, result);
    }

    // ==================== PUNCTUATION COUNT TESTS ====================

    @Test
    public void testCountPunctuationMarks_WithNormalText() throws InvalidInputException {
        String text = "Hello, world! How are you?";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(3, result);
    }

    @Test
    public void testCountPunctuationMarks_WithNoPunctuation() throws InvalidInputException {
        String text = "Hello world";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountPunctuationMarks_WithOnlyPunctuation() throws InvalidInputException {
        String text = ".,!?;:";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(6, result);
    }

    @Test
    public void testCountPunctuationMarks_WithEmptyString() throws InvalidInputException {
        String text = "";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(0, result);
    }

    @Test(expected = InvalidInputException.class)
    public void testCountPunctuationMarks_WithNullInput_ThrowsException() throws InvalidInputException {
        String text = null;
        textCounter.countPunctuationMarks(text);
    }

    @Test
    public void testCountPunctuationMarks_WithOnlySpaces() throws InvalidInputException {
        String text = "     ";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountPunctuationMarks_WithOnlyTabs() throws InvalidInputException {
        String text = "\t\t\t";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountPunctuationMarks_WithQuotes() throws InvalidInputException {
        String text = "\"Hello\" 'world'";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(4, result);
    }

    @Test
    public void testCountPunctuationMarks_WithParentheses() throws InvalidInputException {
        String text = "(Hello) [world] {test}";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(6, result);
    }

    @Test
    public void testCountPunctuationMarks_WithHyphensAndDashes() throws InvalidInputException {
        String text = "Hello-world test—example";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(2, result);
    }

    @Test
    public void testCountPunctuationMarks_WithMixedPunctuation() throws InvalidInputException {
        String text = "Hello! How are you? I'm fine, thanks.";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(5, result);
    }

    @Test
    public void testCountPunctuationMarks_WithEllipsis() throws InvalidInputException {
        String text = "Wait…";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(1, result);
    }

    @Test
    public void testCountPunctuationMarks_WithSlashes() throws InvalidInputException {
        String text = "and/or either\\or";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(2, result);
    }

    @Test
    public void testCountPunctuationMarks_WithColonAndSemicolon() throws InvalidInputException {
        String text = "Note: this; that";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(2, result);
    }

    @Test
    public void testCountPunctuationMarks_WithNumbersAndLetters() throws InvalidInputException {
        String text = "123 abc ABC";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountPunctuationMarks_WithSpecialCharacters() throws InvalidInputException {
        String text = "@#$%^&*";
        int result = textCounter.countPunctuationMarks(text);
        assertEquals(0, result);
    }

    @Test
    public void testCountWords_WithOnlyNumbers() throws InvalidInputException {
        String text = "123 456 789";
        int result = textCounter.countWords(text);
        assertEquals(3, result);
    }

    @Test
    public void testBothMethods_WithSameComplexText() throws InvalidInputException {
        String text = "Hello, world! This is a test.";
        int wordCount = textCounter.countWords(text);
        int punctuationCount = textCounter.countPunctuationMarks(text);

        assertEquals(6, wordCount);
        assertEquals(3, punctuationCount);
    }

    // ==================== EXCEPTION TESTS ====================

    @Test(expected = InvalidInputException.class)
    public void testCountWords_ThrowsExceptionForNullInput() throws InvalidInputException {
        textCounter.countWords(null);
    }

    @Test(expected = InvalidInputException.class)
    public void testCountPunctuationMarks_ThrowsExceptionForNullInput() throws InvalidInputException {
        textCounter.countPunctuationMarks(null);
    }

    @Test
    public void testCountWords_ExceptionMessageForNull() {
        try {
            textCounter.countWords(null);
            fail("Expected InvalidInputException to be thrown");
        } catch (InvalidInputException e) {
            assertEquals("Input text cannot be null", e.getMessage());
        }
    }

    @Test
    public void testCountPunctuationMarks_ExceptionMessageForNull() {
        try {
            textCounter.countPunctuationMarks(null);
            fail("Expected InvalidInputException to be thrown");
        } catch (InvalidInputException e) {
            assertEquals("Input text cannot be null", e.getMessage());
        }
    }

    @Test(expected = InvalidInputException.class)
    public void testCountWordsWithLengthValidation_ThrowsExceptionForTooLongText() throws InvalidInputException {
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            longText.append("a");
        }
        textCounter.countWordsWithLengthValidation(longText.toString());
    }

    @Test
    public void testCountWordsWithLengthValidation_ExceptionMessageForLongText() {
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            longText.append("a");
        }

        try {
            textCounter.countWordsWithLengthValidation(longText.toString());
            fail("Expected InvalidInputException to be thrown");
        } catch (InvalidInputException e) {
            assertEquals("Text is too long. Maximum allowed length is 1000 characters", e.getMessage());
        }
    }

    @Test
    public void testCountWordsWithLengthValidation_AcceptsMaximumLength() throws InvalidInputException {
        StringBuilder maxText = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            maxText.append("a");
        }
        int result = textCounter.countWordsWithLengthValidation(maxText.toString());
        assertEquals(1, result);
    }
}