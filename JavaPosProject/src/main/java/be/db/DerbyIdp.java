/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.db;

import be.pos.ent.Token;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class DerbyIdp {

    String user = "";    //shema
    String pass = "";
    public String url = "jdbc:derby://localhost:1527/hacienda";
    //public String url = "jdbc:derby:hacienda";
    //C:\Users\daniel\GitHub\Facturador-Desktop
    Connection cn;
    Token token;
    // public Statement statement = null;
    // public ResultSet resultSet = null;

    public Token selectAll() throws SQLException {
        token = new Token();
        cn = Conectar();
        Statement stmt = cn.createStatement();

        stmt = cn.createStatement();

        stmt.executeQuery(" select * from idp");
        ResultSet rs = stmt.getResultSet();
        if (rs.next()) {
            token.access_token = (rs.getString("id"));

        }
        return token;
    }

    public int update(Token token) {
        String sql = "UPDATE idp SET token=?, refresh=?, expires=current_timestamp, expires_str=? WHERE id=?";
        cn = Conectar();
        PreparedStatement statement;
        int rowsUpdated =0;
        try {
            statement = cn.prepareStatement(sql);
            statement.setString(1, token.access_token);
            statement.setString(2, token.refres_token);
            //statement.setString(3, "current_timestamp");
            statement.setString(3, token.expires_str);
            statement.setString(4, token.id);
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DerbyIdp.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
        return rowsUpdated;
    }

    public void insert(Token token) throws SQLException {

        cn = Conectar();
        String insertSQL = "INSERT INTO MyTable (id, token) VALUES (?, ?)";

        PreparedStatement preparedStatement = cn.prepareStatement(insertSQL);
        preparedStatement.setString(1, token.id);
        preparedStatement.setString(2, token.access_token);
        preparedStatement.executeUpdate();
    }

    public Connection Conectar() {
        Connection enlace = null;
        try {
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            enlace = DriverManager.getConnection(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return enlace;
    }

}
