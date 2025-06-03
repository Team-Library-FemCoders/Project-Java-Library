package org.example.view;

import org.example.controller.BookController;
import org.example.model.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookView {

    private final BookController bookController;
    public static final String CYAN_BOLD = "\033[1;96;47m";
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
        System.out.printf(this.leftAlignment, CYAN_BOLD, "Id", "Title", "Author", "Genre","Isbn");
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
    //selecionar libro que quieres actualizar
    public Book retunrOneBook () {
        Scanner scanner = new Scanner(System.in);
        int id = this.formSelectBookId(scanner);
        return bookController.selectOneBookByIdController(id);
    }

    //mostrar los valores anteriores que quieres cambiar
    //recoger los valores actualizados nuevos que quiere poner el usaurio
    // 1) book.getTitle() 2) maxLength  3) attributeName 4) Scanner
    // Base function
//    private String askTitle (Book book, Scanner scanner ) {
//        while (true) {
//            System.out.print("Current title: " + book.getTitle());
//            System.out.print("New title (Leave empty for no change): ");
//            String input = scanner.nextLine().trim();
//            if (input.isEmpty() ) {
//                return book.getTitle();
//            } else {
//                if (input.length()>100){
//                    System.out.println("Too many characters!! Remove: " + (input.length()-100)+ "characters.");
//                    continue;
//                }
//                return input;
//            }
//        }
//    }

    // 1) book.getTitle() 2) maxLength  3) attributeName 4) Scanner
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


    //con dichos valores actualizadosy los valores sueltos hay que crear libro de java, O1. ACTUALIZAR O O2 CREAR
    //enviar a la bbdd
}
