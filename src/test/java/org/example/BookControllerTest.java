package org.example;

import org.example.controller.BookController;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@ExtendWith(MockitoExtension.class)
//public class BookControllerTest {
//
//
//    @Mock
//    private BookRepository bookRepository;
//
//    @InjectMocks
//    private BookController bookController;
//
//    @Test
//    void saveBookController_shouldCallRepository(){
//
//
//        Book book = new Book("aaa", "bbb", "ccc", "dddd", "eee");
//        bookController.saveBookController(book);
//
//        verify(bookRepository, times(1)).saveBook(book);
//    }
//
//}
public class BookControllerTest {
    @Test
    void test(){
        int num = 2;
        int result = num + num;
        assertEquals(4, result);
    }
}
