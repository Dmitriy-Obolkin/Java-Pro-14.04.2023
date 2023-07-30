package ua.ithillel.logging.configuration;
import ua.ithillel.logging.logger.LoggingLevel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileLoggerConfigurationLoaderTest {
    private FileLoggerConfigurationLoader loader;
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logFormat;

    @BeforeEach
    public void setup(){
        loader = new FileLoggerConfigurationLoader();
        filePath = "src/test/resources/hw9/logs";
        loggingLevel = LoggingLevel.DEBUG;
        maxFileSize = 1000L;
        logFormat = "[%s] %s - %s";
    }
    @Test
    public void loadTest_success(@TempDir Path tempDir) throws IOException{
        Path configFile = tempDir.resolve("config.txt");
        String config = "FILE: " + filePath + "\n" +
                "LEVEL: " + loggingLevel + "\n" +
                "MAX-SIZE: " + maxFileSize + "\n" +
                "FORMAT: " + logFormat;
        Files.write(configFile, config.getBytes());

        FileLoggerConfiguration configuration = loader.load(configFile.toString());

        String pattern = filePath + "/Log_DEBUG_(\\d{2}-\\d{2}-\\d{4}_\\d{2}\\.\\d{2}\\.\\d{2})_\\d+\\.txt";

        assertTrue(configuration.getFilePath().matches(pattern), "Log file name does not match the expected pattern.");
        assertEquals(loggingLevel, configuration.getLoggingLevel());
        assertEquals(maxFileSize, configuration.getMaxFileSize());
        assertEquals(logFormat, configuration.getLogFormat());
    }

    @Test
    public void loadTest_FileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> loader.load("nonexistent.txt"));
    }
}
