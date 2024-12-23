/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lib.database;
import lib.formatter;
import models.menu;
import models.orderDetail;
import tubes.TUBES;
import static tubes.TUBES.akun;

/**
 *
 * @author nanda
 */
public class historyOrder extends javax.swing.JFrame {

    PreparedStatement st;
    private mainMenu parent;
    private DefaultTableModel tableHistoryModel;

    /**
     * Creates new form historyOrder
     */
    public historyOrder(mainMenu parent) {
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "Jumlah Item", "Status", "Total", "Jumlah Jenis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHistory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHistory;
    // End of variables declaration//GEN-END:variables

    private void init() {
        tableHistoryModel = (DefaultTableModel) tableHistory.getModel();
        try {
            // Combined query to fetch pemesanan and related details
            String query = """
                SELECT 
                    p.id AS pemesanan_id,
                    p.tanggal,
                    p.status,
                    m.id AS menu_id,
                    m.harga AS menu_harga,
                    dp.jumlah AS menu_quantity
                FROM 
                    pemesanan p
                JOIN 
                    detailpemesanan dp ON p.id = dp.pemesanan_id
                JOIN 
                    menu m ON dp.menu_id = m.id
                WHERE 
                    p.user_id = ?;
            """;

            PreparedStatement st = database.getConnection().prepareStatement(query);
            st.setInt(1, akun.getId());
            ResultSet rs = st.executeQuery();

            Map<Integer, orderDetail> orderDetailMap = new HashMap<>();

            while (rs.next()) {
                int orderId = rs.getInt("pemesanan_id");
                Date date = rs.getDate("tanggal");
                String status = rs.getString("status");
                int menuPrice = rs.getInt("menu_harga");
                int menuQuantity = rs.getInt("menu_quantity");

                orderDetail detail = orderDetailMap.getOrDefault(
                        orderId,
                        new orderDetail(orderId, date, status)
                );
                detail.addMenu(menuPrice, menuQuantity);
                orderDetailMap.put(orderId, detail);
            }

            for (orderDetail detail : orderDetailMap.values()) {
                tableHistoryModel.addRow(new Object[]{
                    detail.getDate(),
                    detail.getItemCount(),
                    detail.getStatus(),
                    detail.getTotalPrice()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
