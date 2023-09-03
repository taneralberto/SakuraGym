package clases.bdd;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conectar{
    
    public static final String URL = "jdbc:mysql://localhost:3306/sakuragymbddd";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
    
}