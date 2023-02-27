package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionFactory implements ConnectionFactory {
    private String url;
    private String user;
    private String password;

    public H2ConnectionFactory(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection createConnection() {

        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException("Error creating H2 database connection", e);
        }
    }
    // Write your code here!
}

