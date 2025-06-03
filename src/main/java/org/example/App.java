package org.example;

import org.example.controller.BookController;
import org.example.repository.BookRepository;
import org.example.view.BookView;

import java.util.Scanner;

public class App {
    private String greetingMessage = "Welcome to the library";
    private String options = "Options:\n" +
            "1. Show book list\n" +
            "2. Add one book\n" +
            "3. Delete one book\n" +
            "4. Modify one book\n" +
            "5. Exit options menu\n" +
            "Select one number (eg 1): ";

    private BookRepository bookRepository;
    private BookController bookController;
    private BookView bookView;

    public App() {
        this.bookRepository = new BookRepository();
        this.bookController = new BookController(bookRepository);
        this.bookView = new BookView(bookController);
    }

    public void startMenu() {
        System.out.println(greetingMessage);
        Scanner scanner = new Scanner(System.in);
        boolean insideLoop = true;
        while (insideLoop) {
            System.out.print(options);
            String chosenOption = scanner.next().trim();
            scanner.nextLine();
            switch (chosenOption) {
                case "1":
                    bookView.showBooks();
                    break;
                case "2":
                    bookView.saveBookView();
                    break;
                case "3":
                    bookView.deleteBookView();
                    break;
                case "4":
                    bookView.updateBookView();
                    break;
                case "5":
                    insideLoop = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose one option from 1 to 5");
            }
        }
    }
}

