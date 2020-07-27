package transaksi;

import config.CurrentDate;
import config.ItemLaba;
import config.ItemLapBulanan;
import config.Koneksi_1;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

public class LaporanLaba extends javax.swing.JFrame {
    GregorianCalendar date = new GregorianCalendar();
    public static String pendapatan;
    public static String tgl;
    DecimalFormat df = new DecimalFormat("Rp ###,###,###.-");
    int totalOut, gajiKry, biayaPeng;

    public LaporanLaba() {
        initComponents();
        init();
        cekSimpan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tx_tgl = new javax.swing.JTextField();
        tx_pend = new javax.swing.JTextField();
        tx_gajiKry = new javax.swing.JTextField();
        bt_cetak = new javax.swing.JButton();
        bt_simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tx_biayaPeng = new javax.swing.JTextField();
        tx_sewaTemp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tx_bahanBaku = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tx_labaBers = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("LAPORAN LABA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jLabel2.setText("TANGGAL");

        jLabel3.setText("PENDAPATAN");

        jLabel4.setText("GAJI KARYAWAN ");

        tx_gajiKry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_gajiKryKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_gajiKryKeyTyped(evt);
            }
        });

        bt_cetak.setText("CETAK");
        bt_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cetakActionPerformed(evt);
            }
        });

        bt_simpan.setText("SIMPAN");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        jLabel5.setText("BIAYA PENGIRIMAN");

        tx_biayaPeng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_biayaPengKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_biayaPengKeyTyped(evt);
            }
        });

        tx_sewaTemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_sewaTempKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_sewaTempKeyTyped(evt);
            }
        });

        jLabel6.setText("SEWA TEMPAT");

        tx_bahanBaku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_bahanBakuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_bahanBakuKeyTyped(evt);
            }
        });

        jLabel7.setText("BAHAN BAKU");

        jLabel8.setText("LABA BERSIH");

        tx_labaBers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tx_labaBersKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_simpan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tx_biayaPeng, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tx_tgl)
                                .addComponent(tx_pend)
                                .addComponent(tx_gajiKry, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tx_sewaTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_bahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_labaBers))))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tx_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tx_pend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tx_gajiKry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tx_biayaPeng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tx_sewaTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tx_bahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tx_labaBers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_simpan)
                    .addComponent(bt_cetak))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cetakActionPerformed
       ArrayList<ItemLaba> arrayList =  new ArrayList();
        int bulan = date.get(Calendar.MONTH);
        ItemLaba itemLaba = new ItemLaba("nama");
        arrayList.add(itemLaba);
        try {
            Map map = new HashMap();
            map.put("pendapatan","Pendapatan 1 "+CurrentDate.periodeBulan(bulan)+" - "+CurrentDate.tgl_skrg_string());
            map.put("omset",String.valueOf(df.format(nominal(tx_pend))));
            map.put("gaji",String.valueOf(df.format(nominal(tx_gajiKry))));
            map.put("pengiriman",String.valueOf(df.format(nominal(tx_biayaPeng))));
            map.put("tempat",String.valueOf(df.format(nominal(tx_sewaTemp))));
            map.put("bahan",String.valueOf(df.format(nominal(tx_bahanBaku))));
            map.put("totOut",String.valueOf(df.format(nominal(tx_gajiKry)+nominal(tx_biayaPeng)+nominal(tx_sewaTemp)+nominal(tx_bahanBaku))));
            map.put("bersih", String.valueOf(df.format(nominal(tx_labaBers))));
            File file = new File("src/report/LaporanLaba.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(arrayList)); 
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_cetakActionPerformed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        try {
            String sql = "INSERT INTO laporan_laba_rugi(lpb_updatedate,lpb_pendapatan,lpb_gajikry,lpb_biayapengiriman,lpb_sewatempat,lpb_bahanbaku,lpb_lababersih) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = Koneksi_1.con().prepareStatement(sql);
            ps.setString(1, CurrentDate.tgl_skrg());
            ps.setString(2, cekNull(tx_pend));
            ps.setString(3, cekNull(tx_gajiKry));
            ps.setString(4, cekNull(tx_biayaPeng));
            ps.setString(5, cekNull(tx_sewaTemp));
            ps.setString(6, cekNull(tx_bahanBaku));
            ps.setString(7, cekNull(tx_labaBers));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil di simpan");
            cekSimpan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error menyimpan data");
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void tx_gajiKryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_gajiKryKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_gajiKryKeyTyped

    private void tx_biayaPengKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_biayaPengKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_biayaPengKeyTyped

    private void tx_sewaTempKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_sewaTempKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_sewaTempKeyTyped

    private void tx_bahanBakuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_bahanBakuKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_bahanBakuKeyTyped

    private void tx_labaBersKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_labaBersKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || c == (KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tx_labaBersKeyTyped

    private void tx_gajiKryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_gajiKryKeyPressed
        int ascii = evt.getKeyChar();
        if (ascii == 8) {
            tx_gajiKry.setText("");
            totalOut = nominal(tx_pend)-nominal(tx_bahanBaku)-nominal(tx_biayaPeng)-nominal(tx_sewaTemp);
            System.out.println(totalOut);
            tx_labaBers.setText(String.valueOf(totalOut));
        }
        if ((ascii >= 48 && ascii <= 57)) {
            totalOut = Integer.parseInt(tx_gajiKry.getText().concat(String.valueOf(evt.getKeyChar())))+nominal(tx_bahanBaku)+nominal(tx_biayaPeng)+nominal(tx_sewaTemp);
            tx_labaBers.setText(String.valueOf(Integer.parseInt(tx_pend.getText())-totalOut));
        }
    }//GEN-LAST:event_tx_gajiKryKeyPressed

    private void tx_biayaPengKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_biayaPengKeyPressed
        int ascii = evt.getKeyChar();
        if (ascii == 8) {
            tx_biayaPeng.setText("");
            totalOut = nominal(tx_pend)-nominal(tx_bahanBaku)-nominal(tx_gajiKry)-nominal(tx_sewaTemp);
            tx_labaBers.setText(String.valueOf(totalOut));
        }
        if ((ascii >= 48 && ascii <= 57)) {
            totalOut = Integer.parseInt(tx_biayaPeng.getText().concat(String.valueOf(evt.getKeyChar())))+nominal(tx_gajiKry)+nominal(tx_bahanBaku)+nominal(tx_sewaTemp);
            tx_labaBers.setText(String.valueOf(Integer.parseInt(tx_pend.getText())-totalOut));
        }
    }//GEN-LAST:event_tx_biayaPengKeyPressed

    private void tx_sewaTempKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_sewaTempKeyPressed
        int ascii = evt.getKeyChar();
        if (ascii == 8) {
            tx_sewaTemp.setText("");
            totalOut = nominal(tx_pend)-nominal(tx_bahanBaku)-nominal(tx_gajiKry)-nominal(tx_biayaPeng);
            tx_labaBers.setText(String.valueOf(totalOut));
        }
        if ((ascii >= 48 && ascii <= 57)) {
            totalOut = Integer.parseInt(tx_sewaTemp.getText().concat(String.valueOf(evt.getKeyChar())))+nominal(tx_gajiKry)+nominal(tx_bahanBaku)+nominal(tx_biayaPeng);
            tx_labaBers.setText(String.valueOf(Integer.parseInt(tx_pend.getText())-totalOut));
        }
    }//GEN-LAST:event_tx_sewaTempKeyPressed

    private void tx_bahanBakuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_bahanBakuKeyPressed
       int ascii = evt.getKeyChar();
        if (ascii == 8) {
            tx_bahanBaku.setText("");
            totalOut = nominal(tx_pend)-nominal(tx_biayaPeng)-nominal(tx_gajiKry)-nominal(tx_sewaTemp);
            tx_labaBers.setText(String.valueOf(totalOut));
        }
        if ((ascii >= 48 && ascii <= 57)) {
            totalOut = Integer.parseInt(tx_bahanBaku.getText().concat(String.valueOf(evt.getKeyChar())))+nominal(tx_gajiKry)+nominal(tx_biayaPeng)+nominal(tx_sewaTemp);
            tx_labaBers.setText(String.valueOf(Integer.parseInt(tx_pend.getText())-totalOut));
        }
    }//GEN-LAST:event_tx_bahanBakuKeyPressed

    /**
     * @param args the command line arguments
     t*/
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
            java.util.logging.Logger.getLogger(LaporanLaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanLaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanLaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanLaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanLaba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cetak;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tx_bahanBaku;
    private javax.swing.JTextField tx_biayaPeng;
    private javax.swing.JTextField tx_gajiKry;
    private javax.swing.JTextField tx_labaBers;
    private javax.swing.JTextField tx_pend;
    private javax.swing.JTextField tx_sewaTemp;
    private javax.swing.JTextField tx_tgl;
    // End of variables declaration//GEN-END:variables

private void init(){
    tx_tgl.setText(CurrentDate.tgl_skrg_string());
    tx_tgl.setEditable(false);
    tx_pend.setText(getPendapatan());
    tx_labaBers.setText(getPendapatan());
    tx_pend.setEditable(false);
    tx_labaBers.setEditable(false);
}


    public static String getPendapatan() {
        return pendapatan;
    }

    public static void setPendapatan(String pendapatan) {
        LaporanLaba.pendapatan = pendapatan;
    }
    
    private int nominal(JTextField field){
        int a=0;
        if(field.getText().isEmpty()){
            a=0;
        }else{
            a=Integer.parseInt(field.getText());
        }
        return a;
    }
    
     private String cekNull(JTextField field){
        String a="0";
        if(field.getText().isEmpty()){
            a="0";
        }else{
            a=field.getText();
        }
        return a;
    }
    
    
    private void cekSimpan(){
         try {
            String sql = "SELECT * FROM laporan_laba_rugi WHERE lpb_updatedate='"+CurrentDate.tgl_skrg()+"'";
            ResultSet rs = Koneksi_1.con_stat().executeQuery(sql);
            if (rs.next()) {
                tx_pend.setText(rs.getString("lpb_pendapatan"));
                tx_gajiKry.setText(rs.getString("lpb_gajikry"));
                tx_biayaPeng.setText(rs.getString("lpb_biayapengiriman"));
                tx_sewaTemp.setText(rs.getString("lpb_sewatempat"));
                tx_bahanBaku.setText(rs.getString("lpb_bahanbaku"));
                tx_labaBers.setText(rs.getString("lpb_lababersih"));
                bt_simpan.setEnabled(false);
                bt_cetak.setVisible(true);
            }else{
                bt_simpan.setEnabled(true);
                bt_cetak.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
