/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.db.h2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.h2.tools.Server;

/**
 *
 * @author jdaniel
 */
public class BatH2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
//        Class.forName("org.h2.Driver");
//        Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
        try {
            
            Server server = Server.createTcpServer(args).start();
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:~/test", "sa", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from test");
            
               
            while (rs.next()) {
                    // Display values
                    System.out.print(rs.getString("name"));
                }
              conn.close();
            TimeUnit.MINUTES.sleep(1);
            }catch (SQLException e) {
            e.printStackTrace();
        }
          

        }

    }
