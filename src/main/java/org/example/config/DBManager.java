package org.example.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("./")
            .load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USERNAME");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    private static Connection connection;

    public static Connection initConnection() {
        if (URL == null || USER == null || PASSWORD == null) {
            throw new RuntimeException("Environment variables not correctly configured");
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Successful connection");
        } catch (SQLException exception) {
            System.out.println("Connection error: " + exception.getMessage());
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection correctly closed");
            }
        } catch (SQLException exception) {
            System.out.println("Closing connection error: " + exception.getMessage());
        }
    }


}
