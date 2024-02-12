package hw1;

import java.awt.Point;

import hw1.client.ClientWindow;
import hw1.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        new ClientWindow(server, new Point(100, 100));
        new ClientWindow(server, new Point(1000, 100));
    }
}
