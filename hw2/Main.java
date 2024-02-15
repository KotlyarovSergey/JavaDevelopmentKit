package hw2;

import hw2.client.Client;
import hw2.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        new Client(server);
        new Client(server);
    }
}
