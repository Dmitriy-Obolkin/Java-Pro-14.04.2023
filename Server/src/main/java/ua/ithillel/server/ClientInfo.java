package ua.ithillel.server;

import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class ClientInfo {
    String name;
    LocalDateTime connectionTime;
    Socket clientSocket;
    PrintWriter writer;

    public ClientInfo(String name, LocalDateTime connectionTime, Socket clientSocket, PrintWriter writer) {
        this.name = name;
        this.connectionTime = connectionTime;
        this.clientSocket = clientSocket;
        this.writer = writer;
    }

    public PrintWriter getWriter() {
        return writer;
    }
}
