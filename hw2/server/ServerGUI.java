package hw2.server;

import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame implements ServerView {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 507;
    private JTextArea logArea;
    private JButton btnStart, btnStop;
    private Server server;

    public ServerGUI(Server server){
        this.server = server;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Server");
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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


    @Override
    public void showMessage(String message) {
        logArea.append(message);
    }

    private void startServer() {
        if(server.tryToStartServer()){
            logArea.append(">> Сервер запущен.\n");
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);

        }
    }
    
    private void stopServer() {
        if(server.tryToStopServer()){
            logArea.append(">> Сервер остановлен.\n\n");
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
        }
    }
    
}
