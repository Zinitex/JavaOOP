/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

import java.sql.*;

/**
 *
 * @author nanda
 */
public class database {
    private static final String URL = "jdbc:mysql://localhost:3306/selera_nusantara";
    private static final String USER ="root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
