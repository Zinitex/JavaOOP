/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.orderDetailInterface;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nanda
 */
public class orderDetail implements orderDetailInterface{
    private int id;
    private Date date;
    private int totalItem = 0;
    private int totalPrice = 0;
    private String status;
    public Map<Integer, detailMenu> detailMenu = new HashMap<>();

    public orderDetail(int id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
