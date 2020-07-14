package transaksi;

import config.Koneksi_1;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CariProduk extends javax.swing.JFrame {

    private DefaultTableModel tabMode;
    public static String kode;
    public static String nama;
    public static String harga;
    public static int tokenPromo;
    Transaksi t = new Transaksi();

    public CariProduk() {
        initComponents();
        datatabel();
        if(getTokenPromo() == 1){
            bt_cari.setVisible(false);
            bt_normal.setVisible(false);
            bt_promo.setVisible(false);
            tx_cari.setVisible(false);
        }
    }
    
     private void datatabel() {
        Object[] Baris = {"Kode", "Nama",  "Harga", "Stok"};
        tabMode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabMode);
        try {
            String sql = "SELECT * FROM produk WHERE pd_nama LIKE '%" + tx_cari.getText() + "%'";
            ResultSet hasil = Koneksi_1.con_stat().executeQuery(sql);
            while (hasil.next()) {
                tabMode.addRow(new Object[]{
                    hasil.getString("pd_kode"),
                    hasil.getString("pd_nama"),
                    hasil.getString("pd_harga"),
                    hasil.getString("pd_stock")});
            }
            jTable1.setModel(tabMode);
            settingKolom();
        } catch (SQLException e) {
            System.out.println("error :" + e);
        }
    }
     
      private void tabelPromo() {
        Object[] Baris = {"Kode", "Nama", "Harga", "Isi"};
        tabMode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabMode);
        String isi="";
        try {
            String sql = "SELECT mph_kode, mph_kategori, mph_nama,mph_harga FROM master_promo_header";
            ResultSet hasil = Koneksi_1.con_stat().executeQuery(sql);
            while (hasil.next()) {
                String sql2 = "SELECT mpd_produk FROM master_promo_detail WHERE mpd_kode='"+hasil.getString("mph_kode")+"'";
                ResultSet rs = Koneksi_1.con_stat().executeQuery(sql2);
                while (rs.next()){
                    isi = rs.getString("mpd_produk")+", ";
                }
                tabMode.addRow(new Object[]{
                    hasil.getString("mph_kode"),
                    hasil.getString("mph_kategori")+" "+hasil.getString("mph_nama"),
                    hasil.getString("mph_harga"),
                    isi
                    });
            }
            jTable1.setModel(tabMode);
            settingKolom();
        } catch (SQLException e) {
            System.out.println("error :" + e);
        }
    }
      
        public void settingKolom(){
                // lebar kolom
                TableColumn column;
                jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
                column = jTable1.getColumnModel().getColumn(0); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(1); 
                column.setPreferredWidth(422);
                column = jTable1.getColumnModel().getColumn(2); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(3); 
                column.setPreferredWidth(60);
                
                // align kolom
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(2).setCellRenderer( rightRenderer );
                
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tx_cari = new javax.swing.JTextField();
        bt_cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt_promo = new javax.swing.JButton();
        bt_normal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        tx_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_cariKeyPressed(evt);
            }
        });

        bt_cari.setText("CARI");
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "KODE PRODUK", "NAMA PRODUK", "QTY", "HARGA", "Stok"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
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
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(2);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        bt_promo.setText("PROMO");
        bt_promo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_promoActionPerformed(evt);
            }
        });

        bt_normal.setText("NORMAL");
        bt_normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_normalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tx_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_normal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_promo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_promo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
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

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        // TODO add your handling code here:
        datatabel();
    }//GEN-LAST:event_bt_cariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int bar = jTable1.getSelectedRow();
        String a = tabMode.getValueAt(bar, 0).toString();
        String b = tabMode.getValueAt(bar, 1).toString();
        String c = tabMode.getValueAt(bar, 2).toString();
        String d = tabMode.getValueAt(bar, 3).toString();
        
        if (! d.equals("0")) {  //kirim ke transaksi
            setKode(a);
            setNama(b);
            setHarga(c);
            setVisible(false);
            transferFocus();
        } else if(CariProduk.getTokenPromo() == 1) { //kirim ke master promo
            setKode(a);
            setNama(b);
            setHarga(c);
            setVisible(false);
            transferFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Produk sudah habis !");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void tx_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_cariKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatabel();
        }
    }//GEN-LAST:event_tx_cariKeyPressed

    private void bt_promoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_promoActionPerformed
        tabelPromo();
        tx_cari.setVisible(false);
        bt_cari.setVisible(false);
    }//GEN-LAST:event_bt_promoActionPerformed

    private void bt_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_normalActionPerformed
        datatabel();
        tx_cari.setVisible(true);
        bt_cari.setVisible(true);
    }//GEN-LAST:event_bt_normalActionPerformed

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
            java.util.logging.Logger.getLogger(CariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_normal;
    private javax.swing.JButton bt_promo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tx_cari;
    // End of variables declaration//GEN-END:variables

   

    public static String getKode() {
        return kode;
    }

    public static void setKode(String kode) {
        CariProduk.kode = kode;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        CariProduk.nama = nama;
    }

    public static String getHarga() {
        return harga;
    }

    public static void setHarga(String harga) {
        CariProduk.harga = harga;
    }

    public static int getTokenPromo() {
        return tokenPromo;
    }

    public static void setTokenPromo(int tokenPromo) {
        CariProduk.tokenPromo = tokenPromo;
    }
}
