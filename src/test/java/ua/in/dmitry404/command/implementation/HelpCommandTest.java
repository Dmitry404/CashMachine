package ua.in.dmitry404.command.implementation;

import org.junit.Before;
import org.junit.Test;
import ua.in.dmitry404.CashMachine;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This class contains test for HelpCommand
 *
 * @author Dmitriy Butakov
 */
public class HelpCommandTest {
    private HelpCommand command;

    @Before
    public void setUp() {
        command = new HelpCommand();
    }

    @Test
    public void testValidate() {
        assertTrue(command.validate());
    }

    @Test
    public void testExecute() throws Exception {
        CashMachine atm = mock(CashMachine.class);

        command.execute(atm);

        verify(atm).help();
    }
}
