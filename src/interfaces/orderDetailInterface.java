/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.Map;
import models.detailMenu;

/**
 *
 * @author nanda
 */
public interface  orderDetailInterface {
    int getId();
    Date getDate();
    int getTotalItem();
    int getTotalPrice();
    String getStatus();

    void setId(int id);
    void setDate(Date date);
    void setTotalItem(int totalItem);
    void setTotalPrice(int totalPrice);
    void setStatus(String status);
}
