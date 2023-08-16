package ua.ithillel.client;


import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Client {
    private final String serverHost;
    private final int serverPort;

    public Client(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void start() {
        try (Socket socket = new Socket(serverHost, serverPort);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to the server at " + serverHost + ":" + serverPort);
            startReadingServerMessages(serverReader);

            String userMessage;
            while ((userMessage = userReader.readLine()) != null) {
                processUserCommand(userMessage, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void startReadingServerMessages(BufferedReader serverReader) {
        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = serverReader.readLine()) != null) {
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void processUserCommand(String userMessage, PrintWriter writer) {
        if (userMessage.startsWith("-file")) {
            sendFile(userMessage.split(" ")[1], writer);
        } else if (userMessage.equalsIgnoreCase("-exit")) {
            System.out.println("Disconnecting from the server...");
        } else {
            writer.println(userMessage);
        }
    }


    void sendFile(String filePath, PrintWriter writer) {
        try {
            Path path = Path.of(filePath);
            if (!Files.exists(path)) {
                writer.println("Error: File " + filePath + " does not exist.");
                return;
            }
            byte[] fileContent = Files.readAllBytes(path);
            String encodedContent = Base64.getEncoder().encodeToString(fileContent);
            String filename = path.getFileName().toString();
            writer.println("-file " + filename + " " + encodedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
