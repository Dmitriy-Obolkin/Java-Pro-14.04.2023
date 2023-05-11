package src.main.homeworks.hw9.logging.file;

import src.main.homeworks.hw9.logging.LoggerConfiguration;
import src.main.homeworks.hw9.logging.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

/*3. Створити клас FileLoggerConfiguration. Клас представляє конфігурацію для логування.
Складається з властивостей:
    String filePath - файл, куди буде записуватися інформація,
    LoggingLevel loggingLevel - поточний рівень логування,
    long maxFileSize - максимальний розмір файлу (в байтах),
    String logFormat - формат для запису в файл.
*/
public class FileLoggerConfiguration extends LoggerConfiguration {
    private String filePath;
    private long maxFileSize;
    private int logsCount = 0;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel,
                                   long maxFileSize, String logFormat) {
        super(loggingLevel, logFormat);
        this.setFilePath(filePath);
        this.maxFileSize = maxFileSize;
    }

    public String getFilePath() {
        return filePath;
    }
    protected void setFilePath(String filePath) {
        this.filePath = generateLogFileName(filePath);
    }
    public long getMaxFileSize() {
        return maxFileSize;
    }
    protected void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
    public int getLogsCount() {
        return logsCount;
    }
    protected void setLogsCount(int logsCount) {
        this.logsCount = logsCount;
    }


    private String generateLogFileName(String basePath) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
        String timestamp = sdf.format(new Date());
        setLogsCount(getLogsCount()+1);
        return String.format("%s/Log_%s_%s_%s.txt", basePath, getLoggingLevel(), timestamp, getLogsCount());
    }

}
