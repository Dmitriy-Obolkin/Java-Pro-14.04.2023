package ua.ithillel.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Server implements AutoCloseable {
    private final Map<String, ClientInfo> activeConnections = Collections.synchronizedMap(new HashMap<>());
    private final ServerSocket serverSocket;
    public static int connectionCounter = 0;

    private Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public boolean isClosed() {
        return serverSocket.isClosed();
    }

    public static Server create(int port){
        try{
            return new Server(port);
        } catch (IOException e) {
            System.err.println("Error when creating a server socket: " + e.getMessage());
            return null;
        }
    }

    public void start() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort());
        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket, activeConnections).start();
        }
    }


    @Override
    public void close() throws IOException {
        serverSocket.close();
    }
}