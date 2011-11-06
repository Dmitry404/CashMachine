package ua.in.dmitry404.command.validator;

/**
 * This class provides an ability of notes value validation
 *
 * @author Dmitriy Butakov
 */
public class NotesValueValidator implements Validator {
    public static final String[] allowedValues = {
        "1", "5", "10", "50", "100", "500", "1000", "5000"
    };
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(String parameter) {
        for (String allowedValue : allowedValues) {
            if (parameter.equals(allowedValue)) {
                return true;
            }
        }

        return false;
    }
}