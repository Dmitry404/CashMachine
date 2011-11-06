package ua.in.dmitry404.command.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains unit-tests for NotesValueValidator
 *
 * @author Dmitriy Butakov
 */
public class NotesValuesValidatorTest {
    private NotesValueValidator validator;

    @Before
    public void setUp() {
        validator = new NotesValueValidator();
    }

    @Test
    public void testSuccessfulValidation() {
        int[] powerValues = { 0, 1, 2, 3 };
        int[] multipliers = { 1, 5 };

        int base = 10;

        for (int multiplier : multipliers) {
            for (int power : powerValues) {
                int value = (int) (multiplier * Math.pow(base, power));
                
                assertTrue(validator.isValid(Integer.toString(value)));
            }
        }
    }

    @Test
    public void testFailedValidation() {
        String firstValue = "-1";
        String secondValue = "0";
        String thirdValue = "2";

        assertFalse(validator.isValid(firstValue));
        assertFalse(validator.isValid(secondValue));
        assertFalse(validator.isValid(thirdValue));
    }
}