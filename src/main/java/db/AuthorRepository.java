package db;

import dao.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository extends DefaultRepository{

    public Author getAuthorById(int id) {
        String sql = String.format("SELECT * FROM authors WHERE id = %d", id);

        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                return new Author(
                        result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getDate("birth_date"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
