package ua.in.dmitry404.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides an ability of parse command string
 *
 * @author Dmitriy Butakov
 */
public class CommandParser {
    private List<String> parameters = new ArrayList<String>();

    public CommandParser(String command) throws InvalidCommandException{
        if (!command.trim().isEmpty()) {
            parameters = Arrays.asList(command.split(" "));
        } else {
            throw new InvalidCommandException("Empty command isn't acceptable");
        }
    }

    public String getName() {
        return parameters.get(0);
    }

    public List<String> getParameters() {
        return parameters.subList(1, parameters.size());
    }
}