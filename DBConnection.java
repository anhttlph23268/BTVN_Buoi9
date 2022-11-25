/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class DBConnection {
    
    public static Connection conn;

    public static Connection getConnection() {

        if (DBConnection.conn == null) {

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String dbUser = "sa", dbPass = "123456",
                        dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=buoi8;encrypt=true;trustServerCertificate=true;";

                DBConnection.conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công!");

            } catch (ClassNotFoundException e) {
            } catch (SQLException e) {
            }

        }

        return conn;
    }
    
    public static void main(String[] args) {
        System.out.println(conn);
    }
}
