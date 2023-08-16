package ua.ithillel.command;

import ua.ithillel.server.ClientHandler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

public class FileCommand implements Command {
    private final String serverDirectory;

    public FileCommand(String serverDirectory) {
        this.serverDirectory = serverDirectory;
    }

    @Override
    public void execute(String name, String args, ClientHandler clientHandler) {
        String[] parts = args.split(" ", 2);
        String filename = parts[0];
        String encodedContent = parts[1];

        byte[] fileContent = Base64.getDecoder().decode(encodedContent);

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(getServerFilePath(filename)))) {
            outputStream.write(fileContent);
            clientHandler.broadcastMessage("[SERVER]: File from " + name + " has been successfully received.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getServerFilePath(String filename) {
        return Paths.get(serverDirectory, filename).toString();
    }
}