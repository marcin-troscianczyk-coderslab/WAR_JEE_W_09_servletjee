package pl.coderslab.dao;

import pl.coderslab.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean addBook(Book book) {

        try (Connection connection =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore",
                             "root", "coderslab");
             PreparedStatement statement = connection.prepareStatement("insert into book(title, author, isbn) values (?, ?, ?)")) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());

            statement.setString(3, book.getIsbn());
            int count = statement.executeUpdate();

            return count == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Book> findAllBooks() {

        try (Connection connection =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore",
                             "root", "coderslab");
            Statement statement = connection.createStatement()) {

            List<Book> books = new ArrayList<>();

            try (ResultSet rs = statement.executeQuery("select title, author, isbn from book")) {

                while (rs.next()) {
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    String isbn = rs.getString("isbn");

                    Book book = new Book(title, author, isbn);
                    books.add(book);
                }
            };

            return books;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public boolean deleteById(int id) {

        try (Connection connection =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore",
                             "root", "coderslab");
             PreparedStatement statement = connection.prepareStatement("delete from book where id = ?")) {

            statement.setInt(1, id);
            int count = statement.executeUpdate();

            return count == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
