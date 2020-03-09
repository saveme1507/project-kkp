package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author saveme
 */
public class Koneksi_2 {
    
    public static Statement connect_2(){
        Statement s=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_kkp_backup", "root", "");
            s = con.createStatement();
            JOptionPane.showMessageDialog(null, "koneksi 2 berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi 2 gagal "+e.getMessage());
            System.out.println("error"+ e);
        }
        return s;
    }    
    public static Connection con(){
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost/db_kkp_backup", "root", "");
            System.out.println("Koneksi 2 Database Berhasil");
        }catch(SQLException ex){
            System.out.println("Koneksi 2 Database Gagal : "+ex);
        }
        return c;
    }
    
}
