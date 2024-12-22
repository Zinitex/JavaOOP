/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nanda
 */
public class detail_menu {
    public menu Menu;
    public int quantity;
    public int total;
    public detail_menu(menu Menu, int quantity) {
        this.Menu = Menu;
        this.quantity = quantity;
        this.total = Menu.harga * quantity;
    }
    
    public void calculateTotal(){
        this.total = this.quantity * this.Menu.harga;
    }
}
