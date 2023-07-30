package ua.ithillel.logging.configuration;

import ua.ithillel.logging.logger.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logFormat;
    private int logsCount = 0;

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
    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
    public long getMaxFileSize() {
        return maxFileSize;
    }
    public String getLogFormat() {
        return logFormat;
    }
    public int getLogsCount() {
        return logsCount;
    }

    public void setFilePath(String filePath) {
        this.filePath = generateLogFileName(filePath);
    }
    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }
    protected void setLoggingLevel(String loggingLevel){
        this.loggingLevel = LoggingLevel.valueOf(loggingLevel);
    }
    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
    protected void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
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
