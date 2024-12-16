/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Databases;

import Models.account;
import java.sql.*;

/**
 *
 * @author nanda
 */
public class DatabasePerson{
    PreparedStatement state;
    
    public account insert(account o) throws SQLException {
        System.out.println("Test");
        return o;
    }
}
