package hw2.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import hw2.util.ConnectionInfo;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;

    private JTextArea chatArea;
    private JPanel topPanel;
    private JTextField ipAddressField, portField, nickNameField, messageField;
    private JPasswordField passwordField;
    private JButton loginButton, sendButton;
    private Client client;

    private String defaultNick;

    public ClientGUI(Client client, String defaultNick) {
        this.client = client;
        this.defaultNick = defaultNick;
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        setVisible(true);
    }

    public ClientGUI(Client clien, String defaultNick, Point location) {
        this(clien, defaultNick);
        setLocation(location);
    }

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
        nickNameField = new JTextField(defaultNick);
        topPanel.add(nickNameField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        passwordField = new JPasswordField("111111");
        topPanel.add(passwordField, constraints);

        constraints.weightx = 0;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> loginClick());
        topPanel.add(loginButton, constraints);

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
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        return scrollPane;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            client.dicconnectFromClient();
        }
    }

    @Override
    public void showMessage(String message) {
        chatArea.append(message);
        chatArea.append("\n");
    }

    @Override
    public void abortSession() {
        topPanel.setVisible(true);
        sendButton.setEnabled(false);
        getRootPane().setDefaultButton(loginButton);
        chatArea.append("\n>> Соединение разорвано!\n");
    }

    @Override
    public void successConnection(){
        topPanel.setVisible(false);
        sendButton.setEnabled(true);
        getRootPane().setDefaultButton(sendButton);
        messageField.requestFocus();
        chatArea.append("\n>> Соединение установлено!\n");
    }

    private void loginClick() {
        client.tryLogin(
                new ConnectionInfo(
                        ipAddressField.getText().trim(),
                        portField.getText().trim(),
                        nickNameField.getText().trim(),
                        passwordField.getPassword().toString()));
    }

    private void sendMessageClick() {
        client.sendMessage(messageField.getText().trim());
        messageField.setText("");
    }

}
