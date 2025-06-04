# 📓 Project Java Library

This is a simple command-line application for managing a book library. It allows users to perform basic operations such as adding, viewing, updating, and deleting book records. The application uses a MySQL database to store book information.

## 📌  Features

The application provides the following features:

*   **Show book list:** Displays all the books currently stored in the library.
*   **Show one book by ID:** Displays detailed information about a specific book, identified by its ID.
*   **Add one book:** Allows users to add a new book to the library by providing its title, author, summary, genre, and ISBN.
*   **Delete one book:** Removes a book from the library based on its ID.
*   **Modify one book:** Allows users to update the information of an existing book.

## 📋 Project Structure

The project follows a standard Maven project structure:

```
Project-Java-Library_app/
├── .gitignore          
├── pom.xml           
├── README.md            
├── .env.example         
└── src/
    ├── main/
    │   └── java/
    │       └── org/example/
    │           ├── App.java            
    │           ├── Main.java           
    │           ├── config/
    │           │   └── DBManager.java  
    │           ├── controller/
    │           │   └── BookController.java 
    │           ├── model/
    │           │   └── Book.java       
    │           ├── repository/
    │           │   └── BookRepository.java 
    │           └── view/
    │               └── BookView.java   
    └── test/
        └── java/
            └── org/example/    
                └── repository/
                    └── BookRepositoryTest.java 
```

## 💻 Setup

1.  **Prerequisites:**
    *   **Java (JDK):** Version 21 or higher.
    *   **Maven:** A build automation tool used primarily for Java projects.
    *   **MySQL Server:** A relational database management system.

2.  **Clone the Repository:**
    ```bash
    git clone <repository-url>
    cd Project-Java-Library_app
    ```

3.  **Database Setup:**
    *   Ensure your MySQL server is running.
    *   Create a database for the application (e.g., `project-java-library`).
    *   Create a table named `books` within your database. You can use the following SQL schema:
        ```sql
        CREATE TABLE books (
            id_book INT AUTO_INCREMENT PRIMARY KEY, UNIQUE
            title VARCHAR(100) NOT NULL,
            author VARCHAR(100) NOT NULL,
            summary VARCHAR(200) NOT NULL,
            genre VARCHAR(50) NOT NULL,
            isbn VARCHAR(13) NOT NULL, 
        );
        ```

4.  **Configure Environment Variables:**
    *   Create a `.env` file in the root directory of the project.
    *   Add the following environment variables to the `.env` file, replacing the placeholder values with your actual database credentials:
        ```env
        DB_URL=jdbc:mysql://localhost:3306/your_database_name
        DB_USERNAME=your_mysql_username
        DB_PASSWORD=your_mysql_password
        ```
    *   An example file `.env.example` is provided. You can rename it to `.env` and update the values.


## 🔄 Running the Application

After successfully building the project, you can run the application in a few ways:

1. **From your IDE:**
    * Import the project into your Java IDE.
    * Locate the `Main.java` file in `src/main/java/org/example/`.
    * Run the `main` method in this class.

Once the application starts, it will run in your **terminal** and display a welcome message along with a menu. You can interact with the book library by typing options directly into the terminal.

## 💻 Technologies Used


*   **Java:** The core programming language used for the application (Version 21).
*   **MySQL:** Relational database used for storing book data.
*   **Dotenv-java:** Library for loading environment variables from a `.env` file.
*   **JUnit 5 (Jupiter):** Testing framework for Java.
*   **Mockito:** Mocking framework for creating test doubles in unit tests.

## 🔄 Running Tests

The project includes tests, primarily focusing on the `BookController` and its interaction with the `BookRepository`.

## 🎬 Usage Example

Once the application is running, you will be presented with a menu:

```
Welcome to the library
Options:
1. Show book list
2. Show one book by Id
3. Add one book
4. Delete one book
5. Modify one book
6. Exit options menu
Select one number (eg 1):
```

You can interact with the application by entering the number corresponding to the desired option.

**Example: Showing the book list**

