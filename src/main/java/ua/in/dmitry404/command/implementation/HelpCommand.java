package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;
import ua.in.dmitry404.writers.WriterException;

/**
 * This class is implementation of "Help" command
 * 
 * @author Dmitriy Butakov
 */
public class HelpCommand extends Command {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(CashMachine cashMachine) throws CommandExecutorException {
        try {
            cashMachine.help();
        } catch (WriterException e) {
            throw new CommandExecutorException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Display this help";
    }
}
