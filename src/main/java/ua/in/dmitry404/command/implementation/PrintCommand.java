package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;
import ua.in.dmitry404.writers.WriterException;

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
        try {
            cashMachine.print();
        } catch (WriterException e) {
            throw new CommandExecutorException(e);
        }
    }
}
