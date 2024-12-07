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
public class TUBES extends JFrame {

    private JPanel itemPanel, menuPanel, menuButtonPanel, itemButtonPanel;
    private JTable menuItemTable, itemTable;
    private DefaultTableModel menuModel, itemModel;
    private JScrollPane menuScrollPane, itemScrollPane;

    private JButton menuAddButton, menuAddMultipleButton, itemAddButton, itemAddMultipleButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TUBES().setVisible(true);
            }
        });
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

    }

    public TUBES() {
        setTitle("Pilih Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLayout(new BorderLayout());
        
        /// Move App screen to middle
//        setLocationRelativeTo(null);

        // Wrap Inside Static Panel For Easier To manage
        menuPanel = createMenuPanel();
        add(menuPanel, BorderLayout.WEST);

        itemPanel = createItemPanel();
        add(itemPanel, BorderLayout.CENTER);

        setVisible(true); // Make sure the frame is visible
    }

    public JPanel createMenuPanel() {
        menuModel = new DefaultTableModel(new Object[]{"Name", "Price", "Description"}, 0);
        menuItemTable = new JTable(menuModel);
        menuItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuItemTable.setDefaultEditor(Object.class, null);

        menuScrollPane = new JScrollPane(menuItemTable);
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu Items"));
        menuPanel.add(menuScrollPane, BorderLayout.CENTER);

        /// Add Button at the bottom
        menuButtonPanel = new JPanel();
        menuButtonPanel.setLayout(new FlowLayout());

        menuAddButton = new JButton("Add Item");
        menuAddMultipleButton = new JButton("Add Multiple Items");

        menuButtonPanel.add(menuAddButton);
        menuButtonPanel.add(menuAddMultipleButton);
        menuPanel.add(menuButtonPanel, BorderLayout.SOUTH);

        return menuPanel;
    }

    public JPanel createItemPanel() {
        itemModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Price", "Subtotal"}, 0);
        itemTable = new JTable(itemModel);
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemTable.setDefaultEditor(Object.class, null);

        itemScrollPane = new JScrollPane(itemTable);
        itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        itemPanel.add(itemScrollPane, BorderLayout.CENTER);

        /// Add Button at the bottom
        itemButtonPanel = new JPanel();
        itemButtonPanel.setLayout(new FlowLayout());

        itemAddButton = new JButton("Add Item");
        itemAddMultipleButton = new JButton("Add Multiple Items");

        itemButtonPanel.add(itemAddButton);
        itemButtonPanel.add(itemAddMultipleButton);
        itemPanel.add(itemButtonPanel, BorderLayout.SOUTH);

        return itemPanel;
    }

}
