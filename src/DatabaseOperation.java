

import java.awt.Label;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;


public class DatabaseOperation {
    
       private Veritabani connection = new Veritabani();
     private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
  
   String currentWord = "";
    String word = ""; //chooses random word from the word array
      String [] marks;
      ArrayList<String> list = new ArrayList<>();
       HashSet<Character> lettersGuessed = new HashSet<>();
      
          Random rand = new Random();
        int sayi = 0;
      
    static int sayac = 0;
     
      public void kullaniciEkle(String kullaniciadi)
    {
        
        String url = "jdbc:mysql://" + connection.host + ":" + connection.port + "/" + connection.databaseName+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,connection.username,connection.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
        String sorgu = "Insert into kullanicilar (ad) VALUES(?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kullaniciadi);
           
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
      
      
     public ArrayList<KullaniciBilgi>kullaniciListele()
    {
        
        
         String url = "jdbc:mysql://" + connection.host + ":" + connection.port + "/" + connection.databaseName+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,connection.username,connection.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
        
        
    ArrayList<KullaniciBilgi> cikti = new ArrayList<>();
    
    
        try {
            statement = con.createStatement();
            String sorgu = "Select * from kullanicilar";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            
            while (rs.next()) { 
                int kullanici_id = rs.getInt("id");
                String kullanici_ad = rs.getString("ad");
                int kullanici_puan = rs.getInt("puan");

             
                
                
                
                cikti.add(new KullaniciBilgi(kullanici_id,kullanici_ad,kullanici_puan));
               
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nullll");
            return  null;
        }
    
    }
       
      
      
       public void soruEkle(String soru,String cevap)
    {
        
        String url = "jdbc:mysql://" + connection.host + ":" + connection.port + "/" + connection.databaseName+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,connection.username,connection.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
        String sorgu = "Insert into sorularvecevaplar (soru,cevap) VALUES(?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, soru);
            preparedStatement.setString(2, cevap);
           
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
       
       public void soruGetir(int id,JLabel label)
       {
           
           
            String url = "jdbc:mysql://" + connection.host + ":" + connection.port + "/" + connection.databaseName+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,connection.username,connection.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
        
        
       String sorgu = "Select soru from sorularvecevaplar where id=" +id;
       
        String soru="";
     
           try {
                 
                 statement = con.createStatement();
               System.out.println("Çalıştı");
               ResultSet rs = statement.executeQuery(sorgu);
               
               while (rs.next()) {                   
                    soru = rs.getString("soru");
               }
               label.setText(soru);
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
       
       
       
       
        public void puanUpdate(String isim,int puan)
    {
   
      String url = "jdbc:mysql://" + connection.host + ":" + connection.port + "/" + connection.databaseName+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,connection.username,connection.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
        
        
         String sorgu = "Update kullanicilar set puan=? where ad ='"+isim+"'";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, puan);
            
               
               preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
       
          public String cevapGetir(int id)
       {
           
           
            String url = "jdbc:mysql://" + connection.host + ":" + connection.port + "/" + connection.databaseName+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,connection.username,connection.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
        
        
       String sorgu = "Select cevap from sorularvecevaplar where id=" +id;
       
        String cevap="";
     
           try {
                 
                 statement = con.createStatement();
               System.out.println("Çalıştı");
               ResultSet rs = statement.executeQuery(sorgu);
               
               while (rs.next()) {                   
                    cevap = rs.getString("cevap");
               }
               
              
              
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
           }
        return cevap;
       }
          
     
          
          public void hang2()
          {
          
        for (int i=0;i<word.length(); i++) // for method for displaying the correct word as dashes
        {
            marks[i] = "-"; //dashes to represent the correct word.
        }
          }
          
          
          public  void hang(JLabel label,JButton btn) {
        
     

     

        boolean press = true;
     
           currentWord = "";
           sayi = rand.nextInt(word.length());
         
           String userInput = String.valueOf(word.charAt(sayi)); //always grab lines
            
           
          
            
            
              while (lettersGuessed.contains(userInput.charAt(0))) {                  
                  sayi = rand.nextInt(word.length());
                   userInput = String.valueOf(word.charAt(sayi));
                                }
            
            
             if(word.contains(userInput)  && press==true)
            {
                
                lettersGuessed.add(userInput.charAt(0));
                for(int i = 0; i < word.length(); i++)
                {
                    
                    if(word.charAt(i) == userInput.charAt(0))
                    {
                       
                        marks[i] = "" + userInput.charAt(0);

                    }
                   
                    currentWord += marks[i];
                   
                }
                
                 sayi = rand.nextInt(word.length());
                    
                    label.setText(currentWord);
            }

             
        }
              
      
		
	}



