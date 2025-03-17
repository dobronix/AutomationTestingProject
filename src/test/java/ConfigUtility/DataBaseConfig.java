package ConfigUtility;

public class DataBaseConfig {
    private String userName;
    private String password;
    private String dataBase;
    private String port;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDataBase() {
        return dataBase;
    }

    public String getPort() {
        return port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
