package ua.ithillel.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import ua.ithillel.server.ClientHandler;
import ua.ithillel.server.ClientInfo;

import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ExitCommandTest {

    @Test
    public void executeTest() {
        String name = "John";
        Map<String, ClientInfo> activeConnections = new HashMap<>();
        ClientInfo clientInfo = new ClientInfo(name, LocalDateTime.now(), mock(Socket.class), mock(PrintWriter.class));
        activeConnections.put(name, clientInfo);
        ClientHandler clientHandler = mock(ClientHandler.class);
        when(clientHandler.getActiveConnections()).thenReturn(activeConnections);
        ExitCommand command = new ExitCommand();

        command.execute(name, "", clientHandler);

        assertTrue(activeConnections.isEmpty(), "Active connections should be empty");
        verify(clientHandler, times(1)).broadcastMessage("[SERVER]: " + name + " disconnected.");
        verify(clientHandler, times(1)).setRunning(false);
    }
}