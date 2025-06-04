package org.example.view;

import org.example.controller.BookController;
import org.example.model.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookView {

    private final BookController bookController;
    public static final String BLUE_WHITE_BG = "\033[1;34;107m";
    public static final String CYAN = "\033[1;96m";
    public static final String RED = "\033[1;91m";
    public static final String GREEN = "\033[1;92m";
    public static final String RESET = "\033[0m" ;
    private String leftAlignment = "%s" + "\t | %-3s | %-50s | %-30s | %-15s | %-13s | %n";
    public BookView(BookController bookController) {
        this.bookController = bookController;
    }

    //Read
    private List<Book> getBooks() {
        return bookController.findAllController();
    }

    private void showOneBookInList(Book book) {
        System.out.printf(this.leftAlignment, RESET, book.getId(), book.getTitle(), book.getAuthor(),book.getGenre(),book.getIsbn());
    }

    public void showAllBooksListView() {
        List<Book> bookList = this.getBooks();
        System.out.printf(this.leftAlignment, BLUE_WHITE_BG, "Id", "Title", "Author", "Genre","Isbn");
        for (Book book : bookList) {
            this.showOneBookInList(book);
        }
    }

    public void showOneBookView() {
        Book book = this.getOneBookById();
        System.out.printf(CYAN, "Id: %s%n" +
                "Title: %s%n" +
                "Author: %s%n" +
                "Summary: %s%n" +
                "Genre: %s%n" +
                "ISBN: %s%n", book.getId(), book.getTitle(), book.getAuthor(), book.getSummary(), book.getGenre(),book.getIsbn());
    }

    //Create
    private Book generateBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Summary: ");
        String summary = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, summary, genre, isbn);

        return book;
    }

    public void createAndSaveBookView() {
        Book book = generateBook();
        bookController.saveBookController(book);
        System.out.println(GREEN + "Book saved");
    }

    //Delete
    public void deleteBookView() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("You are going to delete a book.");
                int id = this.askBookId(scanner);

                if (id == 0) {
                    break;
                }

                Book book = bookController.selectOneBookByIdController(id);
                System.out.printf(this.leftAlignment, RED, book.getId(), book.getTitle(), book.getAuthor(),book.getGenre(),book.getIsbn());
                System.out.println(RESET + "Do you really want to delete this book (id: " + id + ")? (Y/N/Exit)");
                Character answer = Character.toUpperCase(scanner.next().charAt(0));
                scanner.nextLine();

                if (answer == 'Y') {
                    bookController.deleteBookController(id);
                    break;
                } else if (answer == 'E') {
                    break;
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    //Update
    private Book updateBookInstance(Book book) {
        Scanner scanner = new Scanner(System.in);
        String oldTitle = book.getTitle();
        String newTitle = this.askAttributeToUpdate(oldTitle,100, "Title", scanner);
        book.setTitle(newTitle);

        String oldAuthor = book.getAuthor();
        String newAuthor = this.askAttributeToUpdate(oldAuthor,100, "Author", scanner);
        book.setAuthor(newAuthor);

        String oldSummary = book.getSummary();
        String newSummary = this.askAttributeToUpdate(oldSummary,200, "Summary", scanner);
        book.setSummary(newSummary);

        String oldGenre = book.getGenre();
        String newGenre = this.askAttributeToUpdate(oldGenre,50, "Genre", scanner);
        book.setGenre(newGenre);

        String oldIsbn = book.getIsbn();
        String newIsbn = this.askAttributeToUpdate(oldIsbn,13, "Isbn", scanner);
        book.setIsbn(newIsbn);

        return book;
    }

    public void updateAndSaveBookView() {
        Book previousBook = this.getOneBookById();
        Book updatedBook = this.updateBookInstance(previousBook);
        bookController.updateBookController(updatedBook);
    }

    //Helpers
    private List<Integer> getIdList() {
        List<Book> bookList = this.getBooks();
        List<Integer> idList = new ArrayList<>();

        for (Book book : bookList) {
            idList.add(book.getId());
        }
        return idList;
    }

    private Book getOneBookById() {
        Scanner scanner = new Scanner(System.in);
        int id = this.askBookId(scanner);
        return bookController.selectOneBookByIdController(id);
    }

    private int askBookId(Scanner scanner) {

        List<Integer> idList = this.getIdList();

        while (true) {
            try {
                System.out.print("Write the book ID to select it or write 0 to exit: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (idList.contains(id) || id == 0) {
                    return id;
                } else {
                    System.out.println("Id not found. Please enter a valid id.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a whole number");
                scanner.nextLine();
            }
        }
    }

    private String askAttributeToUpdate(String formerValue, int maxLength, String attributeName, Scanner scanner) {

        while (true) {
            System.out.printf("Current %s: %s %n", attributeName, formerValue);
            System.out.printf("New %s (Leave empty for no change)(Max %s characters): %n", attributeName, maxLength);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return formerValue;
            } else {
                if (input.length() > maxLength){
                    System.out.println("Too many characters. Remove: " + (input.length() - maxLength)+ " characters.");
                    continue;
                }
                return input;
            }
        }
    }
}
