package ua.in.dmitry404;

import ua.in.dmitry404.readers.InputReader;
import ua.in.dmitry404.writers.OutputWriter;

/**
 * This class contains implementation of ATM
 *
 * @author Dmitriy Butakov
 */
public class CashMachine {
    private InputReader inputReader;
    private OutputWriter outputWriter;

    /**
     * Construct ATM
     *
     * @param inputReader specified input reader
     * @param outputWriter specified output writer
     */
    public CashMachine(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }
}