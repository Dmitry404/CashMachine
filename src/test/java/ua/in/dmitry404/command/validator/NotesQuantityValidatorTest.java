package ua.in.dmitry404.command.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  This class contains unit-tests for NotesQuantityValidator
 *
 * @author Dmitriy Butakov
 */
public class NotesQuantityValidatorTest {
    private NotesQuantityValidator validator;

    @Before
    public void setUp() {
        validator = new NotesQuantityValidator();
    }

    @Test
    public void testSuccessfulValidation() {
        String firstValue = "1";
        String secondValue = "1000";

        assertTrue(validator.isValid(firstValue));
        assertTrue(validator.isValid(secondValue));
    }

    @Test
    public void testFailedValidation() {
        String firstValue = "-1";
        String secondValue = "0";
        String thirdValue = "string";

        assertFalse(validator.isValid(firstValue));
        assertFalse(validator.isValid(secondValue));
        assertFalse(validator.isValid(thirdValue));
    }
}
