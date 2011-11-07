package ua.in.dmitry404.command;

import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitriy Butakov
 */
public abstract class Command {
    private List<Validator> validators;
    private List<String> parameters = new ArrayList<String>();

    public Command(Validator...validators) {
        this.validators = new ArrayList<Validator>(Arrays.asList(validators));
    }

    /**
     * Execute command
     *
     * @param cashMachine instance of CashMachine
     * @throws CommandExecutorException exception-wrapper which could be caused instead of other checked exception
     */
    public abstract void execute(CashMachine cashMachine) throws CommandExecutorException;

    /**
     * Return command arguments validation result
     *
     * @return result of validation
     */
    public boolean validate() {
        if (validateParametersQuantity()) {
            for (int i = 0; i < validators.size(); i++) {
                if (!validators.get(i).isValid(parameters.get(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

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

    /**
     * Is valid parameters count (calculated by validators count)
     *
     * @return true is parameters count is equals to validators count
     */
    protected boolean validateParametersQuantity() {
        return (parameters.size() == validators.size());
    }

    /**
     * Return description of command (default is empty
     *
     * @return description of command
     */
    public String getDescription() {
        return "";
    }
}