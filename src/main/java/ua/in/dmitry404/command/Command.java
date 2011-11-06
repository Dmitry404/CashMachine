package ua.in.dmitry404.command;

import ua.in.dmitry404.CashMachine;

import java.util.List;

/**
 * @author Dmitriy Butakov
 */
public abstract class Command {
    private List<String> parameters;

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
}
