/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import models.menu;

/**
 *
 * @author nanda
 */
public interface detailMenuInterface {
    void calculateTotal();
    
    int getTotal();
    int getQuantity();
    menu getMenu(); 

    void setQuantity(int quantity);
    void setMenu(menu Menu);
}
