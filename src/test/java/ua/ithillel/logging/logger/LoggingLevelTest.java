package ua.ithillel.logging.logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoggingLevelTest {
    @Test
    public void infoExists() {
        assertNotNull(LoggingLevel.INFO);
    }

    @Test
    public void debugExists() {
        assertNotNull(LoggingLevel.DEBUG);
    }
}
