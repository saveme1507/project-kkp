package transaksi;

import config.CurrentDate;
import config.Koneksi_1;
import config.Koneksi_2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MasterProduk extends javax.swing.JFrame {

    private DefaultTableModel tabMode;

    public MasterProduk() {
        initComponents();
        tx_id.setVisible(false);
        datatabel();
    }

    private void datatabel() {
        Object[] Baris = {"Kode", "Nama", "Satuan", "Harga", "Update"};
        tabMode = new DefaultTableModel(null, Baris);
        jtable.setModel(tabMode);
        try {
            String sql = "SELECT * FROM produk";
            ResultSet hasil = Koneksi_1.con_stat().executeQuery(sql);
            while (hasil.next()) {
                tabMode.addRow(new Object[]{
                    hasil.getString("pd_kode"),
                    hasil.getString("pd_nama"),
                    hasil.getString("pd_satuan"),
                    hasil.getString("pd_harga"),
                    hasil.getString("pd_updatedate")
                });
            }
            jtable.setModel(tabMode);
        } catch (SQLException e) {
            System.out.println("error :" + e);
        }
    }

    private void kosong() {
        tx_nama.setText("");
        tx_harga.setText("");
        cb_satuan.setSelectedIndex(0);
        tx_id.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tx_nama = new javax.swing.JTextField();
        tx_harga = new javax.swing.JTextField();
        cb_satuan = new javax.swing.JComboBox<>();
        bt_batal = new javax.swing.JButton();
        bt_simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        tx_id = new javax.swing.JLabel();
        bt_hapus = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("MASTER PRODUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAMA PRODUK");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SATUAN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("HARGA");

        cb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porsi", "Buah", "Potong", "Sendok" }));

        bt_batal.setBackground(new java.awt.Color(255, 255, 255));
        bt_batal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_batal.setText("KOSONG");
        bt_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_batalActionPerformed(evt);
            }
        });

        bt_simpan.setBackground(new java.awt.Color(255, 255, 255));
        bt_simpan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_simpan.setText("SIMPAN");
        bt_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_simpanMouseClicked(evt);
            }
        });
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        jtable.setBackground(new java.awt.Color(255, 255, 255));
        jtable.setForeground(new java.awt.Color(51, 51, 51));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        if (jtable.getColumnModel().getColumnCount() > 0) {
            jtable.getColumnModel().getColumn(0).setResizable(false);
            jtable.getColumnModel().getColumn(1).setResizable(false);
            jtable.getColumnModel().getColumn(3).setResizable(false);
        }

        bt_hapus.setBackground(new java.awt.Color(255, 255, 255));
        bt_hapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_hapus.setText("HAPUS");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_edit.setBackground(new java.awt.Color(255, 255, 255));
        bt_edit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_edit.setText("EDIT");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_harga)
                                    .addComponent(cb_satuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_id)
                                    .addComponent(tx_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bt_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tx_id)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tx_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tx_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_simpanMouseClicked
        if (tx_nama.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nama produk tidak boleh kosong");
        } else if (tx_harga.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Harga tidak boleh kosong");
        } else {
            try {
                String sql = "INSERT INTO produk(pd_nama,pd_satuan,pd_harga,pd_updatedate) VALUES (?,?,?,?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tx_nama.getText());
                ps.setString(2, cb_satuan.getSelectedItem().toString());
                ps.setString(3, tx_harga.getText());
                ps.setString(4, CurrentDate.tgl_skrg());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil di simpan");
                kosong();
                datatabel();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error menyimpan data");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_bt_simpanMouseClicked

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        int row = jtable.getSelectedRow();
        tx_id.setText(model.getValueAt(row, 0).toString());
        tx_nama.setText(model.getValueAt(row, 1).toString());
        tx_harga.setText(model.getValueAt(row, 3).toString());
        if (model.getValueAt(row, 2).toString().equalsIgnoreCase("porsi")) {
            cb_satuan.setSelectedIndex(0);
        } else if (model.getValueAt(row, 2).toString().equalsIgnoreCase("buah")) {
            cb_satuan.setSelectedIndex(1);
        } else if (model.getValueAt(row, 2).toString().equalsIgnoreCase("potong")) {
            cb_satuan.setSelectedIndex(2);
        } else if (model.getValueAt(row, 2).toString().equalsIgnoreCase("sendok")) {
            cb_satuan.setSelectedIndex(3);
        }

        bt_simpan.setEnabled(false);
    }//GEN-LAST:event_jtableMouseClicked

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        try {
            String sql = "DELETE FROM produk WHERE pd_kode=?";
            PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
            ps.setString(1, tx_id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil di hapus");
            kosong();
            datatabel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error menghapus data");
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        if (tx_nama.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nama produk tidak boleh kosong");
        } else if (tx_harga.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Harga tidak boleh kosong");
        } else {
            try {
                String sql = "UPDATE produk SET pd_nama=?,pd_satuan=?,pd_harga=?,pd_updatedate=? WHERE pd_kode=?";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tx_nama.getText());
                ps.setString(2, cb_satuan.getSelectedItem().toString());
                ps.setString(3, tx_harga.getText());
                ps.setString(4, config.CurrentDate.tgl_skrg());
                ps.setString(5, tx_id.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil di edit");
                kosong();
                datatabel();
                bt_simpan.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error mengedit data");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_batalActionPerformed
        kosong();
        bt_simpan.setEnabled(true);
    }//GEN-LAST:event_bt_batalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasterProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_batal;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JComboBox<String> cb_satuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField tx_harga;
    private javax.swing.JLabel tx_id;
    private javax.swing.JTextField tx_nama;
    // End of variables declaration//GEN-END:variables

//    private void backup(String action){
//        try {
//            //input backup
//            String b_sql = "INSERT INTO back_produk(pd_nama,pd_satuan,pd_harga,pd_updatedate,pd_action) VALUES (?,?,?,?,?)";
//            PreparedStatement bps = Koneksi_2.con().prepareStatement(b_sql);
//            bps.setString(1, tx_nama.getText());
//            bps.setString(2, cb_satuan.getSelectedItem().toString());
//            bps.setString(3, tx_harga.getText().toString());
//            bps.setString(4, CurrentDate.tgl_skrg());
//            bps.setString(5, action);
//            bps.executeUpdate();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error menyimpan data 2");
//            System.out.println(e);
//        }
//    }
}
