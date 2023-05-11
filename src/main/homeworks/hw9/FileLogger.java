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
        if(configuration.getLoggingLevel() == LoggingLevel.INFO || configuration.getLoggingLevel() == LoggingLevel.DEBUG){
            log(configuration.getLoggingLevel().toString(), message);
        }
    }


    /*4. При виконанні методів debug та info врахувати максимально допустимий розмір файлу,
    куди будуть записуватися логи.
    */
    private void log(String level, String message)
            throws FileMaxSizeReachedException, IOException {
        Path path = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        long fileSize = Files.exists(path) ? Files.size(path) : 0;

        /* Тут должно быть какое-то одно из двух решений: создание файла или выброс FileMaxSizeReachedException,
          * но в задании были поставлены оба эти условия:
          *   4. При досягненні максимального розміру файлу або його перевищення, викинути виняток
          * FileMaxSizeReachedException з повідомленням максимального і поточного розміру файлу,
          * шляхи до файлу.
          *   6. ** При досягненні максимального розміру файлу або його перевищенні,
          * створювати новий (додатковий) файл для зберігання . Ім'я кожного нового файлу
          * має містити дату створення.
        */
        try{
            if (fileSize >= configuration.getMaxFileSize()) {
                throw new FileMaxSizeReachedException(
                        String.format("The log file reached the maximum size: %d bytes. Current size: %d bytes. File path: %s.",
                                configuration.getMaxFileSize(), fileSize, configuration.getFilePath()));
            }
        } catch (FileMaxSizeReachedException e){
            createNewLogFile();
        }


        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format(configuration.getLogFormat(), currentTime, level, message);


        /*Создать директорию для логов, если она не существует*/
        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                throw new IOException();
            }
        }

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

    /*6. ** При досягненні максимального розміру файлу або його перевищенні,
    створювати новий (додатковий) файл для зберігання . Ім'я кожного нового файлу
    має містити дату створення.*/
    public void createNewLogFile(){
        Path path = Paths.get(System.getProperty("user.dir")).resolve(configuration.getFilePath());
        configuration.setFilePath(path.getParent().toString());
    }

}
