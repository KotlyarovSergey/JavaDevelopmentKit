package hw1.client;

import javax.swing.*;
import java.awt.*;
import hw1.server.ServerWindow;

public class ClientWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;
    private final String DEFAUL_NICK = "Your NickName";
    JTextArea chatArea;
    JPanel topPanel;
    JTextField ipAddressField;
    JTextField portField;
    JTextField nickNameField;
    JPasswordField passwordField;
    JButton loginButton;
    JTextField messageField;
    JButton sendButton;
    ServerWindow server;
    String nickName;

    public ClientWindow(ServerWindow server) {
        this.server = server;
        nickName = "";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Messenger");
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        topPanel = createTopPanel();
        JPanel bottomPanel = createBottomPanel();
        JComponent chatPanel = createChatArea();

        add(topPanel, BorderLayout.NORTH);
        add(chatPanel);
        add(bottomPanel, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(loginButton);
        // setLocation(100, 100);
        setVisible(true);
    }

    public ClientWindow(ServerWindow server, Point location) {
        this(server);
        setLocation(location);
    }
    // public void setLocation(int x, int y){
    //     setLocation(x, y);
    // }

    private JPanel createTopPanel() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel topPanel = new JPanel(gridBagLayout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        ipAddressField = new JTextField("127.0.0.1");
        topPanel.add(ipAddressField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        portField = new JTextField("8189");
        topPanel.add(portField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        nickNameField = new JTextField(DEFAUL_NICK);
        topPanel.add(nickNameField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        passwordField = new JPasswordField("111111");
        topPanel.add(passwordField, constraints);

        // constraints.weightx = 0;
        // constraints.gridx = 2;
        // constraints.gridy = 1;
        // topPanel.add(new JButton("Login"), constraints);

        constraints.weightx = 0;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> loginClick());
        topPanel.add(loginButton, constraints);

        // constraints.gridx = 2;
        // constraints.gridy = 0;
        // JButton hideButton = new JButton("asdg");
        // hideButton.setVisible(false);
        // topPanel.add(hideButton, constraints);

        topPanel.revalidate();

        return topPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1.0f;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        messageField = new JTextField();
        // messageField.setFont(new Font("Verdana", Font.PLAIN, 18));
        // messageField.setSize(0, 22);
        bottomPanel.add(messageField, constraints);

        constraints.weightx = 0;
        constraints.gridx = 1;
        sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        sendButton.addActionListener(e -> sendMessageClick());
        bottomPanel.add(sendButton);

        return bottomPanel;
    }

    private JComponent createChatArea() {
        // JPanel chatPanel = new JPanel();
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        // chatPanel.add(scrollPane);
        // return chatPanel;
        return scrollPane;
    }

    private void loginClick() {
        String txt = nickNameField.getText().trim();
        if (txt.length() > 0) {
            if (txt.compareTo(DEFAUL_NICK) != 0) {
                if(server.isRunned()){
                    nickName = txt;
                    chatArea.setText(server.loadChatHistory());
                    server.addNewClient(this);
                    topPanel.setVisible(false);
                    sendButton.setEnabled(true);
                    getRootPane().setDefaultButton(sendButton);
                    messageField.requestFocus();
                }else{
                    chatArea.append("Ошибка! Сервер недоступен.\n");
                }
            }else{
                chatArea.append("Ошибка! Введите ваше имя.\n");
            }
        } else{
            chatArea.append("Ошибка! Введите ваше имя.\n");
        }
    }

    private void sendMessageClick() {
        String txt = messageField.getText().trim();
        if (txt.length() > 0) {
            server.inputMessage(this, txt);
            messageField.setText("");
        }
    }

    public void loadMessage(String message){
        chatArea.append(message);
        chatArea.append("\n");
    }

    public void abortSession() {
        topPanel.setVisible(true);
        sendButton.setEnabled(false);
        nickName = "";
        getRootPane().setDefaultButton(loginButton);
    }

    public String getNickName() {
        return nickName;
    }

}
