package org.example;

import org.example.config.DBManager;
import org.example.model.Book;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DBManager.initConnection();
        DBManager.closeConnection();

        Book book = new Book("hola", "hola", "hola", "hola", "hola", 3);
        System.out.println(book.toString());

    }
}