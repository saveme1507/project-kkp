package transaksi;

import config.CurrentDate;
import config.ItemBahan;
import config.ItemLapHarian;
import config.Koneksi_1;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class BahanBaku extends javax.swing.JFrame {
    DecimalFormat df = new DecimalFormat("Rp ###,###,###");
    private DefaultTableModel tabMode;
    ArrayList<String> arrayId = new ArrayList<>();

    public BahanBaku() {
        initComponents();
        labId.setVisible(false);
        btHitung.setVisible(false);
        aktifSimpan(true);
        datatabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btSimpanItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItem = new javax.swing.JTable();
        jpUbahItem = new javax.swing.JPanel();
        tfNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btSimpan = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        btBersihkan = new javax.swing.JButton();
        btUbah = new javax.swing.JButton();
        labId = new javax.swing.JLabel();
        btHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("PEMBALIAN BAHAN BAKU");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(257, 257, 257))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btSimpanItem.setText("SIMPAN");
        btSimpanItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanItemActionPerformed(evt);
            }
        });

        tableItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemMouseClicked(evt);
            }
        });
        tableItem.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tableItemCaretPositionChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tableItem);

        jpUbahItem.setForeground(new java.awt.Color(0, 51, 153));

        jLabel2.setText("Nama Item");

        tfHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfHargaKeyTyped(evt);
            }
        });

        jLabel3.setText("Harga Normal");

        btSimpan.setText("SIMPAN");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        btHapus.setText("HAPUS");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        btBersihkan.setText("BERSIHKAN");
        btBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBersihkanActionPerformed(evt);
            }
        });

        btUbah.setText("UBAH");
        btUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUbahItemLayout = new javax.swing.GroupLayout(jpUbahItem);
        jpUbahItem.setLayout(jpUbahItemLayout);
        jpUbahItemLayout.setHorizontalGroup(
            jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUbahItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUbahItemLayout.createSequentialGroup()
                        .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(labId))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpUbahItemLayout.createSequentialGroup()
                        .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHarga)
                            .addComponent(tfNama)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUbahItemLayout.createSequentialGroup()
                                .addGap(0, 133, Short.MAX_VALUE)
                                .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btBersihkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jpUbahItemLayout.setVerticalGroup(
            jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUbahItemLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labId)
                .addGap(2, 2, 2)
                .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpan)
                    .addComponent(btBersihkan))
                .addGap(18, 18, 18)
                .addGroup(jpUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btHapus)
                    .addComponent(btUbah))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btHitung.setText("HITUNG");
        btHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btHitung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSimpanItem))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpUbahItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jpUbahItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimpanItem)
                    .addComponent(btHitung))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableItem.getModel();
        try {
            ArrayList itemList = new ArrayList();
            itemList.clear();
            int no = 1,total=0,jml=0;
            for (int i = 0; i < model.getRowCount(); i++) {
                total = convertInt(model.getValueAt(i, 1).toString())*convertInt( model.getValueAt(i, 2).toString());
                jml += total;
                ItemBahan itemBahan = new ItemBahan(
                        String.valueOf(no++),
                        model.getValueAt(i, 0).toString(),
                        String.valueOf(convertInt(model.getValueAt(i, 2).toString())),
                        itemLap( model.getValueAt(i, 1).toString()),
                        df.format(total)
                );
                itemList.add(itemBahan);
            }
            Map map = new HashMap();
            map.put("judul", "Laporan Pembelian Bahan Tanggal "+CurrentDate.tgl_skrg_string_lowerCase());
            map.put("total", df.format(jml) );
            map.put("tgl_lap", CurrentDate.tgl_skrng_ttd());
            map.put("user", MenuUtama.getNama_user());
            File file = new File("src/report/LapPembelianBahan.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(itemList));
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_btSimpanItemActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        if (cekKosong()) {
            try {
                String sql = "INSERT INTO item_bahan(nama_item, harga)VALUES (?,?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tfNama.getText());
                ps.setString(2, tfHarga.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil di simpan");
                datatabel();
                kosong();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Error menyimpan data");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        try {
            String sql = "DELETE FROM item_bahan WHERE id=?";
            PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
            ps.setString(1, labId.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Hapus data berhasil");
            kosong();
            datatabel();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Hapus data gagal");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btHapusActionPerformed

    private void btBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBersihkanActionPerformed
        kosong();
    }//GEN-LAST:event_btBersihkanActionPerformed

    private void btUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbahActionPerformed
        if (cekKosong() == true) {
            try {
                String sql = "UPDATE item_bahan SET nama_item=?, harga=? WHERE id=?";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tfNama.getText());
                ps.setString(2, tfHarga.getText());
                ps.setString(3, labId.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Ubah data berhasil");
                kosong();
                datatabel();
                aktifSimpan(true);
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Ubah data gagal");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btUbahActionPerformed

    private void tfHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHargaKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfHargaKeyTyped

    private void tableItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemMouseClicked
        DefaultTableModel model = (DefaultTableModel) tableItem.getModel();
        int row = tableItem.getSelectedRow();
        labId.setText(arrayId.get(row));
        tfNama.setText(model.getValueAt(row, 0).toString());
        tfHarga.setText(model.getValueAt(row, 1).toString());
        aktifSimpan(false);
    }//GEN-LAST:event_tableItemMouseClicked

    private void tableItemCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tableItemCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tableItemCaretPositionChanged

    private void btHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHitungActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableItem.getModel();
        int qty = 0;
        int harga = 0;
        Object[] Baris = {"Nama Item", "Harga", "Qty", "Jumlah"};
        tabMode = new DefaultTableModel(null, Baris);
        tableItem.setModel(tabMode);
        try {
            int index = 0;
            String sql = "SELECT * FROM item_bahan";
            ResultSet hasil = Koneksi_1.con_stat().executeQuery(sql);
            while (hasil.next()) {
                harga = Integer.parseInt(model.getValueAt(index, 1).toString());
                qty = convertInt(model.getValueAt(index, 2).toString());
                tabMode.addRow(new Object[]{
                    hasil.getString("nama_item"),
                    hasil.getString("harga"),
                    String.valueOf(qty),
                    String.valueOf(qty * harga)
                });
                System.out.println(String.valueOf(index));
                System.out.println(model.getValueAt(index, 2));
                System.out.println("--------------------------------------");
                index++;
            }
            tableItem.setModel(tabMode);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btHitungActionPerformed

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
            java.util.logging.Logger.getLogger(BahanBaku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BahanBaku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BahanBaku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BahanBaku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BahanBaku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBersihkan;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btHitung;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btSimpanItem;
    private javax.swing.JButton btUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpUbahItem;
    private javax.swing.JLabel labId;
    private javax.swing.JTable tableItem;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
  private void datatabel() {
        arrayId.clear();
        Object[] Baris = {"Nama Item", "Harga", "Qty"};
        tabMode = new DefaultTableModel(null, Baris);
        tableItem.setModel(tabMode);
        try {
            String sql = "SELECT * FROM item_bahan";
            ResultSet hasil = Koneksi_1.con_stat().executeQuery(sql);
            while (hasil.next()) {
                arrayId.add(hasil.getString("id"));
                tabMode.addRow(new Object[]{
                    hasil.getString("nama_item"),
                    hasil.getString("harga"),
                    ""
                });
            }
            tableItem.setModel(tabMode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean cekKosong() {
        boolean b = false;
        if (!tfNama.getText().isEmpty()) {
            if (!tfHarga.getText().isEmpty()) {
                b = true;
            } else {
                JOptionPane.showMessageDialog(this, "Kolom harga tidak boleh kosong");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kolom nama item tidak boleh kosong");
        }
        return b;
    }

    private void kosong() {
        labId.setText("");
        tfNama.setText("");
        tfHarga.setText("");
        datatabel();
        aktifSimpan(true);
    }

    private void aktifSimpan(boolean b) {
        btSimpan.setEnabled(b);
        btHapus.setEnabled(!b);
        btUbah.setEnabled(!b);
    }

    private int convertInt(String s) {
        Integer hasil = 0;
        if (s.length() != 0) {
            try {
                hasil = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                hasil = 0;
            }
        } else {
            hasil = 0;
        }
        return hasil;
    }
    private String itemLap(String s){
        String i = df.format(Integer.parseInt(String.valueOf(s)));
        return i;
    }

}
