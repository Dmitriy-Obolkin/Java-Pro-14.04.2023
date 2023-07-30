package ua.ithillel.logging.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.logging.logger.LoggingLevel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileLoggerConfigurationTest {
    private FileLoggerConfiguration configuration;
    private String filePath = "/path/to/file";
    private LoggingLevel loggingLevel = LoggingLevel.INFO;
    private long maxFileSize = 1000L;
    private String logFormat = "[%s] %s - %s";
    private int logsCount = 1;

    @BeforeEach
    public void setup() {
        configuration = new FileLoggerConfiguration(filePath, loggingLevel, maxFileSize, logFormat);
    }

    @Test
    public void constructorAndGettersTest() {
        String pattern = filePath + "/Log_INFO_(\\d{2}-\\d{2}-\\d{4}_\\d{2}\\.\\d{2}\\.\\d{2})_\\d+\\.txt";

        assertTrue(configuration.getFilePath().matches(pattern), "Log file name does not match the expected pattern.");
        assertEquals(loggingLevel, configuration.getLoggingLevel());
        assertEquals(maxFileSize, configuration.getMaxFileSize());
        assertEquals(logFormat, configuration.getLogFormat());
        assertEquals(logsCount, configuration.getLogsCount());
    }

    @Test
    public void setLoggingLevelTest() {
        configuration.setLoggingLevel(LoggingLevel.DEBUG);
        assertEquals(LoggingLevel.DEBUG, configuration.getLoggingLevel());

        configuration.setLoggingLevel("INFO");
        assertEquals(LoggingLevel.INFO, configuration.getLoggingLevel());
    }

    @Test
    public void setMaxFileSizeTest() {
        long newMaxFileSize = 500L;
        configuration.setMaxFileSize(newMaxFileSize);
        assertEquals(newMaxFileSize, configuration.getMaxFileSize());
    }

    @Test
    public void setLogFormatTest() {
        String newLogFormat = "[%s] %s . %s";
        configuration.setLogFormat(newLogFormat);
        assertEquals(newLogFormat, configuration.getLogFormat());
    }

}
