
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Models.account;
import java.sql.SQLException;

/**
 *
 * @author nanda
 */
public interface accountInterface {
    account insert(account o) throws SQLException;
}
