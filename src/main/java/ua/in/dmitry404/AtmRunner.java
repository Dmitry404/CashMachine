package ua.in.dmitry404;

import ua.in.dmitry404.readers.InputReader;
import ua.in.dmitry404.readers.InputStreamReader;
import ua.in.dmitry404.writers.OutputStreamWriter;
import ua.in.dmitry404.writers.OutputWriter;
import ua.in.dmitry404.writers.WriterException;

/**
 * @author Dmitriy Butakov
 */
public class AtmRunner {
    public static void main(String[] args) {
        InputReader inputReader = new InputStreamReader(System.in);
        OutputWriter outputWriter = new OutputStreamWriter(System.out);

        CashMachine atm = new CashMachine(inputReader, outputWriter);

        try {
            atm.run();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
