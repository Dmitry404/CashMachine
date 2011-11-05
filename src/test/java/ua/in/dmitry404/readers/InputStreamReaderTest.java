package ua.in.dmitry404.readers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class contains tests for InputStreamReader implementation
 *
 * @author Dmitriy Butakov
 */
public class InputStreamReaderTest {
    @Test
    public void testSimpleReaderCreation() {
        Reader reader = new InputStreamReader(System.in);

        assertNotNull(reader);
    }

    @Test
    public void testReadCommand() {
        String expectedString = "Command for testing";
        InputStream stream = new ByteArrayInputStream(expectedString.getBytes());
        
        Reader reader = new InputStreamReader(stream);

        assertEquals(expectedString, reader.readCommand());
    }
}