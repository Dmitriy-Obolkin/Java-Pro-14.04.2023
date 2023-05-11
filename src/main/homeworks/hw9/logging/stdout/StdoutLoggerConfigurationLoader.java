package src.main.homeworks.hw9.logging.stdout;

import src.main.homeworks.hw9.logging.LoggerConfiguration;
import src.main.homeworks.hw9.logging.LoggerConfigurationLoader;
import src.main.homeworks.hw9.logging.LoggingLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StdoutLoggerConfigurationLoader extends LoggerConfigurationLoader {
    private LoggingLevel loggingLevel;
    private String logFormat;
    @Override
    public LoggerConfiguration load(String configPath) throws IOException {
        Path configFilePath = Paths.get(configPath);
        if (!Files.exists(configFilePath)) {
            throw new IOException("Configuration file not found");
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(configFilePath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                switch (keyValue[0]) {
                    case "LEVEL" -> setLoggingLevel(LoggingLevel.valueOf(keyValue[1]));
                    case "FORMAT" -> setLogFormat(keyValue[1]);
                }
            }
        }

        return new StdoutLoggerConfiguration(getLoggingLevel(), getLogFormat());
    }

    @Override
    protected LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    @Override
    protected void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    @Override
    protected String getLogFormat() {
        return logFormat;
    }

    @Override
    protected void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

}
