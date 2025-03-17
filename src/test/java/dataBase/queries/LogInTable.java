package dataBase.queries;

import ObjectData.SignUpLogInFormObjectData;


import java.sql.SQLException;
import java.sql.Statement;

public class LogInTable extends CommonTable{

    public LogInTable() throws SQLException {
    }
    public synchronized void insertTableObject(SignUpLogInFormObjectData data) throws SQLException {
        Statement stm = dbConnection.getConnection().createStatement();
        String query = "insert into LogIn_users(logInEmail,logInPassword) " +
                "values ('" + data.getLogInEmail() + "'" + "," +
                "'" + data.getLogInPassword() + "'" + ");";
        stm.execute(query);
    }


}
