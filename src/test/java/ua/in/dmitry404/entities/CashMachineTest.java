package ua.in.dmitry404.entities;

import org.junit.Before;
import org.junit.Test;
import ua.in.dmitry404.readers.InputReader;
import ua.in.dmitry404.readers.InputStreamReader;

import static org.junit.Assert.*;

/**
 * This class contains test for CashMachine
 * 
 * @author Dmitriy Butakov
 */
public class CashMachineTest {

    private InputReader inputReader;
    private CashMachine atm;

    @Before
    public void setUp() {
        inputReader = new InputStreamReader(System.in);
        atm = new CashMachine(inputReader);
    }

    @Test
    public void testCreationOfCacheMachine() {
        assertNotNull(atm);
    }
}
