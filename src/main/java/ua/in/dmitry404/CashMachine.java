package ua.in.dmitry404;

import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;
import ua.in.dmitry404.command.CommandParser;
import ua.in.dmitry404.command.InvalidCommandException;
import ua.in.dmitry404.command.implementation.DepositCommand;
import ua.in.dmitry404.command.implementation.QuitCommand;
import ua.in.dmitry404.readers.InputReader;
import ua.in.dmitry404.writers.OutputWriter;
import ua.in.dmitry404.writers.WriterException;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains implementation of ATM
 *
 * @author Dmitriy Butakov
 */
public class CashMachine {
    private InputReader inputReader;
    private OutputWriter outputWriter;

    Map<String, Command> commandHolder = new HashMap<String, Command>();

    /**
     * Construct ATM
     *
     * @param inputReader specified input reader
     * @param outputWriter specified output writer
     */
    public CashMachine(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;

        commandHolder.put("Q", new QuitCommand());
        commandHolder.put("+", new DepositCommand());
    }

    public void run() throws WriterException, CommandExecutorException {
        while (true) {
            try {
                CommandParser commandParser = new CommandParser(inputReader.readCommand());
                if (commandHolder.containsKey(commandParser.getName())) {
                    Command command = commandHolder.get(commandParser.getName());
                    command.setParameters(commandParser.getParameters());
                    if (command.validate()) {
                        command.execute(this);
                    } else {
                        outputWriter.error();
                    }
                } else {
                    outputWriter.error();
                }
            } catch (InvalidCommandException e){
                outputWriter.error();
            }

        }
    }

    public void shutdown() throws WriterException {
        outputWriter.info("Bye!");

        System.exit(0);
    }
}