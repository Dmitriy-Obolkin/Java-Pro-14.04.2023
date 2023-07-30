package ua.ithillel.logging.logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.logging.configuration.FileLoggerConfiguration;
import ua.ithillel.logging.configuration.FileLoggerConfigurationLoader;
import ua.ithillel.logging.configuration.FileMaxSizeReachedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileLoggerTest {

    private static FileLoggerConfiguration configuration;
    private FileLogger fileLogger;

    @BeforeEach
    public void setup(){
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();

        try {
            configuration = loader.load("src/test/resources/hw9/logConfigs/FileConfig.txt");
            fileLogger = new FileLogger(configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void infoLogTest() throws IOException, FileMaxSizeReachedException {
        String message = "Info test message";
        fileLogger.info(message);
        Path expectedPath = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        String content = Files.readString(expectedPath);
        assertTrue(content.contains(message));
    }

    @Test
    public void debugLogTest() throws IOException, FileMaxSizeReachedException {
        String message = "Debug test message";
        fileLogger.debug(message);
        Path expectedPath = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        String content = Files.readString(expectedPath);
        assertTrue(!content.contains(message));

        configuration.setLoggingLevel(LoggingLevel.DEBUG);
        fileLogger.debug(message);
        content = Files.readString(expectedPath);
        assertTrue(content.contains(message));
    }

    @Test
    public void logMaxSizeTest() throws IOException, FileMaxSizeReachedException {
        configuration.setMaxFileSize(10L);
        String longMessage = "This message is definitely longer than 10 bytes";


        Path expectedPath = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        fileLogger.info(longMessage);

        String content = Files.readString(expectedPath);
        assertTrue(content.contains(longMessage));

        expectedPath = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        String newMessage = "New message";
        fileLogger.info(newMessage);
        content = Files.readString(expectedPath);
        assertTrue(content.contains(newMessage));
    }


    @Test
    public void logDirectoryNotExistTest() throws IOException, FileMaxSizeReachedException {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration configuration;
        FileLogger fileLogger;

        try {
            configuration = loader.load("src/test/resources/hw9/logConfigs/FileConfig2.txt");
            fileLogger = new FileLogger(configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String message = "Info test message";
        fileLogger.info(message);
        Path expectedPath = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        String content = Files.readString(expectedPath);
        assertTrue(content.contains(message));

        Path directory = expectedPath.getParent();

        if (Files.exists(directory)) {
            Files.walk(directory)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }


    @AfterAll
    public static void cleanup() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        Path pathToLogs = path.getParent();

        if(Files.exists(pathToLogs)) {
            Files.newDirectoryStream(pathToLogs).forEach(file -> {
                try {
                    Files.delete(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
