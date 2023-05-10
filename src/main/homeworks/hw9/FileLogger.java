package src.main.homeworks.hw9;
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


    /*3.Створити методи debug та info, які як параметр приймають рядок-повідомлення.
    Метод повинен виконувати запис у вказаний у конфігурації файл у встановленому
    форматі для запису з конфігурації.
    Формат запису: [ПОТОЧНИЙ_ЧАС][DEBUG] Повідомлення: [СТРОКА-ПОВІДОМЛЕННЯ]

    2.Якщо активовано рівень DEBUG, то його також включається INFO, але не навпаки.
    */
    public void debug(String message) throws FileMaxSizeReachedException, IOException {
        if (configuration.getLoggingLevel() == LoggingLevel.DEBUG) {
            log(configuration.getLoggingLevel().toString(), message);
        }
    }
    public void info(String message) throws FileMaxSizeReachedException, IOException {
        log(configuration.getLoggingLevel().toString(), message);
    }


    /*4. При виконанні методів debug та info врахувати максимально допустимий розмір файлу,
    куди будуть записуватися логи.
    При досягненні максимального розміру файлу або його перевищення, викинути виняток
    FileMaxSizeReachedException з повідомленням максимального і поточного розміру файлу,
    шляхи до файлу.
    */
    private void log(String level, String message)
            throws FileMaxSizeReachedException, IOException {

        Path projectRoot = Paths.get(System.getProperty("user.dir"));
        Path path = projectRoot.resolve(configuration.getFilePath());
        long fileSize = Files.exists(path) ? Files.size(path) : 0;

        if (fileSize >= configuration.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(
                    String.format("The log file reached the maximum size: %d bytes. Current size: %d bytes. File path: %s.",
                            configuration.getMaxFileSize(), fileSize, configuration.getFilePath()));

        }

        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format(configuration.getLogFormat(), currentTime, level, message);

        /*BufferedWriter - декоратор для Writer, повышает производительность за счёт
        * добавления беферизации.
        * Files.newBufferedWriter - адаптер, удобный способ создания BufferedWriter.
        * Стандартные опции файловых операций:
        *   CREATE - создать файл, если он не существует;
        *   APPEND - дописать инфу в файл, если существует.
        * Try-with-resources обеспечивает автоматическое закрытие BufferedWriter,
        * автоматически вызывает метод close() у классов, которые имплементируют
        * интерфейсы Closeable и AutoCloseable.
        * */
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(logMessage);
            writer.newLine();
        }
    }

}
