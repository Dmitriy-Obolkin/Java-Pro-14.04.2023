package src.main.homeworks.hw9;

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
