package dataBase.queries;



import ObjectData.SignUpFormObjectData;

import java.sql.SQLException;
import java.sql.Statement;

public class SignUpTable extends CommonTable{

    public SignUpTable() throws SQLException {
    }
    public synchronized void insertTableObject(SignUpFormObjectData data) throws SQLException {
        Statement stm = dbConnection.getConnection().createStatement();
        String query = "insert into SignUp_users(password, gender,day,month,year,firstName, lastName, company, adress, state, city, zipcode, mobile) " +
                "values ('" + data.getPassword() + "'" + "," +
                "'" + data.getGender() + "'" + "," +
                "'" + data.getDay() + "'" + "," +
                "'" + data.getMonth() + "'" + "," +
                "'" + data.getYear() + "'" + "," +
                "'" + data.getFirstName() + "'" + "," +
                "'" + data.getLastName() + "'" + "," +
                "'" + data.getCompany() + "'" + "," +
                "'" + data.getAdress() + "'" + "," +
                "'" + data.getState() + "'" + "," +
                "'" + data.getCity() + "'" + "," +
                "'" + data.getZipcode() + "'" + "," +
                "'" + data.getMobile() + "'" + ");";
        stm.execute(query);
    }
    public synchronized void updateEntryById(SignUpFormObjectData data, Integer idSignUpTable) throws SQLException {
        Statement stm = dbConnection.getConnection().createStatement();
        String query = "update SignUp_users set company='" + data.getCompany() +
                "' where id=" + idSignUpTable + ";";
        stm.execute(query);
    }
}
