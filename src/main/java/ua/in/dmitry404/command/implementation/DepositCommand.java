package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;

/**
 * This class is implementation of "Deposit" command
 *
 * @author Dmitriy Butakov
 */
public class DepositCommand extends Command {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        return validateRequiredParametersQuantity()
            && validateCurrencyCode(parameters.get(0))
            && validateNotesValue(parameters.get(1))
            && validateNotesQuantity(parameters.get(2))
        ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CashMachine cashMachine) throws CommandExecutorException {

    }

    private boolean validateRequiredParametersQuantity() {
        return (getParameters().size() == 3);
    }

    private boolean validateCurrencyCode(String currencyCode) {
        String regex = "[A-Z]{3}";

        return currencyCode.matches(regex);
    }

    private boolean validateNotesValue(String notesValue) {
        return notesValue.equals("100");
    }

    private boolean validateNotesQuantity(String notesQuantity) {
        String regex = "[1-9][0-9]{0,}";

        return notesQuantity.matches(regex);
    }
}
