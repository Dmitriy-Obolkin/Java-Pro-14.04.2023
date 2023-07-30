package ua.ithillel.logging.configuration;

public class FileMaxSizeReachedException extends Exception{
    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
