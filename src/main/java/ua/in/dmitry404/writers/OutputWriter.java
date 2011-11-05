package ua.in.dmitry404.writers;

/**
 * @author Dmitriy Butakov
 */
public interface OutputWriter {
    /**
     * Send success flag (string) to output destination
     *
     * @throws WriterException if some exception will be caused into method
     */
    void success() throws WriterException;

    /**
     * Send error flag (string) to output destination
     *
     * @throws WriterException if some exception will be caused into method
     */
    void error() throws WriterException;

    /**
     * Send information message to output destination
     *
     * @param message information message
     * @throws WriterException if some exception will be caused into method
     */
    void info(String message) throws WriterException;
}