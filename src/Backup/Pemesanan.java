/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backup;

import tubes.types.Menu;
import java.util.ArrayList;

/**
 *
 * @author nanda
 */
public class Pemesanan {

    ArrayList<Menu> masakan = new ArrayList<>();
    int harga = 0;

    public void addPesanan(Menu menu) {
        for (Menu m : masakan){
            if (m.namaMenu.equals(menu.namaMenu)) {
                m.jumlahMenu += menu.jumlahMenu;
                System.out.println(menu.namaMenu + " quantity updated to " + m.jumlahMenu);
                return;
            }
        }
        masakan.add(menu);
    }
    
    public void tampilPesanan() {
        int i = 1;
        for (Menu m : masakan) {
            System.out.println(String.format("%s. %s\t\t%s\t\t%s\t\t%sx", i++, m.namaMenu,m.jenisMenu, m.hargaMenu, m.jumlahMenu));
        }
        System.out.println(String.format("\nTotal Harga: Rp.%d", this.jumlahHarga()));
    }

    public int jumlahHarga() {
        int totalHarga = 0;
        for (Menu m : masakan) {
            totalHarga += (m.hargaMenu * m.jumlahMenu);
        }
        return totalHarga;
    }
}
