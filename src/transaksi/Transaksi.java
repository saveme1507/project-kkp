package transaksi;

import config.CurrentDate;
import config.ItemLapHarian;
import config.ItemStruk;
import config.Koneksi_1;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi extends javax.swing.JFrame {

    DefaultTableModel tabMode;
    DecimalFormat df = new DecimalFormat("##,###,###.-");
    double total, bayar, kembali;

    public Transaksi() {
        initComponents();
        no_transaksi();
        bt_cetak.setVisible(false);
        tx_no.setText(String.valueOf(no_transaksi()));
        tx_no.setEditable(false);
        tx_kd.setEditable(false);
        tx_nama.setEditable(false);
        tx_harga.setEditable(false);
        tx_total.setEditable(false);
        tx_kembali.setEditable(false);
    }

    private int no_transaksi() {
        String noAwal = null;
        int noSekarang = 0;
        try {
            String sql = "SELECT MAX(trh_no_transaksi) AS sekarang FROM transaksi_header";
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

    private void datatabel() {
        int a, b, c;
        a = Integer.valueOf(tx_harga.getText());
        b = Integer.valueOf(tx_qty.getText());
        c = a * b;
        String e = String.valueOf(df.format(c));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            tx_kd.getText(),
            tx_nama.getText(),
            tx_harga.getText(),
            tx_qty.getText(),
            e
        });

        total += c;
        tx_total.setText(String.valueOf(df.format(total)));

        CariProduk.setNama("");
        CariProduk.setHarga("");
        CariProduk.setKode("");
    }

    private void printStruk() {
//        try {
//            File file = new File("src/report/StrukPembelian.jrxml");
//            JasperDesign jasperDesign = JRXmlLoader.load(file);
//            int no_transaksi = Integer.parseInt(tx_no.getText());
//            Map param = new HashMap();
//            param.put("no_tranksaksi", no_transaksi);
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, Koneksi_1.con());
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e);
//        }

        //print laporan
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            ArrayList itemList = new ArrayList();
            ItemStruk itemStruk;
            itemList.clear();
            for (int i = 0; i < model.getRowCount(); i++) {
                itemStruk = new ItemStruk(
                        model.getValueAt(i, 1).toString(),
                        Integer.parseInt(model.getValueAt(i, 2).toString()),
                        Integer.parseInt(model.getValueAt(i, 3).toString()),
                        Integer.parseInt(model.getValueAt(i, 4).toString().replace(",", "").replace("-", "").replace(".", ""))
                );
                itemList.add(itemStruk);
            }
            Map map = new HashMap();
            map.put("noTransaksi", Integer.parseInt(tx_no.getText()));
            map.put("total", Integer.parseInt(tx_total.getText().replace(",", "").replace("-", "").replace(".", "")));
            map.put("bayar", Integer.parseInt(tx_bayar.getText()));
            map.put("kembali", Integer.parseInt(tx_kembali.getText().replace(",", "").replace("-", "").replace(".", "")));
            File file = new File("src/report/LapStrukPembelian.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(itemList));
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            System.out.println(e);

        }
    }

    public void kosong() {
        tx_kd.setText("");
        tx_nama.setText("");
        tx_harga.setText("");
        tx_qty.setText("");
    }

    private void kosongHeader() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        tx_total.setText("");
        tx_bayar.setText("");
        tx_kembali.setText("");
        tx_no.setText(String.valueOf(no_transaksi()));
        total=0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tx_kd = new javax.swing.JTextField();
        tx_no = new javax.swing.JTextField();
        tx_nama = new javax.swing.JTextField();
        tx_harga = new javax.swing.JTextField();
        tx_qty = new javax.swing.JTextField();
        bt_cari = new javax.swing.JButton();
        bt_tambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tx_kembali = new javax.swing.JTextField();
        tx_bayar = new javax.swing.JTextField();
        tx_total = new javax.swing.JTextField();
        bt_cetak = new javax.swing.JButton();
        bt_simpan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lb_eror1 = new javax.swing.JLabel();
        lb_eror2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(617, 97));
        jPanel2.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1)
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KODE PRODUK");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NO TRANSAKSI");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA PRODUK");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QTY");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("HARGA");

        tx_qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx_qtyFocusGained(evt);
            }
        });
        tx_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_qtyKeyTyped(evt);
            }
        });

        bt_cari.setBackground(new java.awt.Color(255, 255, 255));
        bt_cari.setText("CARI");
        bt_cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_cariFocusGained(evt);
            }
        });
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        bt_tambah.setBackground(new java.awt.Color(255, 255, 255));
        bt_tambah.setText("TAMBAH");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama Produk", "Harga", "Qty", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BAYAR");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("KEMBALIAN");

        tx_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_bayarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_bayarKeyTyped(evt);
            }
        });

        bt_cetak.setBackground(new java.awt.Color(255, 255, 255));
        bt_cetak.setText("CETAK");
        bt_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cetakActionPerformed(evt);
            }
        });

        bt_simpan.setBackground(new java.awt.Color(255, 255, 255));
        bt_simpan.setText("SIMPAN");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        lb_eror1.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        lb_eror1.setForeground(new java.awt.Color(255, 255, 255));

        lb_eror2.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        lb_eror2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_total, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_eror2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bt_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lb_eror1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tx_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_no, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(tx_kd)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tx_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(493, 493, 493))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tx_no, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tx_kd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tx_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lb_eror1))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tx_total, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tx_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lb_eror2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tx_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
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
        new CariProduk().setVisible(true);
    }//GEN-LAST:event_bt_cariActionPerformed

    private void bt_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cetakActionPerformed
        // TODO add your handling code here:
