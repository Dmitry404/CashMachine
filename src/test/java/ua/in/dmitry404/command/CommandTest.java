package ua.in.dmitry404.command;

import org.junit.Before;
import org.junit.Test;
import ua.in.dmitry404.CashMachine;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Dmitriy Butakov
 */
public class CommandTest {
    private class ImplementationOfCommand extends Command {
        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public void execute(CashMachine cashMachine) throws CommandExecutorException {
            // do nothing
        }
    }

    private ImplementationOfCommand command;

    @Before
    public void setUp() {
        command = new ImplementationOfCommand();
    }

    @Test
    public void testEmptyParameters() {
        assertEquals(command.getParameters().size(), 0);
    }

    @Test
    public void testNotEmptyParameters() {
        @SuppressWarnings("unchecked")
        List<String> listOfParameters = mock(List.class);
        int quantityOfParameters = 2;

        when(listOfParameters.size()).thenReturn(quantityOfParameters);

        command.setParameters(listOfParameters);

        assertEquals(command.getParameters().size(), quantityOfParameters);
    }
}