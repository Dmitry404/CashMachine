package ua.in.dmitry404;

import ua.in.dmitry404.command.Command;
import ua.in.dmitry404.command.CommandExecutorException;
import ua.in.dmitry404.command.CommandParser;
import ua.in.dmitry404.command.InvalidCommandException;
import ua.in.dmitry404.command.implementation.*;
import ua.in.dmitry404.command.validator.CurrencyCodeValidator;
import ua.in.dmitry404.command.validator.NotesQuantityValidator;
import ua.in.dmitry404.command.validator.NotesValueValidator;
import ua.in.dmitry404.money.MoneyBox;
import ua.in.dmitry404.money.NotesHolder;
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

    MoneyBox moneys = new MoneyBox();

    /**
     * Construct ATM
     *
     * @param inputReader specified input reader
     * @param outputWriter specified output writer
     * @throws WriterException if caused some checked exception in OutputWriter
     */
    public CashMachine(InputReader inputReader, OutputWriter outputWriter) throws WriterException {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;

        initializeCommands();
        printHelloMessage();
    }

    private void printHelloMessage() throws WriterException {
        outputWriter.info("Hello! (put H for help)\n");
    }

    /**
     * Setup ATM commands
     */
    private void initializeCommands() {
        CurrencyCodeValidator currencyCodeValidator = new CurrencyCodeValidator();
        NotesValueValidator notesValueValidator = new NotesValueValidator();
        NotesQuantityValidator notesQuantityValidator = new NotesQuantityValidator();

        commandHolder.put("Q", new QuitCommand());
        commandHolder.put("+", new DepositCommand(
            currencyCodeValidator, notesValueValidator, notesQuantityValidator
        ));
        commandHolder.put("-", new WithdrawCommand(
            currencyCodeValidator, notesQuantityValidator
        ));
        commandHolder.put("?", new PrintCommand());
        commandHolder.put("H", new HelpCommand());
    }

    /**
     * Run ATM
     *
     * @throws WriterException if any checked exception will be thrown in implementation of OutputWriter
     * @throws CommandExecutorException if any checked exception will be thrown in implementation of Command
     */
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

    /**
     * Shutdown ATM
     *
     * @throws WriterException if any checked exception will be thrown in implementation of OutputWriter
     */
    public void shutdown() throws WriterException {
        outputWriter.info("Bye!");

        System.exit(0);
    }

    /**
     * Try to deposit values with specified currency code, value of notes and notes quantity
     *
     * @param currency currency code
     * @param notesValue value of notes
     * @param notesQuantity notes quantity
     * @throws WriterException if any checked exception will be thrown in implementation of OutputWriter
     */
    public void deposit(String currency, int notesValue, int notesQuantity) throws WriterException {
        moneys.deposit(currency, notesValue, notesQuantity);
        outputWriter.success();
    }

    /**
     * Try to withdraw values with specified currency code and amount that will be withdrawn
     *
     * @param currency currency code
     * @param amount amount that will be withdrawn
     * @throws WriterException if any checked exception will be thrown in implementation of OutputWriter
     */
    public void withdraw(String currency, int amount) throws WriterException {
        NotesHolder notesHolder = moneys.withdraw(currency, amount);
        if (notesHolder != null) {
            for (int notesValue : notesHolder.getValues()) {
                String outputString = "";
                outputString += Integer.toString(notesValue) + " ";
                outputString += Integer.toString(notesHolder.getQuantity(notesValue)) + "\n";

                outputWriter.info(outputString);
            }
            outputWriter.success();
        } else {
            outputWriter.error();
        }
    }

    /**
     * Print current ATM state
     *
     * @throws WriterException if any checked exception will be thrown in implementation of OutputWriter
     */
    public void print() throws WriterException {
        for (String currencyCode : moneys.getValues()) {
            NotesHolder notesHolder = moneys.getNotesHolder(currencyCode);

            for (int notesValue : notesHolder.getValues()) {
                String outputString = currencyCode + " ";
                outputString += Integer.toString(notesValue) + " ";
                outputString += Integer.toString(notesHolder.getQuantity(notesValue)) + "\n";

                outputWriter.info(outputString);
            }
        }

        outputWriter.success();
    }

    public void help() throws WriterException {
        outputWriter.info("\n");
        
        for (String command : commandHolder.keySet()) {
            outputWriter.info(command + " - ");
            outputWriter.info(commandHolder.get(command).getDescription() + "\n");
        }
        outputWriter.success();
    }
}