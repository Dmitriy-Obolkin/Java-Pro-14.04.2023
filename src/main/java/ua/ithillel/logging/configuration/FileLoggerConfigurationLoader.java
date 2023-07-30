package ua.ithillel.logging.configuration;

import ua.ithillel.logging.logger.LoggingLevel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(String configFilePath) throws FileNotFoundException, IOException {
        String file = null;
        LoggingLevel loggingLevel = null;
        Long maxFileSize = null;
        String logFormat = null;

        Path configPath = Paths.get(configFilePath);
        if (!Files.exists(configPath)) {
            throw new FileNotFoundException("Configuration file not found");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(configPath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                switch (keyValue[0]) {
                    case "FILE" -> file = keyValue[1];
                    case "LEVEL" -> loggingLevel = LoggingLevel.valueOf(keyValue[1]);
                    case "MAX-SIZE" -> maxFileSize = Long.parseLong(keyValue[1]);
                    case "FORMAT" -> logFormat = keyValue[1];
                }
            }
        }

        return new FileLoggerConfiguration(file, loggingLevel, maxFileSize, logFormat);
    }

}
