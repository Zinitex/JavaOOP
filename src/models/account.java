/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import gui.debug;
import gui.mainMenu;
import lib.validasiException;

/**
 *
 * @author nanda
 */
public class account {
    public String email;
    public String password;
    public String phone;
    public String username;
    public Boolean isAdmin;
    
    public account(String email, String password, String phone, String username, Boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.isAdmin = isAdmin;
    }
    
    public void login(){
        if(this.isAdmin){
            new debug().setVisible(true);
        }
        new mainMenu(this).setVisible(true);
    }
}
