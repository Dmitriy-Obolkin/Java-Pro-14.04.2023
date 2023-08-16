package ua.ithillel;

import ua.ithillel.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (Server server = Server.create(8080)) {
            if(server == null){
                System.exit(1);
            }
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}