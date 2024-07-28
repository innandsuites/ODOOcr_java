/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pos.dat;

import be.pos.ent.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class ProductoDB {

    ConexionDB conexionDB;
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    String SQL;
    String str_copy;
    int int_copy;
    Producto producto;
    
    List list_array;

    public ProductoDB() {
        conexionDB = new ConexionDB();
        SQL = "";
        str_copy = "";
        producto = new Producto();
        list_array = new ArrayList<Producto>();

    }

    public Producto consultar(String id) {
        SQL = "SELECT * FROM producto WHERE id = '" + id + "'";
        producto = new Producto();
        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            resultSet = statement.executeQuery(SQL);
            if (resultSet != null) {
                while (resultSet.next()) {
                    producto.setId(resultSet.getString("id"));
                    producto.setNombre(resultSet.getString("nombre"));
                    producto.setPrecio(resultSet.getDouble("precio"));
                    producto.setGanancia(resultSet.getDouble("ganancia"));
                    producto.setIva(resultSet.getDouble("iva"));
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos" + ex);
        }
        return producto;
    }

    public void agregarRapido(Producto p) {
//        producto = new Producto();
//        producto = p;

            SQL = "INSERT INTO producto(id, nombre, detalle, precio_compra, ganancia, cantidad, iva, precio)"
                + "VALUES ('" + p.getId() + "','" + p.getNombre() + "','"
                + p.getDetalle() + "','" + p.getPrecio_compra() + "','"
                + p.getGanancia() + "','" + p.getCantidad() + "','"
                + p.getIva() + "','" + p.getPrecio() + "')";

        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            statement.execute(SQL);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos" + ex);
        }
    }

    public void agregar(Producto p) {

        SQL = "INSERT INTO producto(id, nombre, detalle, precio_compra, ganancia, cantidad, iva, precio)"
                + "VALUES ('" + p.getId() + "','" + p.getNombre() + "','"
                + p.getDetalle() + "','" + p.getPrecio_compra() + "','"
                + p.getGanancia() + "','" + p.getCantidad() + "','"
                + p.getIva() + "','" + p.getPrecio() + "')";
        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            statement.execute(SQL);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos" + ex);
        }
    }

    public void actualizar(Producto p) {

        SQL = "UPDATE producto"
                + "set id = '" + p.getId() + "', nombre = '" + p.getNombre()
                + "', detalle = '" + p.getDetalle() + "', ganancia = '" + p.getGanancia()
                + "', cantidad = '" + p.getCantidad() + "', iva = '" + p.getIva()
                + "', precio = '" + p.getPrecio() + "' WHERE id = '" + p.getId() + "'";
        try {
            conn = (Connection) conexionDB.Conectar();
            statement.execute(SQL);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos" + ex);
        }
    }


    public void actualizarCantidad(List<Producto> l) {
        //iterator = (Iterator) l;
        //producto = new Producto();
        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            for (Producto p : l) {
                SQL = "UPDATE producto"
                        + " set cantidad = cantidad -'" + p.getCantidad() + "' WHERE id = '" + p.getId() + "'";
                statement.execute(SQL);
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos" + ex);
        }
    }

    public void eliminar(String s) {
        SQL = "DELETE FROM producto WHERE id='" + s + "'";
        try {
            conn = (Connection) conexionDB.Conectar();
            statement.execute(SQL);
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos" + ex);
        }
    }

    public List<Producto> lista(String str) {

        if (str == "filtro") {
        }

        return list_array;
    }

}
