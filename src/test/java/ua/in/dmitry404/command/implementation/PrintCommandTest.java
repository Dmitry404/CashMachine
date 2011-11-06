package ua.in.dmitry404.command.implementation;

import org.junit.Test;
import ua.in.dmitry404.CashMachine;

import static org.mockito.Mockito.*;

/**
 *  This class contains unit-test for PrintCommand implementation
 *
 * @author Dmitriy Butakov
 */
public class PrintCommandTest {
    @Test
    public void testExecutionOfCommand() throws Exception {
        PrintCommand command = new PrintCommand();

        CashMachine atm = mock(CashMachine.class);

        command.execute(atm);

        verify(atm).print();
    }
}
