package ua.in.dmitry404.command.implementation;

import org.junit.Test;
import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.validator.CurrencyCodeValidator;
import ua.in.dmitry404.command.validator.NotesQuantityValidator;
import ua.in.dmitry404.command.validator.NotesValueValidator;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * This class contains unit-test for DepositCommand implementation
 *
 * @author Dmitriy Butakov
 */
public class DepositCommandTest {
    @Test
    public void testExecute() throws Exception {
        CurrencyCodeValidator currencyCodeValidator = mock(CurrencyCodeValidator.class);
        NotesValueValidator notesValueValidator = mock(NotesValueValidator.class);
        NotesQuantityValidator notesQuantityValidator = mock(NotesQuantityValidator.class);

        String currencyCode = "USD";
        String notesValue = "100";
        String notesQuantity = "10";

        @SuppressWarnings("unchecked")
        List<String> parameters = mock(List.class);
        when(parameters.get(0)).thenReturn(currencyCode);
        when(parameters.get(1)).thenReturn(notesValue);
        when(parameters.get(2)).thenReturn(notesQuantity);

        CashMachine atm = mock(CashMachine.class);

        DepositCommand command = new DepositCommand(currencyCodeValidator, notesValueValidator, notesQuantityValidator);
        command.setParameters(parameters);
        command.execute(atm);

        verify(atm).deposit(eq(currencyCode), eq(Integer.parseInt(notesValue)), eq(Integer.parseInt(notesQuantity)));
    }
}