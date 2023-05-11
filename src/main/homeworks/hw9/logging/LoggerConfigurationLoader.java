package src.main.homeworks.hw9.logging;

import java.io.IOException;

public abstract class LoggerConfigurationLoader {
    public abstract LoggerConfiguration load(String configPath) throws IOException;

    protected abstract LoggingLevel getLoggingLevel();
    protected abstract void setLoggingLevel(LoggingLevel loggingLevel);
    protected abstract String getLogFormat();
    protected abstract void setLogFormat(String logFormat);
}
