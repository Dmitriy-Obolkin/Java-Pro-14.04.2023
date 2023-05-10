package src.main.homeworks.hw9;

import java.text.SimpleDateFormat;
import java.util.Date;

/*3. Створити клас FileLoggerConfiguration. Клас представляє конфігурацію для логування.
Складається з властивостей:
    String filePath - файл, куди буде записуватися інформація,
    LoggingLevel loggingLevel - поточний рівень логування,
    long maxFileSize - максимальний розмір файлу (в байтах),
    String logFormat - формат для запису в файл.
*/
public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logFormat;


    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel,
                                   long maxFileSize, String logFormat) {
        this.loggingLevel = loggingLevel;
        this.setFilePath(filePath);
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }


    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = generateLogFileName(filePath);
    }
    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }
    public void setLoggingLevel(String loggingLevel){
        this.loggingLevel = LoggingLevel.valueOf(loggingLevel);
    }
    public long getMaxFileSize() {
        return maxFileSize;
    }
    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
    public String getLogFormat() {
        return logFormat;
    }
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }


    private String generateLogFileName(String basePath) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
        String timestamp = sdf.format(new Date());
        return String.format("%s/Log_%s_%s.txt", basePath, getLoggingLevel(), timestamp);
    }

}
