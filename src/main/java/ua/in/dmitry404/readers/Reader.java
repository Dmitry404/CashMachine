package ua.in.dmitry404.readers;

/**
 * @author Dmitriy Butakov
 */
public interface Reader {
    /**
     * Read command from current stream
     * 
     * @return current command
     */
    public String readCommand();
}
