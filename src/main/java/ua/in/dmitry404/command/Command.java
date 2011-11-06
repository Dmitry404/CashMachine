package ua.in.dmitry404.command;

import ua.in.dmitry404.CashMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Butakov
 */
public abstract class Command {
    protected List<String> parameters = new ArrayList<String>();

    /**
     * Get command validation result
     *
     * @return result of validation
     */
    public abstract boolean validate();

    /**
     * Execute command
     *
     * @param cashMachine instance of CashMachine
     * @throws CommandExecutorException exception-wrapper which could be caused instead of other checked exception
     */
    public abstract void execute(CashMachine cashMachine) throws CommandExecutorException;

    /**
     * Set list of parameters
     *
     * @param parameters command parameters
     */
    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    /**
     * Return list of parameters
     *
     * @return list of parameters
     */
    public List<String> getParameters() {
        return parameters;
    }
}