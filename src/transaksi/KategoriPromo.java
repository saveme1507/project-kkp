package transaksi;

import config.Koneksi_1;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class KategoriPromo extends javax.swing.JFrame {

    public KategoriPromo() {
        initComponents();
        datatabel();
        tx_id.setVisible(false);
        btSimpanAktif(true);
    }

    private void datatabel() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            String sql = "SELECT * FROM master_promo_kategori";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("mpk_id"),
                    rs.getString("mpk_nama")
                });
            }
            settingKolom();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
      public void settingKolom(){
                // lebar kolom
                TableColumn column;
                jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
                column = jTable1.getColumnModel().getColumn(0); 
                column.setPreferredWidth(40);
                column = jTable1.getColumnModel().getColumn(1); 
                column.setPreferredWidth(200);
                // align kolom
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                 
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tx_kategori = new javax.swing.JTextField();
        tx_id = new javax.swing.JLabel();
        bt_simpan = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        btClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "KATEGORI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        tx_kategori.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx_kategoriFocusGained(evt);
            }
        });

        bt_simpan.setText("SIMPAN");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        bt_hapus.setText("HAPUS");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_edit.setText("UBAH");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        btClear.setText("BERSIHKAN");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tx_kategori)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tx_id)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_simpan))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tx_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_simpan)
                            .addComponent(bt_hapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_edit)
                            .addComponent(btClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tx_id)))
                .addContainerGap())
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        tx_id.setText(model.getValueAt(row, 0).toString());
        tx_kategori.setText(model.getValueAt(row, 1).toString());
        btSimpanAktif(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        if(!tx_kategori.getText().isEmpty()){
            try {
                String sql = "UPDATE master_promo_kategori SET mpk_nama=? WHERE mpk_id=?";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tx_kategori.getText());
                ps.setString(2, tx_id.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil diedit");
                datatabel();
                tx_kategori.setText("");
                btSimpanAktif(true);
            } catch (HeadlessException | SQLException e) {
                System.out.println(e);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Kolom kategori tidak boleh kosong");
        }
        
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        try {
            String sql = "DELETE FROM master_promo_kategori WHERE mpk_id=?";
            PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
            ps.setString(1, tx_id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            datatabel();
            tx_kategori.setText("");
            btSimpanAktif(true);
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        if(!tx_kategori.getText().isEmpty()){
            try {
                String sql = "INSERT INTO master_promo_kategori (mpk_nama) VALUES (?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tx_kategori.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
                datatabel();
                tx_kategori.setText("");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan / Data duplikat");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Kolom kategori tidak boleh kosong");
        }
       
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void tx_kategoriFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_kategoriFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_kategoriFocusGained

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        tx_kategori.setText("");
        btSimpanAktif(true);
    }//GEN-LAST:event_btClearActionPerformed

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
            java.util.logging.Logger.getLogger(KategoriPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KategoriPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KategoriPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KategoriPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KategoriPromo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tx_id;
    private javax.swing.JTextField tx_kategori;
    // End of variables declaration//GEN-END:variables
    private void btSimpanAktif(boolean aktif){
        bt_simpan.setEnabled(aktif);
        bt_edit.setEnabled(!aktif);
        bt_hapus.setEnabled(!aktif);
    }
}
