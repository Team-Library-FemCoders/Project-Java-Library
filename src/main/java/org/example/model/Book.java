package org.example.model;

public class Book {
    private String title;
    private String author;
    private String summary;
    private String genre;
    private String isbn;
    private int id;

    public Book(String title, String author, String summary, String genre, String isbn, int id) {
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.genre = genre;
        this.isbn = isbn;
        this.id = id;
    }

    public Book(String title, String author, String summary, String genre, String isbn) {
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.genre = genre;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String describeBook() {
        return  title + "\t" + author + "\t" + genre + "\t" + isbn + "\t" + id;
    }
}
