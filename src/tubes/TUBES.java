/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;

import gui.debug;
import gui.loginForm;
import gui.mainMenu;
import lib.database;
import models.account;
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

    private account akun;
    public static void main(String[] args) {
        System.out.println("Apaan coek");

        TUBES app = new TUBES();

        if (!app.loadData()) {
            System.out.println("Failed to load data. Exiting program.");
            return; 
        }

//        new loginForm().setVisible(true);
        
//      Dev 
        app.login("nanda@gmail.com", "admin123", "08123456789", "nanda", true);
    }

    public boolean loadData() {
        try {
            Connection connection = database.getConnection();
            Statement statement = connection.createStatement();

            System.out.println("Connected to the database.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void login(String email, String password, String phone, String username, Boolean isAdmin) {
        akun = new account(email, password, phone, username, isAdmin);

        new mainMenu(akun).setVisible(true);
        if (this.akun.isAdmin) {
            new debug().setVisible(true);
        }
    }
}

