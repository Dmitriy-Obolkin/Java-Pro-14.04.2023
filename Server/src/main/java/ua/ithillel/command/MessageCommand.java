package ua.ithillel.command;

import ua.ithillel.server.ClientHandler;

public class MessageCommand implements Command{
    @Override
    public void execute(String name, String args, ClientHandler clientHandler) {
        clientHandler.broadcastMessage(name + ": " + args);
    }
}
