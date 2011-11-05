package ua.in.dmitry404;

import org.junit.Before;
import org.junit.Test;
import ua.in.dmitry404.readers.InputReader;
import ua.in.dmitry404.readers.InputStreamReader;
import ua.in.dmitry404.writers.OutputStreamWriter;
import ua.in.dmitry404.writers.OutputWriter;

import static org.junit.Assert.assertNotNull;

/**
 * This class contains unit-test for CashMachine class
 * 
 * @author Dmitriy Butakov
 */
public class CashMachineTest {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CashMachine atm;

    @Before
    public void setUp() {
        inputReader = new InputStreamReader(System.in);
        outputWriter = new OutputStreamWriter(System.out);

        atm = new CashMachine(inputReader, outputWriter);
    }

    @Test
    public void testCreationOfCacheMachine() {
        assertNotNull(atm);
    }
}
