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
public class Koneksi_1 {
      
    public static Statement con_stat(){
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_kkp", "root", "");
            s = con.createStatement();
            System.out.println("koneksi 1 berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi 1 gagal "+e.getMessage());
            System.out.println("error"+ e);
        }
        return s;
    }    
    
    public static Connection con(){
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost/db_kkp", "root", "");
            System.out.println("Koneksi 1 Database Berhasil");
        }catch(SQLException ex){
            System.out.println("Koneksi 1 Database Gagal : "+ex);
        }
        return c;
    }
}
