/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;


import gui.loginForm;
import lib.database;
import models.account;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import models.menu;
import models.orderDetail;

/**
 *
 * @author nanda
 */
public class TUBES {

    public static account akun;
    public static Map<Integer, menu> menuList = new HashMap<>();

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
            System.out.println("Connected to the database.");

            String query = "SELECT * FROM menu";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            menuList.clear();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                int stock = resultSet.getInt("stock");
                int harga = resultSet.getInt("harga");

                menu newMenu = new menu(id, nama, stock, harga);
                menuList.put(id, newMenu);
            }

            resultSet.close();
            statement.close();

            System.out.println("Menu data loaded successfully.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
