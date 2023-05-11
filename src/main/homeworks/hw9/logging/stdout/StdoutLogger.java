package src.main.homeworks.hw9.logging.stdout;

import src.main.homeworks.hw9.logging.Logger;
import src.main.homeworks.hw9.logging.LoggingLevel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StdoutLogger implements Logger {
    private final StdoutLoggerConfiguration configuration;

    public StdoutLogger(StdoutLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void info(String message) {
        if (configuration.getLoggingLevel() == LoggingLevel.INFO || configuration.getLoggingLevel() == LoggingLevel.DEBUG) {
            log(message);
        }
    }

    @Override
    public void debug(String message) {
        if (configuration.getLoggingLevel() == LoggingLevel.DEBUG) {
            log(message);
        }
    }

    private void log(String message){
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format(configuration.getLogFormat(), currentTime, configuration.getLoggingLevel(), message);
        System.out.println(logMessage);
    }
}
