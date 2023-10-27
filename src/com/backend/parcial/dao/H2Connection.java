package com.backend.parcial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection =  DriverManager.getConnection("jdbc:h2:~/parcial", "sa", "sa");
        connection.setAutoCommit(false);
        return connection;
    }

}