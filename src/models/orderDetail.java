/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author nanda
 */
public class orderDetail {
    private final int id;
    private final Date date;
    private final String status;
    private int totalPrice = 0;
    private int itemCount = 0;

    public orderDetail(int id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public void addMenu(int menuPrice, int menuQuantity) {
        this.totalPrice += menuPrice * menuQuantity;
        this.itemCount += menuQuantity;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return itemCount;
    }
}
