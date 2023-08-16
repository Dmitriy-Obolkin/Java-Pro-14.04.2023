package ua.ithillel.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class ClientTest {

    private Client client;
    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    public void setUp() {
        client = new Client("localhost", 8080);
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
    }


    @Test
    public void processUserCommandTest_ExitCommand_ShouldPrintMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        client.processUserCommand("-exit", printWriter);

        System.setOut(originalOut);

        assertEquals("Disconnecting from the server...", outContent.toString().trim());
    }

    @Test
    public void processUserCommandTest_OtherCommand_ShouldSendToWriter() {
        String otherCommand = "Hello, World!";
        client.processUserCommand(otherCommand, printWriter);
        printWriter.flush();

        assertEquals(otherCommand, stringWriter.toString().trim());
    }

    @Test
    public void processUserCommandTest_FileCommand_ShouldCallSendFile() {
        Client spyClient = spy(client);
        doNothing().when(spyClient).sendFile(anyString(), any());

        String fileCommand = "-file C:/test/test.txt";
        spyClient.processUserCommand(fileCommand, printWriter);

        verify(spyClient).sendFile("C:/test/test.txt", printWriter);
    }

    @Test
    public void startReadingServerMessagesTest_ShouldPrintMessages() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        BufferedReader mockReader = mock(BufferedReader.class);
        when(mockReader.readLine()).thenReturn("Message 1", "Message 2", null);

        client.startReadingServerMessages(mockReader);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.setOut(originalOut);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Message 1"));
        assertTrue(output.contains("Message 2"));
    }

    @Test
    public void sendFileTest_FileDoesNotExist_ShouldPrintErrorMessage() {
        String filePath = "nonExistentFile.txt";

        client.sendFile(filePath, printWriter);

        String output = stringWriter.toString();
        assertTrue(output.contains("Error: File " + filePath + " does not exist."));
    }

    @Test
    public void sendFileTest_FileExists_ShouldSendEncodedContent() throws IOException {
        String fileContent = "This is a test file content";
        Path tempFilePath = Files.createTempFile("testFile", ".txt");
        Files.write(tempFilePath, fileContent.getBytes());

        client.sendFile(tempFilePath.toString(), printWriter);

        String expectedEncodedContent = Base64.getEncoder().encodeToString(fileContent.getBytes());
        String expectedOutput = "-file " + tempFilePath.getFileName().toString() + " " + expectedEncodedContent;
        String actualOutput = stringWriter.toString().trim();
        assertEquals(expectedOutput, actualOutput);

        Files.deleteIfExists(tempFilePath);
    }

}
