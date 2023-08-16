package ua.ithillel.command;

import ua.ithillel.server.ClientHandler;

public class ExitCommand implements Command{
    @Override
    public void execute(String name, String args, ClientHandler clientHandler) {
        clientHandler.getActiveConnections().remove(name);
        clientHandler.broadcastMessage("[SERVER]: " + name + " disconnected.");
        clientHandler.setRunning(false);
    }
}
