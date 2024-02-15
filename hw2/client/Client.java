package hw2.client;

import java.awt.Point;

import hw2.server.Server;
import hw2.util.ConnectionInfo;


public class Client {
    private final String DEFAUL_NICK = "Your NickName";

    private Server server;
    private ClientGUI clientGUI;
    private String nickName = "";
    
    public Client(Server server) {
        this.server = server;
        // this.clientGUI = new ClientGUI(this, DEFAUL_NICK);
        this.clientGUI = new ClientGUI(this, DEFAUL_NICK, new Point(100, 100));
    }
    
    public String getNickName() {
        return nickName;
    }

    public void tryLogin(ConnectionInfo connectionInfo){
        String nickName = connectionInfo.getNickName();

        // ТУДУ проверить все поля !
        if (nickName.length() > 0) {
            if (nickName.compareTo(DEFAUL_NICK) != 0) {
                this.nickName = nickName;
                if (server.isRunned()) {
                    server.addNewClient(this);
                    clientGUI.successConnection();
                } else {
                    clientGUI.showMessage("Ошибка! Сервер недоступен.\n");
                }
            } else {
                clientGUI.showMessage("Ошибка! Введите ваше имя.\n");
            }
        } else {
            clientGUI.showMessage("Ошибка! Введите ваше имя.\n");
        }
    }

    public void sendMessage(String messge){
        //String.format("%s: %s", sender.getNickName(), message);
        // String txt = messageField.getText().trim();
        if (messge.length() > 0) {
            String messageF = String.format("%s: %s", nickName, messge);
            server.inputMessageFromCient(messageF);
        }

    }

    public void inputMessage(String message){
        clientGUI.showMessage(message);
    }

    public void disconnectFromServer(){
        clientGUI.abortSession();
        nickName = "";
    }

    public void dicconnectFromClient(){
        // System.out.println("client.dicconnectFromClient()");
        server.disconnectClient(this);
    }
}
