package transaksi;

import config.CurrentDate;
import config.ItemLaporan;
import config.Koneksi_1;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MenuUtama extends javax.swing.JFrame {
    public static String nama_user = getNama_user();
    DecimalFormat df = new DecimalFormat("Rp ###,###,###.-");
    
    public MenuUtama() {
        initComponents();
        datatabel();
        jLabel4.setText(nama_user.toUpperCase());
        confirmClose();        
    }

    private void datatabel() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM produk";
            ResultSet hasil = Koneksi_1.con_stat().executeQuery(sql);
            while (hasil.next()) {
                model.addRow(new Object[]{
                    hasil.getString("pd_kode"),
                    hasil.getString("pd_nama"),
                    hasil.getString("pd_stock"),
                    hasil.getString("pd_harga")
                });
            }
            settingKolom();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static String getNama_user() {
        return nama_user;
    }

    public static void setNama_user(String nama_user) {
        MenuUtama.nama_user = nama_user;
    }

    private void confirmClose() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                doExit();
            }
        });
    }

    public void doExit() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Konfirmasi Keluar Aplikasi",
                "Yakin untuk keluar dari program",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    public void settingKolom(){
                // lebar kolom
                TableColumn column;
                jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
                column = jTable1.getColumnModel().getColumn(0); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(1); 
                column.setPreferredWidth(510);
                column = jTable1.getColumnModel().getColumn(2); 
                column.setPreferredWidth(60);
                column = jTable1.getColumnModel().getColumn(3); 
                column.setPreferredWidth(100);
                
                // align kolom
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
                jTable1.getColumnModel().getColumn(3).setCellRenderer( rightRenderer );
                
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bt_stok = new javax.swing.JButton();
        bt_laporanBulanan = new javax.swing.JButton();
        bt_master_promo = new javax.swing.JButton();
        bt_user = new javax.swing.JButton();
        bt_transaksi = new javax.swing.JButton();
        bt_master_produk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bt_laporanHarian = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt_cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("BERKAH BUANA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel1)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        bt_stok.setBackground(new java.awt.Color(0, 102, 204));
        bt_stok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_stok.setText("STOK");
        bt_stok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_stokFocusGained(evt);
            }
        });
        bt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_stokActionPerformed(evt);
            }
        });

        bt_laporanBulanan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_laporanBulanan.setText("LAPORAN BULANAN");
        bt_laporanBulanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_laporanBulananActionPerformed(evt);
            }
        });

        bt_master_promo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_master_promo.setText("MASTER PROMO");
        bt_master_promo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_master_promoActionPerformed(evt);
            }
        });

        bt_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_user.setText("USER");
        bt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_userActionPerformed(evt);
            }
        });

        bt_transaksi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_transaksi.setText("TRANSAKSI");
        bt_transaksi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_transaksiFocusGained(evt);
            }
        });
        bt_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_transaksiActionPerformed(evt);
            }
        });

        bt_master_produk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_master_produk.setText("MASTER PRODUK");
        bt_master_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_master_produkActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SELAMAT DATANG");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NAMA USER LOGIN");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        bt_laporanHarian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_laporanHarian.setText("LAPORAN HARIAN");
        bt_laporanHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_laporanHarianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_stok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_laporanBulanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_master_promo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_master_produk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_laporanHarian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_laporanHarian, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_laporanBulanan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_master_promo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_master_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KODE", "PRODUK", "STOK", "HARGA"
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

        bt_cetak.setText("CETAK STOK");
        bt_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(bt_cetak))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_userActionPerformed
        new EditAkun().setVisible(true);
    }//GEN-LAST:event_bt_userActionPerformed

    private void bt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_stokActionPerformed
        new InputStok().setVisible(true);
    }//GEN-LAST:event_bt_stokActionPerformed

    private void bt_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_transaksiActionPerformed
        new Transaksi().setVisible(true);
    }//GEN-LAST:event_bt_transaksiActionPerformed

    private void bt_laporanBulananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_laporanBulananActionPerformed
        new LaporanBulanan().setVisible(true);
    }//GEN-LAST:event_bt_laporanBulananActionPerformed

    private void bt_master_promoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_master_promoActionPerformed
        new MasterPromo().setVisible(true);
    }//GEN-LAST:event_bt_master_promoActionPerformed

    private void bt_master_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_master_produkActionPerformed
        new MasterProduk().setVisible(true);
    }//GEN-LAST:event_bt_master_produkActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    }//GEN-LAST:event_jTable1MouseClicked

    private void bt_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cetakActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            ArrayList itemList = new ArrayList();
            ItemLaporan itemLaporan;
            itemList.clear();
            for (int i = 0; i < model.getRowCount(); i++) {
                int no = i + 1;
                itemLaporan = new ItemLaporan(
                        model.getValueAt(i, 0).toString(),
                        model.getValueAt(i, 1).toString(),
                        df.format(Integer.parseInt(model.getValueAt(i, 3).toString())),
                        Integer.parseInt(model.getValueAt(i, 2).toString())
                );
                itemList.add(itemLaporan);
            }
            Map map = new HashMap();
            map.put("tanggal", "SISA STOK "+config.CurrentDate.tgl_skrg_string());
            map.put("ttd", CurrentDate.tgl_skrng_ttd());
            map.put("user", MenuUtama.getNama_user());
            File file = new File("src/report/LapHarian.jrxml");
            
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(itemList));
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            System.out.println(e);

        }

    }//GEN-LAST:event_bt_cetakActionPerformed

    private void bt_laporanHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_laporanHarianActionPerformed
        new LaporanHarian().setVisible(true);
    }//GEN-LAST:event_bt_laporanHarianActionPerformed

    private void bt_stokFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_stokFocusGained
        datatabel();
    }//GEN-LAST:event_bt_stokFocusGained

    private void bt_transaksiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_transaksiFocusGained
        datatabel();
    }//GEN-LAST:event_bt_transaksiFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cetak;
    private javax.swing.JButton bt_laporanBulanan;
    private javax.swing.JButton bt_laporanHarian;
    private javax.swing.JButton bt_master_produk;
    private javax.swing.JButton bt_master_promo;
    private javax.swing.JButton bt_stok;
    private javax.swing.JButton bt_transaksi;
    private javax.swing.JButton bt_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
