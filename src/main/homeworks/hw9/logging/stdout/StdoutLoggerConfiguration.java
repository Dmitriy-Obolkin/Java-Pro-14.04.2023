package src.main.homeworks.hw9.logging.stdout;

import src.main.homeworks.hw9.logging.LoggerConfiguration;
import src.main.homeworks.hw9.logging.LoggingLevel;

public class StdoutLoggerConfiguration extends LoggerConfiguration {
    public StdoutLoggerConfiguration(LoggingLevel loggingLevel, String logFormat) {
        super(loggingLevel, logFormat);
    }
}
