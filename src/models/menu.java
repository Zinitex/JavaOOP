/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import interfaces.menuInterface;

/**
 *
 * @author nanda
 */
public class menu implements menuInterface{
    private int id;
    private String nama;
    private int stock;
    private int harga;

    public menu(int id, String nama, int stock, int harga) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
        this.harga = harga;
    }

    // Getters
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public int getHarga() {
        return harga;
    }

    // Setters
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void setHarga(int harga) {
        this.harga = harga;
    }
}
