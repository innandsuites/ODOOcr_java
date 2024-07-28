/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.db.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class H2EmbeddedExample {
 
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:~/test";
        String username = "sa";
        String password = "";
 
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Connected to H2 embedded database.");
 
        String sql = "SELECT * FROM students";
// String sql = "Create table students (ID int primary key, name varchar(50))";
//String sql = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";
 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
//statement.execute(sql);
//int rows = statement.executeUpdate(sql);
 
        int count = 0;
 
        while (resultSet.next()) {
            count++;
 
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println("Student #" + count + ": " + ID + ", " + name);
        }
 
        connection.close();
    }
}