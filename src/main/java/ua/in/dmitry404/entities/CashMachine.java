package ua.in.dmitry404.entities;

import ua.in.dmitry404.readers.InputReader;

/**
 * This class contains implementation of ATM
 *
 * @author Dmitriy Butakov
 */
public class CashMachine {
    private InputReader inputReader;

    public CashMachine(InputReader inputReader) {
        this.inputReader = inputReader;
    }
}