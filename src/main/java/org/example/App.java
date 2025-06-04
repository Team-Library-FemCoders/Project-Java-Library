package org.example;

import org.example.controller.BookController;
import org.example.repository.BookRepository;
import org.example.view.BookView;

import java.util.Scanner;

public class App {
    private String greetingMessage = "\nWelcome to the library!";
    private String options = "\nOptions:\n" +
            "1. Show book list\n" +
            "2. Show one book by Id\n" +
            "3. Add one book\n" +
            "4. Delete one book\n" +
            "5. Modify one book\n" +
            "6. Exit application\n" +
            "\nSelect one number (eg 1): ";

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
                    bookView.showAllBooksListView();
                    break;
                case "2":
                    bookView.showOneBookView();
                    break;
                case "3":
                    bookView.createAndSaveBookView();
                    break;
                case "4":
                    bookView.deleteBookView();
                    break;
                case "5":
                    bookView.updateAndSaveBookView();
                    break;
                case "6":
                    insideLoop = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose one option from 1 to 5");
            }
        }
    }
}