1.  Enter `1` to select "Show book list".
2.  The application will display a table with all the books:
    ```
    Id   | Title                                                | Author                         | Genre           | Isbn          |  
    1    | Superintelligence: Paths, Dangers, Strategies        | Nick Bostrom                   | Futurology      | 9780198739838 |
    ```

**Example: Show one book by Id**

1.  Enter `2` to select "Show one book by Id".
2.  The application will prompt you to enter the ID of the book you want to see:
    ```
    Write the book ID to select it or write 0 to exit: 1
    ```
    (Assuming a book with ID 1 exists, e.g., 'The Great Gatsby')
3.  The application will display the details of the selected book:
    ```
    Id: 1
    Title: Superintelligence: Paths, Dangers, Strategies
    Author: Nick Bostrom
    Summary: Talks about the existential risks of an artificial
    Genre: Futurology
    ISBN: 9780198739838
    ```

**Example: Adding a new book**

1.  Enter `3` to select "Add one book".
2.  The application will prompt you to enter the book's details:
    ```
    Rellena la información del libro: 
    Title: Superintelligence: Paths, Dangers, Strategies
    Author: Nick Bostrom
    Summary: Talks about the existential risks of an artificial superintelligence.
    Genre: Futurology
    ISBN: 9780198739838
    ```
3.  After entering all the details, the application will confirm that the book has been saved:
    ```
    Book saved
    ```

**Example: Deleting a book**

1.  Enter `4` to select "Delete one book".
2.  The application will ask for the ID of the book to delete:
    ```
    You are going to delete a book.
    Write the book ID to select it or write 0 to exit: 1 
    ```
    (Assuming book with ID 1 is 'Superintelligence: Paths, Dangers, Strategies' as per previous example)
3.  It will show the book to be deleted and ask for confirmation:
    ```
    Id   | Title                                                | Author                         | Genre           | Isbn          |  
    1    | Superintelligence: Paths, Dangers, Strategies        | Nick Bostrom                   | Futurology      | 9780198739838 |
    
    Do you really want to delete this book (id: 1)? (Y/N/Exit)
    ```
4.  Enter `Y` to confirm:
    ```
    Book deleted
    ```
    Enter `N` to cancel, or `E` to exit the delete operation.

**Example: Modifying a book**

1.  Enter `5` to select "Modify one book".
2.  The application will ask for the ID of the book to modify:
    ```
    Write the book ID to select it or write 0 to exit: 2
    ```
    (Assuming a book with ID 2 exists, e.g., 'To Kill a Mockingbird')
3.  The application will then display the current details of the book and prompt you to enter new values for each field. Press Enter to keep the current value.
    ```
    Current title: To Kill a Mockingbird 
    New title (Leave empty for no change)(Max 100 characters): 
    To Kill a Mockingbird 
    
    Current Author: Harper Lee 
    New Author (Leave empty for no change)(Max 100 characters): 
    
    Current Summary: A novel about the serious issues of rape and racial inequality. 
    New Summary (Leave empty for no change)(Max 200 characters): 
    A profound novel about justice, compassion, and racial inequality in the American South.
    
    Current Genre: Southern Gothic 
    New Genre (Leave empty for no change)(Max 50 characters): 
    Classic Fiction
    
    Current Isbn: 9780061120084 
    New Isbn (Leave empty for no change)(Max 13 characters): 
    
    ```
4.  After you've gone through all fields, the application confirms:
    ```
    Book updated
    ```

**Example: Exiting the application**

1.  Enter `6` to select "Exit options menu".
2.  The application will terminate.

## 🤝 Team members
This project was developed as a team exercise to practice team collaboration, software engineering best practices, and the use of modern development tools and workflows.  
We applied the **Model-View-Controller (MVC)** architectural pattern to organize the application and improve code maintainability and separation of responsabilities.

- [Iris](https://github.com/isanort)
- [Lara](https://github.com/Lizar22)
- [Judit](https://github.com/J-uds)
- [Ana Carina](https://github.com/acpp2510)
