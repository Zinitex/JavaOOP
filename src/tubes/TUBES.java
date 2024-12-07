/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import tubes.core.Pemesanan;
import tubes.types.Menu;
import java.util.HashMap;
import java.util.Map;
import tubes.types.Makanan;
import tubes.types.Minuman;

/**
 *
 * @author nanda
 */
public class TUBES {

    public static void main(String[] args) {

//        Map<String, Menu> daftarMenu = new HashMap<>();
//
//        Pemesanan pemesanan = new Pemesanan();
//
//        Makanan menu1 = new Makanan("Sate", 10000, "Enak");
//        Makanan menu2 = new Makanan("Bakso", 10000, "Enak");
//        Makanan menu3 = new Makanan("Nasi Goreng", 10000, "Enak");
//
//        Minuman menu4 = new Minuman("Es Teh", 10000, "Enak");
//        Minuman menu5 = new Minuman("Es Jeruk", 10000, "Enak");
//        Minuman menu6 = new Minuman("Air Es", 10000, "Enak");
//
//        pemesanan.addPesanan(menu3);
//        pemesanan.addPesanan(menu2);
//        pemesanan.addPesanan(menu3);
//        pemesanan.addPesanan(menu1);
//        pemesanan.addPesanan(menu4);
//        pemesanan.addPesanan(menu4);
//        pemesanan.addPesanan(menu5);
//
//        pemesanan.tampilPesanan();
//        pemesanan.jumlahHarga();
        JFrame myFrame = new JFrame("Pilih Menu");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);
        myFrame.setLayout(new BorderLayout());

        /// Wrap Inside Static Panel For Easier To manage
        JPanel menuPanel = createMenuPanel();
        myFrame.add(menuPanel, BorderLayout.WEST);
        
        JPanel itemPanel = createItemPanel();
        myFrame.add(itemPanel, BorderLayout.CENTER);

        myFrame.setVisible(true);

    }

    public static JPanel createMenuPanel() {
        DefaultTableModel menuModel = new DefaultTableModel(new Object[]{"Name", "Price", "Description"}, 0);
        JTable menuItemTable = new JTable(menuModel);
        menuItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuItemTable.setDefaultEditor(Object.class, null);

        JScrollPane menuScrollPane = new JScrollPane(menuItemTable);
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu Items"));
        menuPanel.add(menuScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        /// Add Button at the bottom
        
        JButton addButton = new JButton("Add Item");
        JButton addMultipleButton = new JButton("Add Multiple Items");
        
        buttonPanel.add(addButton);
        buttonPanel.add(addMultipleButton);
        menuPanel.add(buttonPanel, BorderLayout.SOUTH);

        return menuPanel;
    }

    public static JPanel createItemPanel() {
        DefaultTableModel panel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Price", "Subtotal"}, 0);
        JTable itemTable = new JTable(panel);
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemTable.setDefaultEditor(Object.class, null);

        JScrollPane itemScrollPane = new JScrollPane(itemTable);
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        itemPanel.add(itemScrollPane, BorderLayout.CENTER);

        return itemPanel;
    }

}
