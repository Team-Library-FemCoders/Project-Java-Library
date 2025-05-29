package org.example;

import org.example.config.DBManager;
import org.example.controller.BookController;
import org.example.model.Book;
import org.example.repository.BookRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//        Book book = new Book("hola", "hola", "hola", "hola", "hola", 3);
//        System.out.println(book.describeBook());

        BookRepository bookRepository = new BookRepository();
        BookController bookController = new BookController(bookRepository);
        bookController.findAllController();

    }
}