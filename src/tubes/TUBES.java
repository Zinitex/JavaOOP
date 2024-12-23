/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;


import gui.loginForm;
import lib.database;
import models.account;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import models.detailMenu;

/**
 *
 * @author nanda
 */
public class TUBES {

    public static account akun;
    public static ArrayList<detailMenu> orderList = new ArrayList<>();

    public static void main(String[] args) {
        TUBES app = new TUBES();

        if (!app.loadData()) {
            System.out.println("Failed to load data. Exiting program.");
            return;
        }

//        new loginForm().setVisible(true);
//      bypass login 
      akun = new account("admin@restoran.com", "admin123", "nanda", "admin",2);
      akun.login();
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
}
