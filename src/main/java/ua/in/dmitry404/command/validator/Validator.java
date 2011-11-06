package ua.in.dmitry404.command.validator;

/**
 * @author Dmitriy Butakov
 */
public interface Validator {
    /**
     * Return validation result
     *
     * @param parameter string that needs to be validated
     * @return validation result
     */
    boolean isValid(String parameter);
}
