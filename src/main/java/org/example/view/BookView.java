package org.example.view;

import org.example.controller.BookController;
import org.example.model.Book;

import java.util.List;

public class BookView {

    private final BookController bookController;
//    public static final String WHITE_BOLD = "\033[1;37m";
//    public static final String RESET = "\033[0m" ;

    public BookView(BookController bookController ){
        this.bookController = bookController;
    }

    public List<Book> getBooks(){
        return bookController.findAllController();
    }

    public void showOneBook(Book book){
        String leftAlignment = "\t | %-3s | %-50s | %-30s | %-15s | %-13s | %n";
        System.out.printf(leftAlignment,book.getId(), book.getTitle(), book.getAuthor(),book.getGenre(),book.getIsbn());
    }

    public void showBooks(){
        List<Book> bookList =this.getBooks();
        String leftAlignment = "\t | %-3s | %-50s | %-30s | %-15s | %-13s | %n";
        System.out.printf(leftAlignment,"Id", "Title", "Author", "Genre","Isbn");
        for (Book book : bookList){
            this.showOneBook(book);
        }

    }


}
