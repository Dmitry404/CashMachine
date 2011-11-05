package ua.in.dmitry404.command;

import ua.in.dmitry404.CashMachine;

import java.util.List;

/**
 * @author Dmitriy Butakov
 */
public interface Command {
    /**
     * Get command validation result
     *
     * @return result of validation
     */
    boolean validate();

    /**
     * Execute command
     *
     * @param cashMachine instance of CashMachine
     */
    void execute(CashMachine cashMachine);

    /**
     * Set list of parameters
     *
     * @param parameters command parameters
     */
    void setParameters(List<String> parameters);
}
