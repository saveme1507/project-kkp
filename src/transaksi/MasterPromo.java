package transaksi;

import config.Koneksi_1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MasterPromo extends javax.swing.JFrame {

    public MasterPromo() {
        initComponents();
        kategori();
        dataTabel();
//        tx_id.setVisible(false);
        tx_id.setText(String.valueOf(noID()));
    }

    private void kategori() {
        cb_kategori.removeAllItems();
        try {
            String sql = "SELECT nama FROM master_promo_kategori";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            while (rs.next()) {
                cb_kategori.addItem(rs.getString("nama"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int noID() {
        String noAwal = null;
        int noSekarang = 0;
        try {
            String sql = "SELECT MAX(mph_kode) AS sekarang FROM master_promo_header";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            if (rs.next()) {
                noAwal = rs.getString("sekarang");
            }

            if (noAwal == null) {
                noSekarang = 1;
            } else {
                noSekarang = Integer.valueOf(noAwal) + 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return noSekarang;
    }

    private void kosong() {
        tx_id.setText(String.valueOf(noID()));
        tx_harga.setText("");
        tx_namaPromo.setText("");
        cb_kategori.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        model.setRowCount(0);
    }

    private void dataTabel() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        try {
            String sql = "SELECT mph_kode,mph_kategori,mph_nama,mph_harga FROM master_promo_header";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{
                    rs.getString("mph_kode"),
                    rs.getString("mph_kategori"),
                    rs.getString("mph_nama"),
                    rs.getString("mph_harga")
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void tabelDetail() {
        try {
            DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
            model.setRowCount(0);
            String sql = "SELECT mpd_pd_kode,mpd_produk FROM master_promo_detail WHERE mpd_kode=" + tx_id.getText();
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("mpd_pd_kode"),
                    rs.getString("mpd_produk")
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tx_namaPromo = new javax.swing.JTextField();
        tx_harga = new javax.swing.JTextField();
        bt_simpan = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_isiPaket = new javax.swing.JTable();
        cb_kategori = new javax.swing.JComboBox<>();
        tx_id = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bt_kosong = new javax.swing.JButton();
        bt_tambahKtgr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("MASTER PROMO");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAMA PROMO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KATEGORI");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("HARGA");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KODE PROMO", "KATEGORI", "NAMA", "HARGA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        tb_isiPaket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ISI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_isiPaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_isiPaketMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_isiPaket);
        if (tb_isiPaket.getColumnModel().getColumnCount() > 0) {
            tb_isiPaket.getColumnModel().getColumn(0).setResizable(false);
            tb_isiPaket.getColumnModel().getColumn(0).setPreferredWidth(2);
            tb_isiPaket.getColumnModel().getColumn(1).setResizable(false);
        }

        tx_id.setText("id");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jButton1.setText("Tambah Isi Paket");
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ISI PROMO");

        bt_kosong.setText("KOSONG");
        bt_kosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kosongActionPerformed(evt);
            }
        });

        bt_tambahKtgr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        bt_tambahKtgr.setText("Tambah Isi Paket");
        bt_tambahKtgr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_tambahKtgrFocusGained(evt);
            }
        });
        bt_tambahKtgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahKtgrActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_kosong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_hapus))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_tambahKtgr)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(tx_id)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(26, 26, 26)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cb_kategori, 0, 264, Short.MAX_VALUE)
                                                .addComponent(tx_namaPromo)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_namaPromo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_harga))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(tx_id)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_simpan)
                                .addComponent(bt_kosong))
                            .addComponent(bt_hapus))
                        .addGap(147, 147, 147)
                        .addComponent(bt_tambahKtgr, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
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
    }// </editor-fold>//GEN-END:initComponents

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        try {
            String sql = "DELETE FROM master_promo_header WHERE mph_kode = ?";
            PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
            ps.setString(1, tx_id.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            kosong();
            dataTabel();
            bt_simpan.setEnabled(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //token untuk meminta produk
        CariProduk.setTokenPromo(1);
        new CariProduk().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        if (CariProduk.getNama() != null) {
            model.addRow(new Object[]{
                CariProduk.getKode(),
                CariProduk.getNama()
            });
        }
    }//GEN-LAST:event_jButton1FocusGained

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        Boolean header = null, detail = null;
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        if (tx_namaPromo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Masukan Nama Promo");
        } else if (tx_harga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Masukan Harga Promo");
        } else if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Isi Promo Boleh Kosong");
        } else {
            try {
                String sql = "INSERT INTO master_promo_header (mph_kode,mph_kategori,mph_nama,mph_harga,mph_updatedate) VALUES (?,?,?,?,?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tx_id.getText());
                ps.setString(2, cb_kategori.getSelectedItem().toString());
                ps.setString(3, tx_namaPromo.getText());
                ps.setString(4, tx_harga.getText());
                ps.setString(5, config.CurrentDate.tgl_skrg());
                ps.executeUpdate();
                header = true;
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                String sql = "INSERT INTO master_promo_detail(mpd_kode,mpd_pd_kode,mpd_produk) VALUES (?,?,?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                for (int i = 0; i < model.getRowCount(); i++) {
                    ps.setString(1, tx_id.getText());
                    ps.setString(2, model.getValueAt(i, 0).toString());
                    ps.setString(3, model.getValueAt(i, 1).toString());
                    ps.executeUpdate();
                }
                detail = true;
            } catch (Exception e) {
                System.out.println(e);
            }

            if (header == true && detail == true) {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
                kosong();
                dataTabel();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data");
            }
        }


    }//GEN-LAST:event_bt_simpanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       bt_simpan.setEnabled(false);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        tx_id.setText(dtm.getValueAt(row, 0).toString());
        cb_kategori.setSelectedItem(dtm.getValueAt(row, 1).toString());
        tx_namaPromo.setText(dtm.getValueAt(row, 2).toString());
        tx_harga.setText(dtm.getValueAt(row, 3).toString());

        tabelDetail();
    }//GEN-LAST:event_jTable1MouseClicked

    private void tb_isiPaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_isiPaketMouseClicked
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        int row = tb_isiPaket.getSelectedRow();
        String pesan = "Hapus "+model.getValueAt(row, 1).toString()+" ?";
        int jawab = JOptionPane.showOptionDialog(this,
                pesan ,
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (jawab == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM master_promo_detail WHERE mpd_pd_kode=?";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, model.getValueAt(row, 0).toString());
                ps.executeUpdate();
                tabelDetail();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tb_isiPaketMouseClicked

    private void bt_kosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kosongActionPerformed
        kosong();
        bt_simpan.setEnabled(true);
    }//GEN-LAST:event_bt_kosongActionPerformed

    private void bt_tambahKtgrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_tambahKtgrFocusGained
        kategori();
    }//GEN-LAST:event_bt_tambahKtgrFocusGained

    private void bt_tambahKtgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahKtgrActionPerformed
        new KategoriPromo().setVisible(true);
    }//GEN-LAST:event_bt_tambahKtgrActionPerformed

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
            java.util.logging.Logger.getLogger(MasterPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterPromo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_kosong;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambahKtgr;
    private javax.swing.JComboBox<String> cb_kategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tb_isiPaket;
    private javax.swing.JTextField tx_harga;
    private javax.swing.JLabel tx_id;
    private javax.swing.JTextField tx_namaPromo;
    // End of variables declaration//GEN-END:variables
}
