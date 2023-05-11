package src.main.homeworks.hw9.logging;

import src.main.homeworks.hw9.logging.file.FileMaxSizeReachedException;

import java.io.IOException;

public interface Logger {
    void info(String message) throws FileMaxSizeReachedException, IOException;
    void debug(String message) throws FileMaxSizeReachedException, IOException;
}
