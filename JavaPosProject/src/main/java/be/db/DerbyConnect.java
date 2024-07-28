/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.db;


import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario9
 */
public class DerbyConnect {
    
    String user = "";    //shema
    String pass = "";
    public String url = "jdbc:derby://localhost:1527/hacienda";
   // public Statement statement = null;
   // public ResultSet resultSet = null;
    
    public DerbyConnect(){}
    public Connection Conectar(){
        Connection enlace = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            enlace = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return enlace;
    }
    
    
    
}