//        try {
//            File file = new File("src/report/StrukPembelian.jrxml");
//            JasperDesign jasperDesign = JRXmlLoader.load(file);
//            int no_transaksi = Integer.parseInt(tx_no.getText());
//            Map param = new HashMap();
//            param.put("no_tranksaksi", no_transaksi);
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, Koneksi_1.con());
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_bt_cetakActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
        // TODO add your handling code here:
        datatabel();
        kosong();
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_cariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_cariFocusGained
        // TODO add your handling code here:
        tx_qty.requestFocus();
    }//GEN-LAST:event_bt_cariFocusGained

    private void tx_bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_bayarKeyPressed
        // TODO add your handling code here:
        int ascii = evt.getKeyChar();
        if (ascii == 8) {
            tx_kembali.setText("");
            tx_bayar.setText("");
        }
        if ((ascii >= 48 && ascii <= 57)) {
            total = Integer.parseInt(tx_total.getText().replace(",", "").replace("-", "").replace(".", ""));
            bayar = Integer.parseInt(tx_bayar.getText().concat(String.valueOf(evt.getKeyChar())));
            kembali = bayar - total;
            tx_kembali.setText(String.valueOf(df.format(kembali)));
        }
    }//GEN-LAST:event_tx_bayarKeyPressed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        Boolean header = null, detail = null, stok = null;
        if (tx_bayar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Masukan jumlah bayar");
        } else {
            // input transaksi header
            try {
                String sql = "INSERT INTO transaksi_header (trh_no_transaksi,trh_total,trh_bayar,trh_kembali,trh_updatedate) VALUES (?,?,?,?,?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                ps.setString(1, tx_no.getText());
                ps.setString(2, tx_total.getText().replace(",", "").replace("-", "").replace(".", ""));
                ps.setString(3, tx_bayar.getText());
                ps.setString(4, tx_kembali.getText().replace(",", "").replace("-", "").replace(".", ""));
                ps.setString(5, CurrentDate.tgl_skrg());
                ps.executeUpdate();
                header = true;
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Error menyimpan data");
                System.out.println("Tambah data header transaksi gagal : " + e);
            }

            //input transaksi detail
            try {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                String sql = "INSERT INTO transaksi_detail (trd_no_transaksi,trd_pd_kode,trd_qty,trd_harga) VALUES (?,?,?,?)";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    ps.setString(1, tx_no.getText());
                    ps.setString(2, model.getValueAt(i, 0).toString());
                    ps.setString(3, model.getValueAt(i, 3).toString());
                    ps.setString(4, model.getValueAt(i, 2).toString());
                    ps.executeUpdate();
                }
                kosong();
                detail = true;
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Error menyimpan data 2");
                System.out.println("Tambah data detail transaksi gagal : " + e);
            }

            //pengurangan setok
            ArrayList<ItemKode> listProduk = new ArrayList();
            ItemKode itemKode;
            try {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String sql = "SELECT mpd_pd_kode FROM master_promo_detail WHERE mpd_kode='"+model.getValueAt(i, 0).toString()+"'";
                    ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
                    if (model.getValueAt(i, 0).toString().startsWith("P")) {
                        while (rs.next()) {
                            itemKode = new ItemKode(
                                    Integer.parseInt(rs.getString("mpd_pd_kode")),
                                    Integer.parseInt(model.getValueAt(i, 3).toString())
                            );
                            listProduk.add(itemKode);
                        }
                    } else {
                        itemKode = new ItemKode(
                                Integer.parseInt(model.getValueAt(i, 0).toString()),
                                Integer.parseInt(model.getValueAt(i, 3).toString())
                        );
                        listProduk.add(itemKode);
                    }
                }
            } catch (Exception e) {
                System.out.println("menyimpan item pengurangan gagal :" + e);
            }

            try {
                String sql = "UPDATE produk SET pd_stock=pd_stock - ?  WHERE pd_kode=?";
                PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
                for (int i = 0; i < listProduk.size(); i++) {
                    ps.setInt(1, listProduk.get(i).qty);
                    ps.setInt(2, listProduk.get(i).kode);
                    ps.executeUpdate();
                    System.out.println(listProduk.get(i).kode);
                }
                stok = true;
            } catch (Exception e) {
                System.out.println("pengurangan stok" + e);
            }
        }

        //commit                                                                                        
        if (header && stok && detail == true) {
            int opsi = JOptionPane.showConfirmDialog(null, "Print struk pembelian ?", "Transaksi berhasil disimpan", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                printStruk();
                kosongHeader();
            } else {
                kosongHeader();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Transaksi gagal di simpan");
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void tx_qtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_qtyFocusGained
        // TODO add your handling code here:
        tx_kd.setText(CariProduk.getKode());
        tx_nama.setText(CariProduk.getNama());
        tx_harga.setText(CariProduk.getHarga());
    }//GEN-LAST:event_tx_qtyFocusGained

    private void tx_qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_qtyKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_qtyKeyTyped

    private void tx_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_bayarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_bayarKeyTyped

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
            java.util.logging.Logger.getLogger(Transaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_cetak;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_eror1;
    private javax.swing.JLabel lb_eror2;
    private javax.swing.JTextField tx_bayar;
    private javax.swing.JTextField tx_harga;
    private javax.swing.JTextField tx_kd;
    private javax.swing.JTextField tx_kembali;
    private javax.swing.JTextField tx_nama;
    private javax.swing.JTextField tx_no;
    private javax.swing.JTextField tx_qty;
    private javax.swing.JTextField tx_total;
    // End of variables declaration//GEN-END:variables
 static class panelbackground {

        public panelbackground() {
        }
    }

}

class ItemKode {

    int kode, qty;

    public ItemKode(int kode, int qty) {
        this.kode = kode;
        this.qty = qty;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
