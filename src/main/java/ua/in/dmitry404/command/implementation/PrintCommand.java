package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;

/**
 * This class is implementation of "Print" command
 *
 * @author Dmitriy Butakov
 */
public class PrintCommand extends Command {
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CashMachine cashMachine) throws CommandExecutorException {
        cashMachine.print();
    }
}
