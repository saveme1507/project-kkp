package transaksi;

import config.Koneksi_1;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MasterPromo extends javax.swing.JFrame {
    private final Connection conn = Koneksi_1.con();
    int  rowCountTbDet;

    public MasterPromo() {
        initComponents();
        kategori();
        dataTabel();
        tx_id.setVisible(false);
        tx_id.setText(noID());
        btSimpanAktif(true);
    }

    private void kategori() {
        cb_kategori.removeAllItems();
        try {
            String sql = "SELECT mpk_nama FROM master_promo_kategori";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            while (rs.next()) {
                cb_kategori.addItem(rs.getString("mpk_nama"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String noID() {
        String noAwal = null;
        String noSekarang = "";
        try {
            String sql = "SELECT COUNT(mph_kode) AS nomer FROM master_promo_header";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            if (rs.next()) {
                noAwal = rs.getString("nomer");
            }

            if (noAwal == null) {
                noSekarang = "P1";
            } else {
                noSekarang = "P"+String.valueOf(Integer.parseInt(noAwal.replace("P", ""))+1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return noSekarang;
    }

    private void kosong() {
        tx_harga.setText("");
        tx_namaPromo.setText("");
        cb_kategori.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        int rowcount = model.getRowCount();
        for (int i = rowcount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        tx_id.setText(noID());
        rowCountTbDet = 0;
        btSimpanAktif(true);
        bt_tambahIsi.setEnabled(true);
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
            settingKolom();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
      public void settingKolom(){
                // lebar kolom
                TableColumn column;
                jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
                column = jTable1.getColumnModel().getColumn(0); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(1); 
                column.setPreferredWidth(120);
                column = jTable1.getColumnModel().getColumn(2); 
                column.setPreferredWidth(280);
                column = jTable1.getColumnModel().getColumn(3); 
                column.setPreferredWidth(62);
                
                // align kolom
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(3).setCellRenderer( rightRenderer );
                
        }

    private void tabelDetail() {
        try {
            DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
            model.setRowCount(0);
            String sql = "SELECT mpd_pd_kode,mpd_produk FROM master_promo_detail WHERE mpd_kode= '"+tx_id.getText()+"'" ;
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
        bt_tambahIsi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bt_kosong = new javax.swing.JButton();
        bt_tambahKtgr = new javax.swing.JButton();
        bt_ubah = new javax.swing.JButton();

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

        tx_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_hargaKeyTyped(evt);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KODE", "KATEGORI", "NAMA", "HARGA"
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

        bt_tambahIsi.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        bt_tambahIsi.setText("Tambah Isi Paket");
        bt_tambahIsi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_tambahIsiFocusGained(evt);
            }
        });
        bt_tambahIsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahIsiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ISI PROMO");

        bt_kosong.setText("BERSIHKAN");
        bt_kosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kosongActionPerformed(evt);
            }
        });

        bt_tambahKtgr.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        bt_tambahKtgr.setText("Tambah Kategori");
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

        bt_ubah.setText("UBAH");
        bt_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ubahActionPerformed(evt);
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_tambahKtgr)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(tx_id)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bt_tambahIsi))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cb_kategori, 0, 264, Short.MAX_VALUE)
                                                .addComponent(tx_namaPromo)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bt_kosong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bt_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
                            .addComponent(bt_tambahIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(tx_id)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_simpan)
                            .addComponent(bt_hapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_ubah)
                            .addComponent(bt_kosong))
                        .addGap(109, 109, 109)
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
        setLocationRelativeTo(null);
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

    private void bt_tambahIsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahIsiActionPerformed
        //token untuk meminta produk
        CariProduk.setTokenPromo(1);
        new CariProduk().setVisible(true);
    }//GEN-LAST:event_bt_tambahIsiActionPerformed

    private void bt_tambahIsiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_tambahIsiFocusGained
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        if (CariProduk.getNama() != null) {
            model.addRow(new Object[]{
                CariProduk.getKode(),
                CariProduk.getNama()
            });
            CariProduk.setTokenPromo(0);
            CariProduk.setKode(null);
            CariProduk.setNama(null);
            if(model.getRowCount() == rowCountTbDet){
                bt_tambahIsi.setEnabled(false);
            }
        }
    }//GEN-LAST:event_bt_tambahIsiFocusGained

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        boolean sessionHeader = false, sessionDetail = false;
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        
        if (tx_namaPromo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Masukan Nama Promo");
        } else if (tx_harga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Masukan Harga Promo");
        } else if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Isi Promo Boleh Kosong");
        } else {
            try {
                conn.setAutoCommit(false);
                
                // insert header promo
                String sql = "INSERT INTO master_promo_header (mph_kode,mph_kategori,mph_nama,mph_harga,mph_updatedate) VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tx_id.getText());
                ps.setString(2, cb_kategori.getSelectedItem().toString());
                ps.setString(3, tx_namaPromo.getText());
                ps.setString(4, tx_harga.getText());
                ps.setString(5, config.CurrentDate.tgl_skrg());
                ps.executeUpdate();
                sessionHeader = true;
                
                // insert detail promo
                String sql2 = "INSERT INTO master_promo_detail(mpd_kode,mpd_pd_kode,mpd_produk) VALUES (?,?,?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                for (int i = 0; i < model.getRowCount(); i++) {
                    ps2.setString(1, tx_id.getText());
                    ps2.setString(2, model.getValueAt(i, 0).toString());
                    ps2.setString(3, model.getValueAt(i, 1).toString());
                    ps2.executeUpdate();
                }
                sessionDetail = true;
                
                if(sessionHeader && sessionDetail == true){
                    conn.commit();
                    dataTabel();
                    kosong();
                }else{
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan simpan data");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }        
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btSimpanAktif(false);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        tx_id.setText(dtm.getValueAt(row, 0).toString());
        cb_kategori.setSelectedItem(dtm.getValueAt(row, 1).toString());
        tx_namaPromo.setText(dtm.getValueAt(row, 2).toString());
        tx_harga.setText(dtm.getValueAt(row, 3).toString());

        tabelDetail();
        bt_tambahIsi.setEnabled(false);
        rowCountTbDet = tb_isiPaket.getModel().getRowCount();
        System.out.println(String.valueOf(rowCountTbDet));
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
           model.removeRow(row);
           bt_tambahIsi.setEnabled(true);
        }
    }//GEN-LAST:event_tb_isiPaketMouseClicked

    private void bt_kosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kosongActionPerformed
        kosong();
        btSimpanAktif(true);
    }//GEN-LAST:event_bt_kosongActionPerformed

    private void bt_tambahKtgrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_tambahKtgrFocusGained
        kategori();
    }//GEN-LAST:event_bt_tambahKtgrFocusGained

    private void bt_tambahKtgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahKtgrActionPerformed
        new KategoriPromo().setVisible(true);
    }//GEN-LAST:event_bt_tambahKtgrActionPerformed

    private void tx_hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_hargaKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_hargaKeyTyped

    private void bt_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ubahActionPerformed
        boolean sessionHeader = false, sessionDetail = false;
        DefaultTableModel model = (DefaultTableModel) tb_isiPaket.getModel();
        
        if (tx_namaPromo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Masukan Nama Promo");
        } else if (tx_harga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mohon Masukan Harga Promo");
        } else if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Isi Promo Boleh Kosong");
        } else {
            try {
                conn.setAutoCommit(false);
                
                // update header promo
                String sql = "UPDATE master_promo_header SET mph_kategori=? ,mph_nama=? ,mph_harga=? ,mph_updatedate=? WHERE mph_kode=? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(5, tx_id.getText());
                ps.setString(1, cb_kategori.getSelectedItem().toString());
                ps.setString(2, tx_namaPromo.getText());
                ps.setString(3, tx_harga.getText());
                ps.setString(4, config.CurrentDate.tgl_skrg());
                ps.executeUpdate();
                sessionHeader = true;
                
                // update detail promo
                String sql2 = "UPDATE master_promo_detail SET mpd_pd_kode=? ,mpd_produk=? WHERE mpd_kode=?";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                for (int i = 0; i < model.getRowCount(); i++) {
                    ps2.setString(3, tx_id.getText());
                    ps2.setString(1, model.getValueAt(i, 0).toString());
                    ps2.setString(2, model.getValueAt(i, 1).toString());
                    ps2.executeUpdate();
                }
                sessionDetail = true;
                
                if(sessionHeader && sessionDetail == true){
                    conn.commit();
                    JOptionPane.showMessageDialog(this, "Ubah data berhasil");
                    dataTabel();
                    kosong();
                }else{
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan simpan data");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }        
        }
    }//GEN-LAST:event_bt_ubahActionPerformed

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
    private javax.swing.JButton bt_tambahIsi;
    private javax.swing.JButton bt_tambahKtgr;
    private javax.swing.JButton bt_ubah;
    private javax.swing.JComboBox<String> cb_kategori;
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
    
    private void btSimpanAktif(boolean aktif){
        bt_simpan.setEnabled(aktif);
        bt_hapus.setEnabled(!aktif);
        bt_ubah.setEnabled(!aktif);
    }

}
