package ua.in.dmitry404.readers;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class that provides an ability of read commands from InputStream implementation
 * 
 * @author Dmitriy Butakov
 */
public class InputStreamReader implements InputReader {
    private InputStream currentStream;

    /**
     * Construct object with specified InputStream implementation
     *
     * @param stream specified InputStream implementation
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
