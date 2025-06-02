package org.example.controller;

import org.example.model.Book;
import org.example.repository.BookRepository;

import java.util.List;

public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllController(){
        return this.bookRepository.findAll();
    }

    public void saveBookController(Book book) {
        bookRepository.saveBook(book);
    }

    public void deleteBookController(int id) {
        bookRepository.deleteBook(id);
    }

    public void updateBookController(Book book) {
        bookRepository.updateBook(book);
    }
}

