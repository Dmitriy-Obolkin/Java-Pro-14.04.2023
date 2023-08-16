package ua.ithillel.command;

import static org.mockito.Mockito.*;

import ua.ithillel.server.ClientHandler;
import org.junit.jupiter.api.Test;

public class MessageCommandTest {

    @Test
    public void testExecute() {
        String name = "John";
        String message = "Hello, World!";
        String args = message;
        ClientHandler clientHandler = mock(ClientHandler.class);
        MessageCommand command = new MessageCommand();

        command.execute(name, args, clientHandler);

        verify(clientHandler, times(1)).broadcastMessage(name + ": " + message);
    }
}
