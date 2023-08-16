package ua.ithillel.command;

import ua.ithillel.server.ClientHandler;

public interface Command {
    void execute(String name, String args, ClientHandler clientHandler);
}
