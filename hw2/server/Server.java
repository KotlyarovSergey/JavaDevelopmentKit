package hw2.server;

import java.util.List;
import java.util.LinkedList;

import hw2.client.Client;
import hw2.util.LogRepository;
import hw2.util.LogToFile;

public class Server {
    private static final String LOG_FILE_NAME = "chat.log";
    private boolean isRunned = false;
    private Client[] clients = new Client[0];
    private List<String> chatLog = new LinkedList<String>();
    private ServerView serverGUI;

    public Server() {
        serverGUI = new ServerGUI(this);
    }

    public boolean isRunned() {
        return isRunned;
    }

    public boolean tryToStartServer(){
        isRunned = true;
        LogRepository logToFile = new LogToFile(LOG_FILE_NAME);
        chatLog = logToFile.load();

        return true;
    }

    public boolean tryToStopServer(){
        isRunned = false;
        for (Client client : clients) {
            client.disconnectFromServer();
        }
        clients = new Client[0];
        // save log
        LogToFile logToFile = new LogToFile(LOG_FILE_NAME);
        logToFile.save(chatLog);

        return true;
    }

    public void addNewClient(Client cleint) {
        addClient(cleint);
        serverGUI.showMessage(String.format("> %s connected\n", cleint.getNickName()));
        for (String line : chatLog) {
            cleint.inputMessage(line);
        }
    }

    public void disconnectClient(Client client){
        if(indexOfClient(client) >= 0){
            removeClient(client);
            serverGUI.showMessage(String.format("> %s dicconnected\n", client.getNickName()));
        }
    }


    public void inputMessageFromCient(String message){
        serverGUI.showMessage(message);
        serverGUI.showMessage("\n");

        chatLog.add(message);

        for (Client client : clients) {
            client.inputMessage(message);
        }
    }


    private void addClient(Client client) {
        int currentSize = clients.length;
        int newSize = currentSize + 1;
        Client[] newClients = new Client[newSize];
        for (int i = 0; i < currentSize; i++) {
            newClients[i] = clients[i];
        }
        newClients[currentSize] = client;
        clients = newClients;
    }

    private void removeClient(Client client) {
        // if exixts
        int index = indexOfClient(client);
        if (index >= 0) {
            int currentSize = clients.length;
            int newSize = currentSize - 1;
            Client[] newClients = new Client[newSize];
            for (int i = 0, j = 0; i < currentSize; i++, j++) {
                if (i == index) {
                    i++;
                } else {
                    newClients[j] = clients[i];
                }
            }
            clients = newClients;
        }
    }

    private int indexOfClient(Client client) {
        for (int i = 0; i < clients.length; i++) {
            if (client == clients[i])
                return i;
        }
        return -1;
    }
}
