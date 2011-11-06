package ua.in.dmitry404.command;

import org.junit.Test;
import ua.in.dmitry404.CashMachine;
import ua.in.dmitry404.command.validator.Validator;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Dmitriy Butakov
 */
public class CommandTest {
    private class ImplementationOfCommand extends Command {
        public ImplementationOfCommand(Validator...validators) {
            super(validators);
        }

        @Override
        public void execute(CashMachine cashMachine) throws CommandExecutorException {
            // do nothing
        }
    }

    @Test
    public void testValidatingCommandWithEmptyParameters() {
        ImplementationOfCommand command = new ImplementationOfCommand();

        assertTrue(command.validate());
    }

    @Test
    public void testValidatingCommandWithWrongParametersQuantity() {
        ImplementationOfCommand command = new ImplementationOfCommand();

        @SuppressWarnings("unchecked")
        List<String> listOfParameters = mock(List.class);

        when(listOfParameters.size()).thenReturn(1);

        command.setParameters(listOfParameters);

        assertFalse(command.validate());
    }

    @Test
    public void testSuccessValidationCommandWithValidators() {
        @SuppressWarnings("unchecked")
        List<String> listOfParameters = mock(List.class);
        when(listOfParameters.size()).thenReturn(1);
        when(listOfParameters.get(0)).thenReturn("");

        Validator validator = mock(Validator.class);
        when(validator.isValid("")).thenReturn(true);

        Validator[] validators = { validator };

        ImplementationOfCommand command = new ImplementationOfCommand(validators);
        command.setParameters(listOfParameters);

        assertTrue(command.validate());
    }

    @Test
    public void testFailedValidationCommandWithValidators() {
        @SuppressWarnings("unchecked")
        List<String> listOfParameters = mock(List.class);
        when(listOfParameters.size()).thenReturn(1);
        when(listOfParameters.get(0)).thenReturn("");

        Validator validator = mock(Validator.class);
        when(validator.isValid("")).thenReturn(false);

        Validator[] validators = { validator };

        ImplementationOfCommand command = new ImplementationOfCommand(validators);
        command.setParameters(listOfParameters);

        assertFalse(command.validate());
    }
}