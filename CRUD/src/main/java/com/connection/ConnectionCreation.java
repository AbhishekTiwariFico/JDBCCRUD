package com.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreation {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/CRUD?autoReconnect=true&useSSL=false";;
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,user,pwd);
        return con;
    }
}
