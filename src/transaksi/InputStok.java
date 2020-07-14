package transaksi;

import config.Koneksi_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class InputStok extends javax.swing.JFrame {
    private final Connection conn = Koneksi_1.con();
    private DefaultTableModel tabMode;

    public InputStok() {
        initComponents();
        datatabel();
        cekSimpan();
    }

    private void datatabel() {
        Object[] Baris = {"KODE", "PRODUK", "SATUAN", "HARGA", "STOK"};
        tabMode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabMode);
        try {
            String sql = "SELECT * FROM produk";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabMode.addRow(new Object[]{
                    hasil.getString("pd_kode"),
                    hasil.getString("pd_nama"),
                    hasil.getString("pd_satuan"),
                    hasil.getString("pd_harga"),
                    hasil.getString("pd_stock")
                });
            }
            jTable1.setModel(tabMode);
            settingKolom();
        } catch (SQLException e) {
            System.out.println("error :" + e);
        }
    }
    
    private void cekSimpan(){
        ArrayList<String> update = new ArrayList<>();
        try {
            String sql = "SELECT pd_updatedate FROM produk";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
               update.add(hasil.getString("pd_updatedate"));
            }
            if (!update.contains(config.CurrentDate.tgl_skrg())) {
                bt_simpan.setEnabled(true);
                bt_reset.setEnabled(false);
            }else{
                bt_simpan.setEnabled(false);
                bt_reset.setEnabled(true);
            }
        } catch (SQLException e) {
            System.out.println("error :" + e);
        }
    }
    
    boolean cekInteger(String s){
        boolean hasil;
         try {
            int test = Integer.parseInt(s);
            hasil = true;
        } catch (NumberFormatException e) {
            hasil = false;
        }
        return hasil;
    }
    
      public void settingKolom(){
                // lebar kolom
                TableColumn column;
                jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
                column = jTable1.getColumnModel().getColumn(0); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(1); 
                column.setPreferredWidth(493);
                column = jTable1.getColumnModel().getColumn(2); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(3); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(4); 
                column.setPreferredWidth(60);
                
                // align kolom
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(3).setCellRenderer( rightRenderer );
                
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt_simpan = new javax.swing.JButton();
        bt_kembali = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("INPUT STOK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel2)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "KODE", "PRODUK", "SATUAN", "HARGA", "STOK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        jScrollPane2.setViewportView(jTable1);

        bt_simpan.setText("SIMPAN");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        bt_kembali.setText("KEMBALI");
        bt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kembaliActionPerformed(evt);
            }
        });

        bt_reset.setText("RESET");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_kembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_simpan)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_simpan)
                    .addComponent(bt_kembali)
                    .addComponent(bt_reset))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int bar = jTable1.getSelectedRow();
        String a = tabMode.getValueAt(bar, 1).toString();
        String b = tabMode.getValueAt(bar, 0).toString();
        String v = JOptionPane.showInputDialog("Masukan Stok " + a);
        if (v.length() == 0) {
            System.out.println("Stok belum dimasukan!");
            
           
        } else if(cekInteger(v) == false) {
            JOptionPane.showMessageDialog(this, "Data stok harus berupa angka");
        }else{
            int i = jTable1.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            if (i >= 0) {
                model.setValueAt(v, i, 4);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        
        try {
              DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
              String sql = "UPDATE produk SET pd_stock=?,pd_updatedate=? WHERE pd_kode=?";
              PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
              for (int i = 0; i < jTable1.getRowCount(); i++) {
                  ps.setString(1, model.getValueAt(i, 4).toString());
                  ps.setString(2, config.CurrentDate.tgl_skrg());
                  ps.setString(3, model.getValueAt(i, 0).toString());
                  ps.executeUpdate();
              }
              JOptionPane.showMessageDialog(this, "Data stok berhasil diupdate");
              datatabel();
              cekSimpan();
          } catch (SQLException e) {
              System.out.println(e);
          }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void bt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kembaliActionPerformed
        dispose();
    }//GEN-LAST:event_bt_kembaliActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        int jawab = JOptionPane.showOptionDialog(this, 
                        "Apa anda yakin akan mereset daftar stok?", 
                        "Konfirmasi", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if(jawab == JOptionPane.YES_OPTION){
            try {
              DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
              String sql = "UPDATE produk SET pd_stock=?,pd_updatedate=? WHERE pd_kode=?";
              PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
              for (int i = 0; i < jTable1.getRowCount(); i++) {
                  ps.setString(1, String.valueOf(0));
                  ps.setString(2, "2020-01-01");
                  ps.setString(3, model.getValueAt(i, 0).toString());
                  ps.executeUpdate();
              }
              datatabel();
              cekSimpan();
            } catch (SQLException e) {
                 System.out.println(e);
            }
        }
    }//GEN-LAST:event_bt_resetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputStok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_kembali;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
