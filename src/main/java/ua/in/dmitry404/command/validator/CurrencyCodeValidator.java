package ua.in.dmitry404.command.validator;

/**
 * This class provides an ability of currency code validation
 *
 * @author Dmitriy Butakov
 */
public class CurrencyCodeValidator implements Validator {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(String parameter) {
        String regex = "[A-Z]{3}";

        return parameter.matches(regex);
    }
}