package ua.in.dmitry404.readers;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class that provides an ability of read commands from InputStream implementation
 * 
 * @author Dmitriy Butakov
 */
public class InputStreamReader implements Reader {
    private InputStream currentStream;

    /**
     * Construct object with custom stream (for better testability)
     *
     * @param stream current currentStream
     */
    public InputStreamReader(InputStream stream) {
        this.currentStream = stream;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String readCommand() {
        Scanner in = new Scanner(currentStream);

        return in.nextLine();
    }
}
