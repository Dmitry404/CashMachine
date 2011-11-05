package ua.in.dmitry404.command.implementation;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.Command;

import java.util.List;

/**
 * This class is implementation of "Quit" command
 * 
 * @author Dmitriy Butakov
 */
public class QuitCommand implements Command {
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
    public void execute(CashMachine cashMachine) {
        cashMachine.shutdown();
    }

    /**
    * {@inheritDoc}
     */
    @Override
    public void setParameters(List<String> parameters) {
        // do nothing for this command
    }
}
