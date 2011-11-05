package ua.in.dmitry404.command;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains unit-tests for CommandParser class
 *
 * @author Dmitriy Butakov
 */
public class CommandParserTest {
    @Test
    public void testGetCommandName() throws InvalidCommandException {
        String commandName = "commandName";

        CommandParser command = new CommandParser(commandName);

        assertEquals(command.getName(), commandName);
    }

    @Test(expected = InvalidCommandException.class)
    public void testWrongCommandString() throws InvalidCommandException {
        String commandName = " ";

        CommandParser command = new CommandParser(commandName);
    }

    @Test
    public void testGetParameters() throws InvalidCommandException {
        String commandName = "commandName";
        String firstParameter = "do";
        String secondParameter = "nothing";

        String fullCommand = commandName + " " + firstParameter + " " + secondParameter;
        CommandParser command = new CommandParser(fullCommand);

        assertEquals(command.getParameters().get(0), firstParameter);
        assertEquals(command.getParameters().get(1), secondParameter);
    }

    @Test
    public void testGetEmptyParameters() throws InvalidCommandException {
        String commandName = "commandName";

        CommandParser command = new CommandParser(commandName);

        assertEquals(command.getParameters().size(), 0);
    }
}