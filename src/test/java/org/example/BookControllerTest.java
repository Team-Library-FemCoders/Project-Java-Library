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

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    @Test
    void findAllController_callsRepository() {
        // Call the method under test
        bookController.findAllController();
        // Verify that bookRepository.findAll() was called exactly once
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void selectOneBookByIdController_callsRepository() {
        // 1. Define a sample ID
        int sampleId = 1;
        // 2. Call the method under test
        bookController.selectOneBookByIdController(sampleId);
        // 3. Verify that bookRepository.deleteBook() was called exactly once with the sampleId
        verify(bookRepository, times(1)).selectOneBookById(sampleId);
    }

    @Test
    void saveBookController_callsRepository() {
        // Arrange
        Book book = new Book("aaa", "bbb", "ccc", "dddd", "eee");

        // Act
        bookController.saveBookController(book);

        // Assert
        verify(bookRepository, times(1)).saveBook(book);
    }

    @Test
    void deleteBookController_callsRepository() {
        // 1. Define a sample ID
        int sampleId = 1;
        // 2. Call the method under test
        bookController.deleteBookController(sampleId);
        // 3. Verify that bookRepository.deleteBook() was called exactly once with the sampleId
        verify(bookRepository, times(1)).deleteBook(sampleId);
    }

    @Test
    void updateBookController_callsRepository() {
        // 1. Define a sample book
        Book book = new Book("aaa", "bbb", "ccc", "dddd", "eee", 1);
        // 2. Call the method under test
        bookController.updateBookController(book);
        // 3. Verify that bookRepository.deleteBook() was called exactly once with the sampleId
        verify(bookRepository, times(1)).updateBook(book);
    }


}
