package ua.in.dmitry404.command;

/**
 * @author Dmitriy Butakov
 */
public class InvalidCommandException extends Exception {
    public InvalidCommandException(String msg) {
        super(msg);
    }
}
