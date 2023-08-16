package ua.ithillel;

import ua.ithillel.client.Client;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("localhost", 8080);
        client.start();
    }
}