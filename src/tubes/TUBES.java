/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;

import GUI.loginForm;
import Lib.database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nanda
 */
public class TUBES {

    public static void main(String[] args) {
        System.out.println("Test");
        new TUBES().loadData();
        new loginForm().setVisible(true);
    }
    
    public void loadData() {
        try {
            Connection connection = database.getConnection();
            Statement statement = connection.createStatement();

            System.out.println("Connected to the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
