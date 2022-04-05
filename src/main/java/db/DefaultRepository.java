package db;

import java.sql.SQLException;
import java.sql.Statement;

public class DefaultRepository {
    public Statement statement;

    public DefaultRepository(){
        try {
            statement = DBConnection.conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
