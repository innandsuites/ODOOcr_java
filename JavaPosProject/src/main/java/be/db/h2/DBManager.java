package be.db.h2;

import java.sql.SQLException;

import org.h2.tools.Server;

public class DBManager {

    private static void startDB() throws SQLException {
        Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();

    }

    private static void stopDB() throws SQLException {
        Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
    }

    public static void main(String[] args) {
        
        try {
            Class.forName("org.h2.Driver");

            if (args.length > 0) {
                if (args[0].trim().equalsIgnoreCase("start")) {
                    startDB();
                }

                if (args[0].trim().equalsIgnoreCase("stop")) {
                    stopDB();
                }
            } else {
                System.err
                        .println("Please provide one of following arguments: \n\t\tstart\n\t\tstop");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}