package be.pos.dat;

import be.pos.ent.Rendimiento;
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

    public Rendimiento consultar(int id) {
        SQL = "SELECT * FROM rendimiento WHERE id = '" + id + "'";
        rendimiento = new Rendimiento();
        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            resultSet = statement.executeQuery(SQL);
            if (resultSet != null) {
                while (resultSet.next()) {
                    rendimiento.setId(resultSet.getInt("id"));
                    rendimiento.setIngreso(resultSet.getInt("ingreso"));
                    rendimiento.setVenta(resultSet.getInt("venta"));
                    rendimiento.setImpuesto(resultSet.getInt("impuesto"));
                }
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento consultar" + ex);
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
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento actualizar" + ex);
        }

    }
    
    public void insertar(Rendimiento r){
        
         SQL = "INSERT INTO rendimiento(id, anyo, ingreso, venta, impuesto)"
                 + " values('" + calendar.get(Calendar.DAY_OF_YEAR) + "', '" + calendar.get(Calendar.YEAR)
                + "', '" + r.getIngreso() + "', '" + r.getVenta() + "', '" + r.getImpuesto() + "')";

        try {
            conn = (Connection) conexionDB.Conectar();
            statement = (Statement) conn.createStatement();
            statement.execute(SQL);

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento insertar" + ex);
        }
    }

//    public void crearDias(){
//        
//        //rendimiento = new Rendimiento();
//        try {
//            conn = (Connection) conexionDB.Conectar();
//            statement = (Statement) conn.createStatement();
//            for(int i = 1; i <= 370; i++)
//            {
//                SQL = "INSERT INTO rendimiento(id, ingreso, venta, impuesto) "
//                + " values('" + i + "', 0, 0, 0)";
//            statement.execute(SQL);
//                            
//            }
//            conn.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error en Base de Datos Archivo Rendimiento" + ex);
//        }
//        
//        
//    }
}
