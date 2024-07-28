package be.pos.adm.dat;

import be.pos.adm.ent.Rendimiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class RendimientoDB {

    ConexionDB conexionDB;
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    boolean bool;
    String SQL;
    String str_copy;
    int int_copy;
    Rendimiento rendimiento;
    static Calendar calendar;

    public RendimientoDB() {
        conexionDB = new ConexionDB();
        bool = false;
        SQL = "";
        str_copy = "";
        rendimiento = new Rendimiento();
        calendar = new GregorianCalendar();

        //list_array = new ArrayList<Rendimiento>();
    }

    public boolean existencia() {
        bool = false;
        SQL = "SELECT * FROM rendimiento WHERE id = '" + calendar.get(Calendar.DAY_OF_YEAR) 
               + "' AND anyo = '" + calendar.get(Calendar.YEAR) + "'";

        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                bool = true;
            }

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Archivo Rendimiento bool existencia" + ex);
        }
        return bool;
    }
    
    public Rendimiento consultar(int i) {
        
        rendimiento = new Rendimiento();
        if ((calendar.get(Calendar.DAY_OF_YEAR) - i) >= 1) {
            SQL = "SELECT * FROM rendimiento WHERE id >= '"
                + (calendar.get(Calendar.DAY_OF_YEAR) -i) + "' AND id <= '" + calendar.get(Calendar.DAY_OF_YEAR) + "'";
            try {
                conn = (Connection) conexionDB.Conectar();
                statement = (Statement) conn.createStatement();
                resultSet = statement.executeQuery(SQL);
                if (resultSet != null) {
                    while (resultSet.next()) {
                        //rendimiento.setId(resultSet.getInt("id"));
                        rendimiento.setIngreso(rendimiento.getIngreso() + resultSet.getDouble("ingreso"));
                        rendimiento.setVenta(rendimiento.getVenta() + resultSet.getDouble("venta"));
                        rendimiento.setImpuesto(rendimiento.getImpuesto() + resultSet.getDouble("impuesto"));
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento" + ex);
            }
        }
       

        return rendimiento;
    }

    public void actualizar(Rendimiento r) {

        SQL = "UPDATE rendimiento set ingreso = ingreso +'"
                + r.getIngreso() + "' ,venta = venta +'" + r.getVenta()
                + "', impuesto = impuesto +'" + r.getImpuesto() + "' WHERE id = '" + calendar.get(Calendar.DAY_OF_YEAR) + "'";

        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            statement.execute(SQL);

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento" + ex);
        }

    }
    
    public void insertar(Rendimiento r){
        
         SQL = "INSERT INTO rendimiento(id, anyo, ingreso, venta, impuesto)"
                 + "values('" + calendar.get(Calendar.DAY_OF_YEAR) + "', '" + calendar.get(Calendar.YEAR)
                + "', '" + r.getIngreso() + "', '" + r.getVenta() + "', '" + r.getImpuesto() + "')";

        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            statement.execute(SQL);

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento" + ex);
        }
    }


}
