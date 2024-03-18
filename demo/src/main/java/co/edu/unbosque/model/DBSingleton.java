package co.edu.unbosque.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {

    private static Connection instance = null;

    public static void getInstance(){
        String url = "jdbc:mysql:// localhost:8080/empresa_abc";
        String user = "root";
        String pass = "1234";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            instance = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return instance;
    }
}
