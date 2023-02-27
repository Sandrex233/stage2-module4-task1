package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private final static String url;
    private final static String user;
    private final static String password;

    // Load database properties from a file when the class is loaded
    static {
        try {
            Properties properties = new Properties();
            // Load properties from the file 'h2database.properties'
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
            // Load the JDBC driver class
            Class.forName(properties.getProperty("jdbc_driver"));
            // Set the database properties from the loaded file
            url = properties.getProperty("db_url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Connection createConnection() {
        try {
            // Create a connection to the database using the loaded properties
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    // Write your code here!
}

