package hw1.server;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import hw1.client.ClientWindow;


public class ServerWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 507;
    private static final String LOG_FILE_NAME = "chat.log";
    private boolean isRunned = false;
    JTextArea logArea;
    JButton btnStart, btnStop;
    ClientWindow[] clients = new ClientWindow[0];
    List<String> chatLog = new LinkedList<String>();

    public ServerWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Server");
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        
        btnStart = new JButton("Start");
        getRootPane().setDefaultButton(btnStart);
        btnStart.addActionListener(e -> startServer());

        
        btnStop = new JButton("Stop");
        btnStop.setEnabled(false);
        btnStop.addActionListener(e -> stopServer());

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(btnStart);
        bottomPanel.add(btnStop);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public boolean isRunned() {
        return isRunned;
    }
   
    private void startServer(){
        isRunned = true;
        logArea.append(">> Сервер запущен.\n");
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        // load log
        LogToFile logToFile = new LogToFile(LOG_FILE_NAME);
        chatLog = logToFile.load();
    }
    
    private void stopServer(){
        isRunned = false;
        logArea.append(">> Сервер остановлен.\n\n");
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        for (ClientWindow client : clients) {
            client.abortSession();
        }
        clients = new ClientWindow[0];
        // save log
        LogToFile logToFile = new LogToFile(LOG_FILE_NAME);
        logToFile.save(chatLog);
    }

    public void addNewClient(ClientWindow cleint){
        addClient(cleint);
        logArea.append(String.format("> %s connected\n", cleint.getNickName()));
        for (String msg : chatLog) {
            cleint.loadMessage(msg);
        }
    }

    public void inputMessage(ClientWindow sender, String message){
        String messageF = String.format("%s: %s", sender.getNickName(), message);
        logArea.append(messageF);
        logArea.append("\n");

        // add to log
        chatLog.add(messageF);

        // send to client
        for (ClientWindow client : clients) {
            client.loadMessage(messageF);
        }
    }

    public String loadChatHistory(){
        return "";
    }

    private void addClient(ClientWindow client){
        int currentSize = clients.length;
        int newSize = currentSize + 1;
        ClientWindow[] newClients = new ClientWindow[newSize];
        for(int i = 0; i<currentSize; i++){
            newClients[i] = clients[i];
        }
        newClients[currentSize] = client;
        clients = newClients;
    }

    private void removeClient(ClientWindow client){
        // if exixts
        int index = indexOfClient(client);
        if (index >= 0){
            int currentSize = clients.length;
            int newSize = currentSize - 1;
            ClientWindow[] newClients = new ClientWindow[newSize];
            for(int i = 0, j = 0; i<currentSize; i++, j++){
                if(i == index){
                    i++;
                }else{
                    newClients[j] = clients[i];
                }
            }
            clients = newClients;
        }
    }

    private int indexOfClient(ClientWindow client){
        for(int i = 0; i < clients.length; i++){
            if (client == clients[i]) return i;
        }
        return -1;
    }

}
