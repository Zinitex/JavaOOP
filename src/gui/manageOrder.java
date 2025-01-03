/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.formatter;
import tubes.TUBES;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import lib.database;

/**
 *
 * @author nanda
 */
public class manageOrder extends javax.swing.JFrame {

    PreparedStatement st;
    private mainMenu parent;
    private DefaultTableModel tableOrderModel;

    /**
     * Creates new form manageOrder
     */
    public manageOrder(mainMenu parent) {
        if (!TUBES.akun.getRole().matches("admin")) {
            JOptionPane.showMessageDialog(this, "Akses ditolak. Hanya admin yang dapat mengakses menu ini.", "Error", JOptionPane.ERROR_MESSAGE);
            new mainMenu().setVisible(true);
            dispose();
            return;
        }

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
        jTable1 = new javax.swing.JTable();
        btnReturn = new javax.swing.JButton();
        btnUpdateStatus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Customer", "Tanggal", "Jumlah Item", "Status", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        btnReturn.setText("←");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnUpdateStatus.setText("Update Status");
        btnUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdateStatus)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnUpdateStatus)
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        this.setVisible(false);
        new mainMenu().setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih pesanan yang ingin diperbarui.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int orderId = (int) tableOrderModel.getValueAt(selectedRow, 0);
        String[] statuses = {"processed", "delivered", "cancelled"};
        String newStatus = (String) JOptionPane.showInputDialog(
                this,
                "Pilih status baru:",
                "Update Status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                statuses,
                statuses[0]
        );

        if (newStatus == null || newStatus.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Status tidak diperbarui.");
            return;
        }

        try {
            st = database.getConnection().prepareStatement("UPDATE pemesanan SET status = ? WHERE id = ?");
            st.setString(1, newStatus);
            st.setInt(2, orderId);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                tableOrderModel.setValueAt(formatter.capitalText(newStatus), selectedRow, 4);
                JOptionPane.showMessageDialog(this, "Status pesanan berhasil diperbarui.");
            } else {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui status pesanan.");
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui status pesanan.");
        }
    }//GEN-LAST:event_btnUpdateStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUpdateStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void init() {
        tableOrderModel = (DefaultTableModel) jTable1.getModel();
        tableOrderModel.setRowCount(0);

        try {
            // Query to fetch all orders with customer name
            String query = """
    SELECT 
        p.id AS order_id,
        u.name AS customer, 
        p.tanggal, 
        p.status, 
        (SELECT COUNT(*) FROM detailpemesanan WHERE pemesanan_id = p.id) AS total_items,
        (SELECT SUM(dp.jumlah * m.harga) 
            FROM detailpemesanan dp 
            JOIN menu m ON dp.menu_id = m.id 
            WHERE dp.pemesanan_id = p.id) AS total_price
    FROM 
        pemesanan p
    JOIN 
        users u ON p.user_id = u.id
    ORDER BY 
        CASE 
            WHEN p.status = 'processed' THEN 1
            WHEN p.status = 'delivered' THEN 2
            WHEN p.status = 'canceled' THEN 3
            ELSE 4
        END, 
        p.tanggal DESC;
    """;
            Statement st = database.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                tableOrderModel.addRow(new Object[]{
                    rs.getInt("order_id"), // Order ID
                    rs.getString("customer"), // Customer name
                    rs.getTimestamp("tanggal"), // Order date
                    rs.getInt("total_items"), // Total items
                    formatter.capitalText(rs.getString("status")), // Status (formatted)
                    formatter.currency(rs.getInt("total_price")) // Total price (formatted)
                });
            }

            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
                jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memuat data pesanan.");
        }
    }
}
