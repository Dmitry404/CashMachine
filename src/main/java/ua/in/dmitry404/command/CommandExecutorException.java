package ua.in.dmitry404.command;

/**
 * This exception is wrapper for exceptions which could be caused in Command implementation of 'execute' method
 *
 * @author Dmitriy Butakov
 */
public class CommandExecutorException extends Exception {
    public CommandExecutorException(Throwable e) {
        super(e);
    }
}
