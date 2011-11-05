package ua.in.dmitry404.writers;

/**
 * This exception is wrapper for exceptions which could be caused in OutputWriter implementation
 *
 * @author Dmitriy Butakov
 */
public class WriterException extends Exception {
    public WriterException(Throwable e) {
        super(e);
    }
}