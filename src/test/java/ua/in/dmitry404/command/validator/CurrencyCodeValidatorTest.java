package ua.in.dmitry404.command.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains unit-tests for CurrencyCodeValidator
 *
 * @author Dmitriy Butakov
 */
public class CurrencyCodeValidatorTest {
    private CurrencyCodeValidator validator;

    @Before
    public void setUp() {
        validator = new CurrencyCodeValidator();
    }

    @Test
    public void testSuccessfulValidation() {
        String firstCurrencyCode = "USD";
        String secondCurrencyCode = "UAH";

        assertTrue(validator.isValid(firstCurrencyCode));
        assertTrue(validator.isValid(secondCurrencyCode));
    }

    @Test
    public void testFailedValidation() {
        String firstCurrencyCode = "US";
        String secondCurrencyCode = "UA2H";
        String thirdCurrencyCode = "usd";

        assertFalse(validator.isValid(firstCurrencyCode));
        assertFalse(validator.isValid(secondCurrencyCode));
        assertFalse(validator.isValid(thirdCurrencyCode));
    }
}