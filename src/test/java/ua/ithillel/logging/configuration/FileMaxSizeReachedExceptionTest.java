package ua.ithillel.logging.configuration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileMaxSizeReachedExceptionTest {
    @Test
    public void testExceptionMessage() {
        String message = "Test exception message";
        FileMaxSizeReachedException exception = new FileMaxSizeReachedException(message);
        assertEquals(message, exception.getMessage());
    }
}
