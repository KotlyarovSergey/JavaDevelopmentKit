package hw2.util;

public class ConnectionInfo {
    private String ipAddress;
    private String port;
    private String nickName;
    private String password;
    public String getIpAddress() {
        return ipAddress;
    }
    public String getPort() {
        return port;
    }
    public String getNickName() {
        return nickName;
    }
    public String getPassword() {
        return password;
    }
    public ConnectionInfo(String ipAddress, String port, String nickName, String password) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.nickName = nickName;
        this.password = password;
    }

    
}
