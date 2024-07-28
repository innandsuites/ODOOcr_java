/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pos.adm.dat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class UsuarioDB {
    ConexionDB conexionDB;
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    String SQL;
    boolean bool;

    public UsuarioDB() {
        conexionDB = new ConexionDB();
        SQL = "";
        bool = false;
    }
    
    public boolean autentificar(String str){
        bool = false;
        SQL = "SELECT * FROM usuario where clave ='" + str + "'";
        try{
            conn = (Connection)conexionDB.Conectar();
            statement = (Statement)conn.createStatement();
            resultSet = statement.executeQuery(SQL);
            if(resultSet.next()) bool = true;
            conn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Usuario" + e);
        }

        return bool;
    }
    
    public boolean actualizar(String s){
        bool = false;
        SQL = "UPDATE usuario set clave = '" + s + "' where id = 1";
        try{
            conn = (Connection)conexionDB.Conectar();
            statement = (Statement)conn.createStatement();
            statement.execute(SQL);
            bool = true;
            conn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Usuario" + e);
        }
        return bool;
    }

    }
    
    
    
