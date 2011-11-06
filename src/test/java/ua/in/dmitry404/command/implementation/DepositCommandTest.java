package ua.in.dmitry404.command.implementation;

import org.junit.Test;
import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.validator.CurrencyCodeValidator;
import ua.in.dmitry404.command.validator.NotesQuantityValidator;
import ua.in.dmitry404.command.validator.NotesValueValidator;

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

        CashMachine atm = mock(CashMachine.class);

        DepositCommand command = new DepositCommand(currencyCodeValidator, notesValueValidator, notesQuantityValidator);
        command.execute(atm);

        verify(atm).deposit();
    }
}
