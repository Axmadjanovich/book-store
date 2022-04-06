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
                "first_name, " +
                "last_name, " +
                "phone_number, " +
                "account::numeric::double precision as account, " +
                "password, " +
                "username " +
                "from users " +
                "where username = '%s' and password = '%s' ", username, password);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                return new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number"),
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

    public User findUserByUsername(String username){
        String query = String.format(
                "select " +
                "id, " +
                "first_name, " +
                "last_name, " +
                "phone_number, " +
                "account::numeric::double precision as account, " +
                "password, " +
                "username " +
                "from users " +
                "where username = '%s' ", username);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                return new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number"),
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

    public User addUser(User user){
        String query = String.format(
                "insert into users " +
                "(first_name, last_name, phone_number, password, username) " +
                "values ('%s', '%s', '%s', '%s', '%s')",
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getUsername());
        try {
            statement.executeUpdate(query);
            user = findUserByUsername(user.getUsername());
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
