# 📓 Project Java Library

This is a simple command-line application for managing a book library. It allows users to perform basic operations such as adding, viewing, updating, and deleting book records. The application uses a MySQL database to store book information.

## 🚀 Project Objectives

* Backend development using Java and Object-Oriented Programming (OOP) principles
* Designing and managing MySQL databases
* Building data access components for efficient database interaction (CRUD operations)
* Writing and executing unit tests



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

## 📌  Features

The application provides the following features:

*   **Show book list:** Displays all the books currently stored in the library.
*   **Show one book by ID:** Displays detailed information about a specific book, identified by its ID.
*   **Add one book:** Allows users to add a new book to the library by providing its title, author, summary, genre, and ISBN.
*   **Delete one book:** Removes a book from the library based on its ID.
*   **Modify one book:** Allows users to update the information of an existing book.

## 💻 Setup

1.  **Prerequisites:**
    *   **Java (JDK):** Version 21 or higher.
    *   **Maven** 
    *   **MySQL Server** 
    

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
            author VARCHAR(100) NULL,
            summary VARCHAR(200) NULL,
            genre VARCHAR(50) NULL,
            isbn VARCHAR(13) NULL, 
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

After successfully building the project, you can run the application from your IDE:

1. Import the project into your Java IDE.
2. Locate the `Main.java` file in `src/main/java/org/example/`.
3. Run the `main` method in this class.

Once the application starts, it will run in your **terminal** and display a welcome message along with a menu. You can interact with the book library by typing options directly into the terminal.

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


## 💻 Technologies and Tools

### Development Tools
- **Java** (Version 21)
- **IntelliJ IDEA** 
- **Git & Gitflow** 
- **MySQL** 
- **Dotenv-java** 
- **JUnit 5** (Jupiter) 
- **Mockito** 

### Design & Planning
- **Figma** 
- **Trello** 

### Communication & Collaboration
- **Slack / WhatsApp** 
- **Google Meet / Zoom** 
- **Google Docs** 



## 🔄 Running Tests

The project includes tests, primarily focusing on the `BookController` and its interaction with the `BookRepository`.



## 🤝 Team members
This project was developed as a team exercise to practice team collaboration, software engineering best practices, and the use of modern development tools and workflows.  
We applied the **Model-View-Controller (MVC)** architectural pattern to organize the application and improve code maintainability and separation of responsibilities.

- [Iris](https://github.com/isanort)
- [Lara](https://github.com/Lizar22)
- [Judit](https://github.com/J-uds)
- [Ana Carina](https://github.com/acpp2510)
