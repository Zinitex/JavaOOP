/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Backup;

import tubes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import tubes.types.Menu;
import java.util.HashMap;
import java.util.Map;
import Lib.formatCurrency;
import tubes.types.Makanan;
import tubes.types.Minuman;

/**
 *
 * @author nanda
 */
public class TUBES extends JFrame {

    private formatCurrency currency = new formatCurrency();
    private JPanel itemPanel, menuPanel, menuButtonPanel, itemButtonPanel;
    private JTable menuItemsTable, itemItemsTable;
    private DefaultTableModel menuModel, itemModel;
    private JScrollPane menuScrollPane, itemScrollPane;
    private JButton menuAddButton, menuAddMultipleButton, itemAddButton, itemAddMultipleButton;

    // Prevent Duplicate Data
    private Map<String, Menu> daftarMenu = new HashMap<>();

    private ArrayList<Menu> items = new ArrayList<>();

    private int screenYSize = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TUBES().setVisible(true);
            }
        });
    }

    public TUBES() {
        setTitle("Pilih Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLayout(new BorderLayout());

        this.initialize();

        // Wrap Inside Static Panel For Easier To manage
        menuPanel = createMenuPanel();
        add(menuPanel, BorderLayout.WEST);
        itemPanel = createItemPanel();
        add(itemPanel, BorderLayout.CENTER);

        menuAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAddItem();
            }
        });
        menuAddMultipleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuMultipleItems();
            }
        });

        itemAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItemsItem();
            }
        });

        itemAddMultipleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemsItem();
            }
        });

        for (Map.Entry<String, Menu> entry : daftarMenu.entrySet()) {
            Menu instance = entry.getValue();
            if(instance.jenisMenu == "Minuman") continue;
            this.addMenuItems(instance);
        }
        for (Map.Entry<String, Menu> entry : daftarMenu.entrySet()) {
            Menu instance = entry.getValue();
            if(instance.jenisMenu == "Makanan") continue;
            this.addMenuItems(instance);
        }

        setVisible(true); // Make sure the frame is visible
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void addMenuItems(Menu menu) {
        menuModel.addRow(new Object[]{menu.namaMenu, currency.format(menu.hargaMenu), menu.descMenu});
    }

    private void registerMenu(Menu menu) {
        this.daftarMenu.put(menu.namaMenu, menu);
    }

    public void initialize() {
        this.registerMenu(new Minuman("Es Teh", 1000, "Enak"));
        this.registerMenu(new Makanan("Sate", 1000, "Enak"));
        this.registerMenu(new Makanan("Acar Ayam", 1000, "Enak"));
        this.registerMenu(new Minuman("Es Jeruk", 1000, "Enak"));
        this.registerMenu(new Makanan("Bakso", 1000, "Enak"));
        this.registerMenu(new Minuman("Jus Apel", 1500, "Segar"));
        this.registerMenu(new Minuman("Es Kelapa", 1200, "Segar"));
        this.registerMenu(new Makanan("Nasi Goreng", 1800, "Pedas"));
        this.registerMenu(new Makanan("Mie Goreng", 1500, "Lezat"));
        this.registerMenu(new Minuman("Es Milo", 1300, "Manis"));
        this.registerMenu(new Makanan("Pecel Lele", 1200, "Pedas"));
        this.registerMenu(new Makanan("Ayam Penyet", 1600, "Lezat"));
        this.registerMenu(new Minuman("Teh Tarik", 1400, "Manis"));
        this.registerMenu(new Makanan("Ikan Bakar", 2000, "Segar"));
        this.registerMenu(new Makanan("Gudeg", 2500, "Manis"));
        this.registerMenu(new Minuman("Es Cendol", 1700, "Segar"));
        this.registerMenu(new Minuman("Teh Manis", 1000, "Manis"));
        this.registerMenu(new Makanan("Tahu Tempe", 1200, "Kriuk"));
        this.registerMenu(new Makanan("Rendang", 3000, "Pedas"));
        this.registerMenu(new Makanan("Gado-Gado", 1800, "Sehat"));
        this.registerMenu(new Makanan("Ayam Bakar", 1700, "Lezat"));
        this.registerMenu(new Minuman("Jus Mangga", 1500, "Segar"));
        this.registerMenu(new Minuman("Es Doger", 1300, "Segar"));
        this.registerMenu(new Makanan("Nasi Uduk", 2000, "Wangi"));
        this.registerMenu(new Makanan("Martabak Manis", 2500, "Manis"));
        this.registerMenu(new Makanan("Siomay", 1500, "Lezat"));
        this.registerMenu(new Makanan("Lontong Sayur", 1200, "Hangat"));
        this.registerMenu(new Minuman("Jus Jeruk", 1400, "Segar"));
        this.registerMenu(new Makanan("Bakmi Naga Resto", 2200, "Lezat"));
        this.registerMenu(new Makanan("Opor Ayam", 2700, "Lezat"));

        System.out.println(daftarMenu.size());
    }

    public JPanel createMenuPanel() {
        menuModel = new DefaultTableModel(new Object[]{"Name", "Price", "Description"}, 0);
        menuItemsTable = new JTable(menuModel);
        menuItemsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuItemsTable.setDefaultEditor(Object.class, null);

        menuScrollPane = new JScrollPane(menuItemsTable);
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu Items"));
        menuPanel.add(menuScrollPane, BorderLayout.CENTER);

        // Add Button at the bottom
        menuButtonPanel = new JPanel();
        menuButtonPanel.setLayout(new FlowLayout());

        menuAddButton = new JButton("Add Item");
        menuAddMultipleButton = new JButton("Add Multiple Items");

        menuButtonPanel.add(menuAddButton);
        menuButtonPanel.add(menuAddMultipleButton);
        menuPanel.add(menuButtonPanel, BorderLayout.SOUTH);

        menuPanel.setPreferredSize(new Dimension(500, 600));

        return menuPanel;
    }

    public JPanel createItemPanel() {
        itemModel = new DefaultTableModel(new Object[]{"Name", "Quantity", "Price", "Subtotal"}, 0);
        itemItemsTable = new JTable(itemModel);
        itemItemsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemItemsTable.setDefaultEditor(Object.class, null);

        itemScrollPane = new JScrollPane(itemItemsTable);
        itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        itemPanel.add(itemScrollPane, BorderLayout.CENTER);

        // Add Button at the bottom
        itemButtonPanel = new JPanel();
        itemButtonPanel.setLayout(new FlowLayout());

        itemAddButton = new JButton("Update Item");
        itemAddMultipleButton = new JButton("Delete Item");

        itemButtonPanel.add(itemAddButton);
        itemButtonPanel.add(itemAddMultipleButton);
        itemPanel.add(itemButtonPanel, BorderLayout.SOUTH);

        return itemPanel;
    }

    private void menuAddItem() {
        int selectedRow = menuItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih menu yang tersedia.");
            return;
        }

        String name = (String) menuItemsTable.getValueAt(selectedRow, 0);
        Menu instance = null;

        for (Map.Entry<String, Menu> entry : daftarMenu.entrySet()) {
            if (entry.getKey().equals(name)) {
                instance = entry.getValue();
                break;
            }
        }

        if (instance == null) {
            JOptionPane.showMessageDialog(this, "Item tidak valid.");
            return;
        }

        boolean itemExists = false;
        for (int row = 0; row < itemModel.getRowCount(); row++) {
            if (itemModel.getValueAt(row, 0).equals(instance.namaMenu)) {
                int currentQuantity = (int) itemModel.getValueAt(row, 1);
                int newQuantity = currentQuantity + 1;
                int price = instance.hargaMenu;
                int newSubtotal = price * newQuantity;

                itemModel.setValueAt(newQuantity, row, 1);
                itemModel.setValueAt(currency.format(newSubtotal), row, 3);
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            itemModel.addRow(new Object[]{instance.namaMenu, 1, currency.format(instance.hargaMenu), currency.format(instance.hargaMenu)});
        }

    }

    private void menuMultipleItems() {
        int selectedRow = menuItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a valid menu item.");
            return;
        }

        String name = (String) menuItemsTable.getValueAt(selectedRow, 0);
        Menu instance = null;

        for (Map.Entry<String, Menu> entry : daftarMenu.entrySet()) {
            if (entry.getKey().equals(name)) {
                instance = entry.getValue();
                break;
            }
        }

        if (instance == null) {
            JOptionPane.showMessageDialog(this, "Item tidak valid.");
            return;
        }

        String quantityText = JOptionPane.showInputDialog(this, "Enter quantity to add:");
        if (quantityText != null && !quantityText.isEmpty()) {
            try {
                int quantityToAdd = Integer.parseInt(quantityText);

                if (quantityToAdd <= 0) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a positive number.");
                    return;
                }

                boolean itemExists = false;
                for (int row = 0; row < itemModel.getRowCount(); row++) {
                    if (itemModel.getValueAt(row, 0).equals(instance.namaMenu)) {
                        int currentQuantity = (int) itemModel.getValueAt(row, 1);
                        int newQuantity = currentQuantity + quantityToAdd;
                        int price = instance.hargaMenu;
                        int newSubtotal = price * newQuantity;

                        itemModel.setValueAt(newQuantity, row, 1);
                        itemModel.setValueAt(currency.format(newSubtotal), row, 3);
                        itemExists = true;
                        break;
                    }
                }
                if (!itemExists) {
                    itemModel.addRow(new Object[]{instance.namaMenu, quantityToAdd, currency.format(instance.hargaMenu), currency.format(quantityToAdd * instance.hargaMenu)});
                }
                menuItemsTable.setSelectionMode(0);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity entered.");
            }
        }

    }

    private void updateItemsItem() {
        int selectedRow = itemItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a valid menu item.");
            return;
        }

        String name = (String) menuItemsTable.getValueAt(selectedRow, 0);
        Menu instance = null;

        for (Map.Entry<String, Menu> entry : daftarMenu.entrySet()) {
            if (entry.getKey().equals(name)) {
                instance = entry.getValue();
                break;
            }
        }

        if (instance == null) {
            JOptionPane.showMessageDialog(this, "Item tidak valid.");
            return;
        }

        String quantityText = JOptionPane.showInputDialog(this, "Enter quantity to add:");
        if (quantityText != null && !quantityText.isEmpty()) {
            try {
                int quantityToAdd = Integer.parseInt(quantityText);

                if (quantityToAdd <= 0) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a positive number.");
                    return;
                }

                int price = instance.hargaMenu;
                int newSubtotal = price * quantityToAdd;

                itemModel.setValueAt(quantityToAdd, selectedRow, 1);
                itemModel.setValueAt(currency.format(newSubtotal), selectedRow, 3);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity entered.");
            }
        }
        
        itemItemsTable.setSelectionMode(0);
    }

    private void deleteItemsItem() {
        int selectedRow = itemItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a valid menu item.");
            return;
        }

        itemItemsTable.setSelectionMode(0);
        itemModel.removeRow(selectedRow);
    }
}
