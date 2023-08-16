package ua.ithillel.server;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ServerTest {

    @Test
    public void createServerTest_success() throws IOException {
        Server server = Server.create(8080);
        assertNotNull(server);
        server.close();
    }

    @Test
    public void createServerTest_error() throws IOException {
        Server server1 = Server.create(8080);
        assertNotNull(server1);
        Server server2 = Server.create(8080);
        assertNull(server2);
        server1.close();
    }

    @Test
    public void closeServerTest() throws IOException {
        Server server = Server.create(8080);
        assertNotNull(server);
        server.close();
        assertTrue(server.isClosed());
    }
}
