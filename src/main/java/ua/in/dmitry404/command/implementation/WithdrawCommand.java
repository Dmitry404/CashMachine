package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;
import ua.in.dmitry404.command.validator.CurrencyCodeValidator;
import ua.in.dmitry404.command.validator.NotesQuantityValidator;

/**
 * This class is implementation of "Withdraw" command
 *
 * @author Dmitriy Butakov
 */
public class WithdrawCommand extends Command {
    /**
     * Construct command with parameter validators
     *
     * @param currencyCodeValidator currency code validator
     * @param notesQuantityValidator notes quantity validator
     */
    public WithdrawCommand(CurrencyCodeValidator currencyCodeValidator,
                           NotesQuantityValidator notesQuantityValidator) {
        super(currencyCodeValidator, notesQuantityValidator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CashMachine cashMachine) throws CommandExecutorException {
        String currency = getParameters().get(0);
        int notesQuantity = Integer.parseInt(getParameters().get(1));

        cashMachine.withdraw(currency, notesQuantity);
    }
}
