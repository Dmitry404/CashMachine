package ua.in.dmitry404.command.implementation;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class contains unit-test for DepositCommand implementation
 *
 * @author Dmitriy Butakov
 */
public class DepositCommandTest {
    private DepositCommand command;
    List<String> parameters;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        command = new DepositCommand();
        parameters = mock(List.class);
    }

    @Test
    public void testValidateWithoutParameters() {
        assertFalse(command.validate());
    }

    @Test
    public void testValidateWithWrongRequiredParametersQuantity() {
        int requiredParametersQuantity = 3;

        when(parameters.size()).thenReturn(requiredParametersQuantity - 1);
        command.setParameters(parameters);
        
        assertFalse(command.validate());

        when(parameters.size()).thenReturn(requiredParametersQuantity + 1);
        command.setParameters(parameters);

        assertFalse(command.validate());
    }

    @Test
    public void testValidateWithValidParameters() {
        int requiredParametersQuantity = 3;

        String validCurrency = "USD";
        String validNotesValue = "100";
        String validNotesQuantity = "10";

        when(parameters.get(0)).thenReturn(validCurrency);
        when(parameters.get(1)).thenReturn(validNotesValue);
        when(parameters.get(2)).thenReturn(validNotesQuantity);

        when(parameters.size()).thenReturn(requiredParametersQuantity);

        command.setParameters(parameters);

        assertTrue(command.validate());
    }
}
