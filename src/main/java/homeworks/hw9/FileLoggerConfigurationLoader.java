package homeworks.hw9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLoggerConfigurationLoader {

    private String file;
    private LoggingLevel loggingLevel;
    private Long maxFileSize;
    private String logFormat;

    /*5. * Створити клас FileLoggerConfigurationLoader. Об'єкт даного типу за допомогою
    методу load, завантажуватиме конфігурацію для логування із зазначеного файлу.
    Метод повертає об'єкт типу FileLoggerConfiguration.
    Зміст файлу:
        FILE: ТУТ_ШЛЯХ_До_ФАЙЛУ
        LEVEL: ТУТ_РІВЕНЬ
        MAX-SIZE: ТУТ_РАЗМІР
        FORMAT: ТУТ_ФОРМАТ
    */
    public FileLoggerConfiguration load(String configFilePath) throws IOException {
        Path configPath = Paths.get(configFilePath);
        if (!Files.exists(configPath)) {
            throw new IOException("Configuration file not found");
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(configPath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                switch (keyValue[0]) {
                    case "FILE" -> setFile(keyValue[1]);
                    case "LEVEL" -> setLoggingLevel(LoggingLevel.valueOf(keyValue[1]));
                    case "MAX-SIZE" -> setMaxFileSize(Long.parseLong(keyValue[1]));
                    case "FORMAT" -> setLogFormat(keyValue[1]);
                }
            }
        }

        return new FileLoggerConfiguration(getFile(), getLoggingLevel(), getMaxFileSize(), getLogFormat());
    }


    public String getFile() {
        return file;
    }
    private void setFile(String file) {
        this.file = file;
    }
    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
    private void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }
    public Long getMaxFileSize() {
        return maxFileSize;
    }
    private void setMaxFileSize(Long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
    public String getLogFormat() {
        return logFormat;
    }
    private void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }


}
