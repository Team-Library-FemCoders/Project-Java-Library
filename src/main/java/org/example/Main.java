package org.example;

import org.example.config.DBManager;
import org.example.controller.BookController;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.example.view.BookView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Book book = new Book("El último Catón", "Matilde Asensi", "Bajo el suelo de la Ciudad del Vaticano, la hermana Ottavia Salina, recibe el encargo de descifrar unas extrañas escarificaciones.", "Ficción", "9788408081715");
//        System.out.println(book.describeBook());

        BookRepository bookRepository = new BookRepository();
        BookController bookController = new BookController(bookRepository);
        //bookController.findAllController();
        BookView bookView= new BookView(bookController);
        //bookView.showOneBook(book);

        //bookView.deleteBookView();

        //bookView.saveBookView();

        //bookView.formSelectBookId();

        bookView.showBooks();




    }
}