
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mert
 */
public class Veritabani {
    String username="root";
    String password = "";
    String databaseName = "kelimeoyunu";
    String host = "localhost";
    int port = 3306;
    
    
    Connection connection = null;

    public Veritabani() {
        
        
        String url = "jdbc:mysql://" + host +":" + port+ "/" +databaseName+"?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver bulunamadı");
        }
        
        try {
            connection = DriverManager.getConnection(url,username,password);
                System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı başarısız");
        }
    }
    
    public static void main(String[] args) {
        Veritabani veritabani = new Veritabani();
        
    }
}
