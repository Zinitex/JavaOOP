/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.detailMenuInterface;

/**
 *
 * @author nanda
 */
public class detailMenu implements detailMenuInterface {
    private int id;
    private menu Menu; 
    private int quantity;
    private int total;

    public detailMenu(menu Menu, int quantity) {
        this.Menu = Menu;
        this.quantity = quantity;
        this.total = Menu.getHarga() * quantity;
    }

    @Override
    public void calculateTotal() {
        this.total = this.quantity * this.Menu.getHarga();
    }

    // Getters
    @Override
    public int getTotal() {
        return this.total;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public menu getMenu() {
        return this.Menu;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal(); 
    }

    @Override
    public void setMenu(menu Menu) {
        this.Menu = Menu;
        calculateTotal(); 
    }
}
