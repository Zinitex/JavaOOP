/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import gui.mainMenu;
import interfaces.accountInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lib.database;
import java.sql.*;
import static tubes.TUBES.menuList;

/**
 *
 * @author nanda
 */
public class account implements accountInterface {

    private int id;
    private String email;
    private String password;
    private String username;
    private String role;
    public ArrayList<detailMenu> orderList = new ArrayList<>();
    public Map<Integer, orderDetail> orderHistory = new HashMap<>();

    public account(String email, String password, String username, String role, int id) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.id = id;
    }

    public boolean loadOrderHistory() {
        try {
            String query = """
            SELECT 
                p.id AS pemesanan_id,
                p.tanggal,
                p.status,
                dp.menu_id,
                dp.jumlah AS menu_quantity
            FROM 
                pemesanan p
            JOIN 
                detailpemesanan dp ON p.id = dp.pemesanan_id
            WHERE 
                p.user_id = ?;
        """;

            PreparedStatement statement = database.getConnection().prepareStatement(query);
            statement.setInt(1, this.id);
            ResultSet resultSet = statement.executeQuery();

            this.orderHistory.clear();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("pemesanan_id");
                Date orderDate = resultSet.getDate("tanggal");
                String orderStatus = resultSet.getString("status");
                int menuId = resultSet.getInt("menu_id");
                int menuQuantity = resultSet.getInt("menu_quantity");

                menu Menu = menuList.get(menuId);
                if (Menu == null) {
                    System.err.println("Menu ID " + menuId + " not found in menuList. Skipping...");
                    continue;
                }

                orderDetail order = this.orderHistory.getOrDefault(
                        orderId,
                        new orderDetail(orderId, orderDate, orderStatus)
                );

                detailMenu detail = new detailMenu(Menu, menuQuantity);
                order.detailMenu.put(menuId, detail);

                order.setTotalItem(order.getTotalItem() + menuQuantity);
                order.setTotalPrice(order.getTotalPrice() + (Menu.getHarga() * menuQuantity));

                this.orderHistory.put(orderId, order);
            }

            resultSet.close();
            statement.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void login() {
        if (!this.loadOrderHistory()) {
            return;
        }
        new mainMenu().setVisible(true);
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
