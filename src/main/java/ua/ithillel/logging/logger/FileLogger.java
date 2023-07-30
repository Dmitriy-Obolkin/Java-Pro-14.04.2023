package ua.ithillel.logging.logger;

import ua.ithillel.logging.configuration.FileLoggerConfiguration;
import ua.ithillel.logging.configuration.FileMaxSizeReachedException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private final FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void debug(String message) throws FileMaxSizeReachedException, IOException {
        if (configuration.getLoggingLevel() == LoggingLevel.DEBUG) {
            log(configuration.getLoggingLevel().toString(), message);
        }
    }

    public void info(String message) throws FileMaxSizeReachedException, IOException {
        if(configuration.getLoggingLevel() == LoggingLevel.INFO || configuration.getLoggingLevel() == LoggingLevel.DEBUG){
            log(configuration.getLoggingLevel().toString(), message);
        }
    }


    private void log(String level, String message)
            throws FileMaxSizeReachedException, IOException {
        Path path = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        long fileSize = Files.exists(path) ? Files.size(path) : 0;

        try{
            if (fileSize >= configuration.getMaxFileSize()) {
                throw new FileMaxSizeReachedException(
                        String.format("The log file reached the maximum size: %d bytes. Current size: %d bytes. File path: %s.",
                                configuration.getMaxFileSize(), fileSize, configuration.getFilePath()));
            }
        } catch (FileMaxSizeReachedException e){
            createNewLogFile();
        }


        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format(configuration.getLogFormat(), currentTime, level, message);


        if (!Files.exists(path.getParent())) { Files.createDirectories(path.getParent()); }
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(logMessage);
            writer.newLine();
        }
    }
    public void createNewLogFile(){
        Path path = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        configuration.setFilePath(path.getParent().toString());
    }
}
