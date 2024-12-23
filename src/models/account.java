/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import gui.debug;
import gui.mainMenu;
import interfaces.accountInterface;
import lib.validasiException;

/**
 *
 * @author nanda
 */
public class account implements accountInterface{
    private String email;
    private String password;
    private String username;
    private String role;

    public account(String email, String password, String username, String role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    @Override
    public void login() {
        if (this.role.equals("admin")) {
            new debug().setVisible(true);
        }
        new mainMenu().setVisible(true);
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getRole() {
        return this.role;
    }
    
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
