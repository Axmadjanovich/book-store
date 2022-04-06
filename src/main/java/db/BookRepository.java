package db;

import dao.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
public class BookRepository extends DefaultRepository{

    public Book getBookById(Integer id) {
        String query = "SELECT * FROM BOOKS WHERE ID = " + id;
        try {

            ResultSet result = statement.executeQuery(query);
            Book book = new Book();
            if (result.next()) {
                book.setId(result.getInt("id"));
                book.setCost(result.getDouble("cost"));
                book.setGenre(result.getString("genre"));
                book.setNameUz(result.getString("name_uz"));
                book.setNameRu(result.getString("name_ru"));
                book.setPageCount(result.getInt("page_count"));
                book.setPublishedDate(result.getDate("published_date"));
                book.setPublisherId(result.getInt("publisher_id"));
                book.setAuthorId(result.getInt("author_id"));
                return book;
            }
            return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
