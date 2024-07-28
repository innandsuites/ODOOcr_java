/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package be.odoo;

/**
 *
 * @author jdaniel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Select PreparedStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class OdooConnect {

    private final static String url = "jdbc:postgresql://192.168.100.200:5432/tienda";
    private final static String user = "postgres"; //"openpg";
    private final static String password = "jsdaniel"; //"openpgpwd";

    private static final String QUERY = "select order_id,name,full_product_name,price_unit from pos_order_line where order_id =?";
    private static final String QUERY_ORDER_ID = "select id, amount_total from pos_order";
    private static final String SELECT_ALL_QUERY = "select * from pos_order_line";
    ArrayList<String> order_resume_list = new ArrayList<String>();
    ArrayList<String> order_line_list = new ArrayList<String>();

    public ArrayList getOrderDetail() {
        // using try-with-resources to avoid closing resources (boiler plate
        // code)

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("order_id");
                String name = rs.getString("name");
                String full_product_name = rs.getString("full_product_name");
                Double price = rs.getDouble("price_unit");
                //String password = rs.getString("password");
                System.out.println(id + "," + name + "," + full_product_name + "," + price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order_line_list;
    }

    public void getUserById_template() {
        // using try-with-resources to avoid closing resources (boiler plate
        // code)

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("order_id");
                String name = rs.getString("name");
                String full_product_name = rs.getString("full_product_name");
                Double price = rs.getDouble("price_unit");
                //String password = rs.getString("password");
                System.out.println(id + "," + name + "," + full_product_name + "," + price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public ArrayList getOrderId() {
        // using try-with-resources to avoid closing resources (boiler plate
        // code)

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ORDER_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                Double amount = rs.getDouble("amount_total");
                order_resume_list.add("   "+String.valueOf(id)+"                "+Double.toString(amount));
                //System.out.println(id + "," + name + "," +  + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order_resume_list;
    }

//    public static void main(String[] args) {
//        OdooConnect example = new OdooConnect();
//        example.getUserById();
//        //example.getAllUsers();
//    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}