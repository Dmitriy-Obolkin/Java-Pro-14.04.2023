package ua.ithillel.command;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import ua.ithillel.server.ClientHandler;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class FileCommandTest {

    private final String serverDirectory = "testServerDirectory";
    private final String testFilename = "testFile.txt";
    private final String testContent = "This is a test content";
    private final String encodedContent = Base64.getEncoder().encodeToString(testContent.getBytes());

    @BeforeEach
    public void setup() {
        new File(serverDirectory).mkdir();
    }

    @Test
    public void executeTest() throws Exception {
        String args = testFilename + " " + encodedContent;
        ClientHandler clientHandler = mock(ClientHandler.class);
        FileCommand command = new FileCommand(serverDirectory);

        command.execute("", args, clientHandler);

        File file = new File(Paths.get(serverDirectory, testFilename).toString());
        assertTrue(file.exists(), "File should exist");
        assertEquals(testContent, new String(Files.readAllBytes(file.toPath())), "File content should match");
        verify(clientHandler, times(1)).broadcastMessage("[SERVER]: File from  has been successfully received.");
    }

    @AfterEach
    public void cleanup() {
        new File(Paths.get(serverDirectory, testFilename).toString()).delete();
        new File(serverDirectory).delete();
    }
}