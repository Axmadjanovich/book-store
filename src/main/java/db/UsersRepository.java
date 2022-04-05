package db;

import dao.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersRepository extends DefaultRepository{

    public User findUserByUsernameAndPassword(String username, String password){
        String query = String.format(
                "select " +
                "id, " +
                "firstname, " +
                "lastname, " +
                "phonenumber, " +
                "account::numeric::double precision as account, " +
                "password, " +
                "username " +
                "from users " +
                "where username = '%s' and password = '%s' ", username, password);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                return new User(resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phonenumber"),
                        resultSet.getDouble("account"),
                        resultSet.getString("password"),
                        resultSet.getString("username"));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}
