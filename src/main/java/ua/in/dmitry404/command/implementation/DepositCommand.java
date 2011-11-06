package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;
import ua.in.dmitry404.command.validator.CurrencyCodeValidator;
import ua.in.dmitry404.command.validator.NotesQuantityValidator;
import ua.in.dmitry404.command.validator.NotesValueValidator;
import ua.in.dmitry404.writers.WriterException;

/**
 * This class is implementation of "Deposit" command
 *
 * @author Dmitriy Butakov
 */
public class DepositCommand extends Command {
    /**
     * Construct command with parameter validators
     *
     * @param currencyCodeValidator currency code validator
     * @param notesValueValidator notes value validator
     * @param notesQuantityValidator notes quantity validator
     */
    public DepositCommand(CurrencyCodeValidator currencyCodeValidator,
                          NotesValueValidator notesValueValidator,
                          NotesQuantityValidator notesQuantityValidator ) {
        super(currencyCodeValidator, notesValueValidator, notesQuantityValidator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CashMachine cashMachine) throws CommandExecutorException {
        String currency = getParameters().get(0);
        int notesValue = Integer.parseInt(getParameters().get(1));
        int notesQuantity = Integer.parseInt(getParameters().get(2));

        try {
            cashMachine.deposit(currency, notesValue, notesQuantity);
        } catch (WriterException e) {
            throw new CommandExecutorException(e);
        }
    }
}
