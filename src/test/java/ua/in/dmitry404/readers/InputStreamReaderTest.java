package ua.in.dmitry404.readers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * This class contains tests for InputStreamReader implementation
 *
 * @author Dmitriy Butakov
 */
public class InputStreamReaderTest {
    @Test
    public void testReadCommand() {
        String expectedString = "Command for testing";
        InputStream stream = new ByteArrayInputStream(expectedString.getBytes());
        
        InputReader inputReader = new InputStreamReader(stream);

        assertEquals(expectedString, inputReader.readCommand());
    }
}