package ua.in.dmitry404.command.implementation;

import org.junit.Test;
import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.validator.CurrencyCodeValidator;
import ua.in.dmitry404.command.validator.NotesQuantityValidator;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * This class contains unit-test for WithdrawCommand implementation
 *
 * @author Dmitriy Butakov
 */
public class WithdrawCommandTest {
    @Test
    public void testExecute() throws Exception {
        CurrencyCodeValidator currencyCodeValidator = mock(CurrencyCodeValidator.class);
        NotesQuantityValidator notesQuantityValidator = mock(NotesQuantityValidator.class);

        String currencyCode = "USD";
        String notesQuantity = "10";

        @SuppressWarnings("unchecked")
        List<String> parameters = mock(List.class);
        when(parameters.get(0)).thenReturn(currencyCode);
        when(parameters.get(1)).thenReturn(notesQuantity);

        CashMachine atm = mock(CashMachine.class);

        WithdrawCommand command = new WithdrawCommand(currencyCodeValidator, notesQuantityValidator);
        command.setParameters(parameters);
        command.execute(atm);

        verify(atm).withdraw(eq(currencyCode), eq(Integer.parseInt(notesQuantity)));
    }
}