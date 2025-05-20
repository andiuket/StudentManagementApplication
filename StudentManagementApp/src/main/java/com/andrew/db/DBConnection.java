package com.andrew.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con;

    public static Connection createConnection(){

        try {
            // 1. Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Define connection URL, username, and password
            String url = "jdbc:postgresql://localhost:5432/studentdb";
            String user = "andrew";
            String password = "admin";

            // 3. Create connection
            con = DriverManager.getConnection(url, user, password);

            System.out.println("✅ PostgreSQL connection established successfully.");

        } catch (ClassNotFoundException e) {
            System.err.println("❌ PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to PostgreSQL.");
            e.printStackTrace();
        }

        return con;
    }
}
