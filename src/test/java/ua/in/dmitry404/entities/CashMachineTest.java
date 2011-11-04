package ua.in.dmitry404.entities;

import org.junit.Before;
import org.junit.Test;
import ua.in.dmitry404.readers.InputStreamReader;
import ua.in.dmitry404.readers.Reader;

import static org.junit.Assert.*;

/**
 * This class contains test for CashMachine
 * 
 * @author Dmitriy Butakov
 */
public class CashMachineTest {

    private Reader reader;
    private CashMachine atm;

    @Before
    public void setUp() {
        reader = new InputStreamReader(System.in);
        atm = new CashMachine(reader);
    }

    @Test
    public void testCreationOfCacheMachine() {
        assertNotNull(atm);
    }
}
