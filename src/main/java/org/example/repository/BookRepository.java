package org.example.repository;

import org.example.config.DBManager;
import org.example.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    Connection connection;

    public List<Book> findAll() {

        List<Book> booksList = new ArrayList<>();

        String querySQLSelectALl = "SELECT * FROM books";

        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLSelectALl);
            ResultSet response = statement.executeQuery();

            while(response.next()) {
                int id = response.getInt("id_book");
                String title = response.getString("title");
                String author = response.getString("author");
                String summary = response.getString("summary");
                String genre = response.getString("genre");
                String isbn = response.getString("isbn");

                Book book = new Book(title, author, summary, genre, isbn, id);
                booksList.add(book);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
        return booksList;
    }

    public void saveBook(Book book) {
        String querySQLCreate = "INSERT INTO books (title, author, summary, genre, isbn) VALUES (?, ?, ?, ?, ?)";

        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLCreate);

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getSummary());
            statement.setString(4, book.getGenre());
            statement.setString(5, book.getIsbn());

            statement.execute();

            System.out.println("Book created");

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }
}
