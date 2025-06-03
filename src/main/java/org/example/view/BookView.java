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
    public static final String RESET = "\033[0m" ;
    private String leftAlignment = "%s" + "\t | %-3s | %-50s | %-30s | %-15s | %-13s | %n";
    public BookView(BookController bookController ){
        this.bookController = bookController;
    }

    public List<Book> getBooks(){
        return bookController.findAllController();
    }

    public void showOneBook(Book book){
        System.out.printf(this.leftAlignment, RESET, book.getId(), book.getTitle(), book.getAuthor(),book.getGenre(),book.getIsbn());
    }

    public void showBooks(){
        List<Book> bookList =this.getBooks();
        System.out.printf(this.leftAlignment, BLUE_WHITE_BG, "Id", "Title", "Author", "Genre","Isbn");
        for (Book book : bookList){
            this.showOneBook(book);
        }
    }

    public Book generateBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rellena la información del libro: ");
        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Autoría: ");
        String author = scanner.nextLine();

        System.out.print("Sinopsis: ");
        String summary = scanner.nextLine();

        System.out.print("Género literario: ");
        String genre = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, summary, genre, isbn);

        scanner.close();

        return book;
    }

    public void saveBookView() {
        Book book = generateBook();
        bookController.saveBookController(book);
    }

    public List<Integer> getIdList() {
        List<Book> bookList = this.getBooks();
        List<Integer> idList = new ArrayList<>();

        for (Book book : bookList) {
            idList.add(book.getId());
        }

        return idList;
    }

    private int formSelectBookId(Scanner scanner) {

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

    public void deleteBookView() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("You are going to delete a book.");

                int id = this.formSelectBookId(scanner);

                if (id == 0) {
                    break;
                }

                System.out.println("Do you really want to delete this book (id: " + id + ")? (Y/N/Exit)");
                Character answer = Character.toUpperCase(scanner.next().charAt(0));
                scanner.nextLine();

                if (answer == 'Y') {
                    bookController.deleteBookController(id);
                    break;
                } else if (answer == 'E') {
                    break;
                }
            }
        } finally {
            scanner.close();
        }
    }

    public Book selectOneBookView () {
        Scanner scanner = new Scanner(System.in);
        int id = this.formSelectBookId(scanner);
        return bookController.selectOneBookByIdController(id);
    }

    public String askAttribute (String formerValue, int maxLength, String attributeName, Scanner scanner) {

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

    public Book updateBook (Book book) {
        Scanner scanner = new Scanner(System.in);
        String oldTitle = book.getTitle();
        String newTitle = this.askAttribute(oldTitle,100, "title", scanner);
        book.setTitle(newTitle);

        String oldAuthor = book.getAuthor();
        String newAuthor = this.askAttribute(oldAuthor,100, "Author", scanner);
        book.setAuthor(newAuthor);

        String oldSummary = book.getSummary();
        String newSummary = this.askAttribute(oldSummary,200, "Summary", scanner);
        book.setSummary(newSummary);

        String oldGenre = book.getGenre();
        String newGenre = this.askAttribute(oldGenre,50, "Genre", scanner);
        book.setGenre(newGenre);

        String oldIsbn = book.getIsbn();
        String newIsbn = this.askAttribute(oldIsbn,13, "Isbn", scanner);
        book.setIsbn(newIsbn);

        return book;
    }

    public void updateBookView () {
        Book previousBook = this.selectOneBookView();
        Book updatedBook = this.updateBook(previousBook);
        bookController.updateBookController(updatedBook);
    }
}
