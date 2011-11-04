package ua.in.dmitry404.entities;

import ua.in.dmitry404.readers.Reader;

/**
 * This class contains implementation of ATM
 *
 * @author Dmitriy Butakov
 */
public class CashMachine {
    private Reader reader;

    public CashMachine(Reader reader) {
        this.reader = reader;
    }
}