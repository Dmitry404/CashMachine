package ua.in.dmitry404.command.validator;

/**
 * This class provides an ability of notes quantity validation
 *
 * @author Dmitriy Butakov
 */
public class NotesQuantityValidator implements Validator {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(String parameter) {
        String regex = "[1-9][0-9]*";

        return parameter.matches(regex);
    }
}