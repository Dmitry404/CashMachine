package ua.in.dmitry404.command.implementation;

import org.junit.Before;
import org.junit.Test;
import ua.in.dmitry404.CashMachine;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This class contains unit-test for QuitCommand implementation
 *
 * @author Dmitriy Butakov
 */
public class QuitCommandTest {
    private QuitCommand command;

    @Before
    public void setUp() throws Exception {
        command = new QuitCommand();
    }

    @Test
    public void testValidate() {
        assertTrue(command.validate());
    }

    @Test
    public void testExecute() throws Exception {
        CashMachine atm = mock(CashMachine.class);

        command.execute(atm);

        verify(atm).shutdown();
    }
}
