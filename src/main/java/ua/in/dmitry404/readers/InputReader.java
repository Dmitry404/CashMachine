package ua.in.dmitry404.readers;

/**
 * @author Dmitriy Butakov
 */
public interface InputReader {
    /**
     * Read command from source
     *
     * @return current command
     */
    String readCommand();
}
