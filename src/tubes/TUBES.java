/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;

import gui.Debug;
import gui.loginForm;
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

    account akun;

    public static void main(String[] args) {
        System.out.println("Apaan coek");
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

    public void login(String email, String password, String phone, String username, Boolean isAdmin) {
        akun = new account(email, password, phone, username, isAdmin);

        if (this.akun.isAdmin) {
            new Debug().setVisible(true);
        }
    }
}

