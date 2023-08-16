package ua.ithillel.server;

import ua.ithillel.command.Command;
import ua.ithillel.command.ExitCommand;
import ua.ithillel.command.FileCommand;
import ua.ithillel.command.MessageCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler extends Thread {
    private final Socket socket;
    private final Map<String, ClientInfo> activeConnections;
    private String name;
    private boolean running = true;
    private Map<String, Command> commands;

    public ClientHandler(Socket socket, Map<String, ClientInfo> activeConnections) {
        this.socket = socket;
        this.activeConnections = activeConnections;
        this.commands = new HashMap<>();
        this.commands.put("-m", new MessageCommand());
        this.commands.put("-exit", new ExitCommand());
        this.commands.put("-file", new FileCommand( System.getProperty("user.dir")));
    }


    public Map<String, ClientInfo> getActiveConnections() {
        return activeConnections;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
        ) {
            synchronized (Server.class) {
                this.name = "client-" + (++Server.connectionCounter);
            }
            LocalDateTime connectionTime = LocalDateTime.now();
            activeConnections.put(name, new ClientInfo(name, connectionTime, socket, writer));

            broadcastMessage("[SERVER]: " + name + " successfully connected.");
            String clientMessage;
            while (isRunning() && (clientMessage = reader.readLine()) != null) {
                String commandKey = clientMessage.split(" ")[0].toLowerCase();
                String args = clientMessage.substring(commandKey.length()).trim();
                Command command = commands.get(commandKey);
                if (command != null) {
                    command.execute(name, args, this);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMessage(String message) {
        activeConnections.values().forEach(clientInfo -> clientInfo.getWriter().println(message));
    }
}