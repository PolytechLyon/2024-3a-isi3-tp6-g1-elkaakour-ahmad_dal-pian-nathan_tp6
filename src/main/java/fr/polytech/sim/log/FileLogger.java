package fr.polytech.sim.log;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File logger.
 */
class FileLogger extends NamedLogger {
    private static final String FILE_NAME = "logs.txt";

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    public FileLogger(String name) {
        super(name);
    }

    /*
    @Override
    synchronized public void log(String format, Object... args) {
        String entry = String.format(format, args);
        String message = String.format("%s\t%s\n", this.name, entry);
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    protected void writeLog(String message) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
