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
    public String username;
    public String role;
    
    public account(String email, String password, String username, String role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }
    
    public void login(){
        if(this.role.matches("admin")){
            new debug().setVisible(true);
        }
        new mainMenu(this).setVisible(true);
    }
}
