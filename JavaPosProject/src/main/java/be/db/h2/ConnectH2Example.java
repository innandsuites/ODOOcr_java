/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.db.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class ConnectH2Example {
 
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:mem:test";
 
        Connection connection = DriverManager.getConnection(jdbcURL);
 
        System.out.println("Connected to H2 in-memory database.");
 
        String sql = "Create table students (ID int primary key, name varchar(50))";
         
        Statement statement = connection.createStatement();
         
        statement.execute(sql);
         
        System.out.println("Created table students.");
         
        sql = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";
         
        int rows = statement.executeUpdate(sql);
         
        if (rows > 0) {
            System.out.println("Inserted a new row.");
        }
 
        connection.close();
 
    }
}