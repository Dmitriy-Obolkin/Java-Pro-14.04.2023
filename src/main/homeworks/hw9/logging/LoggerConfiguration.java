package src.main.homeworks.hw9.logging;

public abstract class LoggerConfiguration {
    private LoggingLevel loggingLevel;
    private String logFormat;

    public LoggerConfiguration(LoggingLevel loggingLevel, String logFormat) {
        this.loggingLevel = loggingLevel;
        this.logFormat = logFormat;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
    protected void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }
    protected void setLoggingLevel(String loggingLevel){
        this.loggingLevel = LoggingLevel.valueOf(loggingLevel);
    }
    public String getLogFormat() {
        return logFormat;
    }
    protected void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

}
