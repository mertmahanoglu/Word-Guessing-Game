
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mert
 */
public class GamePanel extends javax.swing.JFrame {
   LoginScreen screen = new LoginScreen();
   
   protected javax.swing.Timer refresherTimer = null;
      protected javax.swing.Timer refresherTimer2 = null;
      
      
    static int toplamPuan=0;
    int puanDegeri = 0;
    int cevapClick = 0;
    int degisimSayisi=1;
    
    
    FileWriter myWriter;
    HashSet<Integer> soruID = new HashSet<>();
    Random r = new Random();
    
    static String kullaniciAdi;
    
    
    
    static void pause(){
    long Time0 = System.currentTimeMillis();
    long Time1;
    long runTime = 0;
    
    Timer timer2;

    while (runTime < 1000) { // 1000 milliseconds or 1 second
        Time1 = System.currentTimeMillis();
        runTime = Time1 - Time0;
    }
}
    public void idGenerator()
    {
      if (degisimSayisi<2) {
            id = 1+r.nextInt(5);
        
        }
        else if (degisimSayisi<4) {
            id = 6+r.nextInt(5);
         
        }
        else if (degisimSayisi<6) {
            id = 11+r.nextInt(5);
           
        }
        else if (degisimSayisi<8) {
            id = 16+r.nextInt(5);
         
        }
        else if (degisimSayisi<10) {
            id = 21+r.nextInt(5);
          
        }
        else if (degisimSayisi<12) {
            id = 26+r.nextInt(5);
         
        }
        else if (degisimSayisi<=14) {
            id = 31+r.nextInt(5);
             
             
        }
    
    }
    
    
    
    
    
    
    
    public void soruDegistir()
    {
        System.out.println("ID : " + id);
    
        while(soruID.contains(id))
        {
            if (soruID.contains(id)==false) {
                break;
            }
            else
            {
                 idGenerator();
            }
    
        }
        if (soruID.contains(id)==false) {
             lblTimer2.setVisible(false);
                 lblTimer2.setText("20");
                 saniye2=20;
                 islemler.soruGetir(id, lblSoru);
                 islemler.word=islemler.cevapGetir(id);
                 islemler.marks = new String[islemler.word.length()];
                 islemler.hang2();
                 islemler.lettersGuessed.clear();
                 btnHarf.setEnabled(true);
                 lblCevap.setText(hiddenWord());
                
                
                 puan();
                 txtbCevap.setText("");
                 lblToplam.setText(String.valueOf("Puanınız : " + toplamPuan));
                 
                 soruID.add(id);
                
        } 
    }
    
    
    protected void stopRefreshing() {
    if (refresherTimer != null) {
        refresherTimer.stop();
        refresherTimer = null;
    }
}
protected void startRefreshing() {
    stopRefreshing();
    refresherTimer = new Timer(100, e -> {
           
                 if (lblCevap.getText().contains("-")==false) {

                       if (degisimSayisi>=14) {
                             
                       try {
                           
                       screen.setVisible(false);
                       toplamPuan += puanDegeri;
                       txtbCevap.setEnabled(false);
                       btnHarf.setEnabled(false);
                       btnCvp.setEnabled(false);
                       lblToplam.setText(String.valueOf(toplamPuan));
                       islemler.puanUpdate(kullaniciAdi, toplamPuan);
                       myWriter = new FileWriter("kullanicilar.txt",true);
                        
                       myWriter.write(kullaniciAdi + "        " + toplamPuan  + "\n");
                       
                       myWriter.close();
                       stopRefreshing();
                         
                    } catch (IOException ex) {
                        Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                }
                          else
                          {
                          pause();
                           btnHarf.setEnabled(false);
                           soruDegistir();
                             btnHarf.setEnabled(true);
                           degisimSayisi++;
                          }
                              
           
               
               
            
        }
    });
    refresherTimer.start();
}
    
    
      protected void stopRefreshingSn() {
    if (refresherTimer2 != null) {
        refresherTimer2.stop();
        refresherTimer2 = null;
    }
}
protected void startRefreshingSn() {
    stopRefreshingSn();
    refresherTimer2 = new Timer(100, e -> {
           
                System.out.println(saniye);

                       if (degisimSayisi>=14) {
                             
                       try {
                           
                       screen.setVisible(false);
                       toplamPuan += puanDegeri;
                       txtbCevap.setEnabled(false);
                       btnHarf.setEnabled(false);
                       btnCvp.setEnabled(false);
                       lblToplam.setText(String.valueOf(toplamPuan));
                       islemler.puanUpdate(kullaniciAdi, toplamPuan);
                       myWriter = new FileWriter("kullanicilar.txt",true);
                        
                       myWriter.write(kullaniciAdi + "        " + toplamPuan  + "\n");
                       
                       myWriter.close();
                       timer.stop();
                       timer2.stop();
                       stopRefreshingSn();
                         
                    } catch (IOException ex) {
                        Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                }
                       else if(isOut){
                                    
                       try {
                           
                       screen.setVisible(false);
                       
                       txtbCevap.setEnabled(false);
                       btnHarf.setEnabled(false);
                       btnCvp.setEnabled(false);
                       lblToplam.setText(String.valueOf(toplamPuan));
                       islemler.puanUpdate(kullaniciAdi, toplamPuan);
                       myWriter = new FileWriter("kullanicilar.txt",true);
                        
                       myWriter.write(kullaniciAdi + "        " + toplamPuan  + "\n");
                       
                       myWriter.close();
                       timer.stop();
                       lblTimer.setText("0:00");
                       stopRefreshingSn();
                         
                    } catch (IOException ex) {
                        Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       }
                          else
                          {
                           
                           pause();
                           btnHarf.setEnabled(false);
                           soruDegistir();
                             btnHarf.setEnabled(true);
                           degisimSayisi++;
                          }
                              
           
               
               
            
        
    });
    refresherTimer2.start();
}
    
    
    
    
    
    
    public void puan()
    {
    String someString = lblCevap.getText();
    char someChar = '-';
    int count = 0;
 
    for (int i = 0; i < someString.length(); i++) {
    if (someString.charAt(i) == someChar) {
        count++;
    }
}

        puanDegeri= count*100;
        lblPuan.setText("Puan Değeri : " + puanDegeri);
    
    }
    
    
       boolean isOut = false;
    Timer timer;
       Timer timer2;
    String hyphen;
    DatabaseOperation islemler = new DatabaseOperation();
    int id = 1+r.nextInt(5);
    int saniye = 0; 
     int saniye2 = 20; 
    int dakika = 1;
    
    
    public String hiddenWord(){
     hyphen = islemler.cevapGetir(id);
     String dashes = hyphen.replaceAll("[^ ]", "-");
     return dashes;
     
                }
    
    
    
    
    public GamePanel() {
        
        
        initComponents();
     
        txtbCevap.setEnabled(false);
        System.out.println("saaaaaaaaaaaaaaaaaa " + kullaniciAdi);
         timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (saniye==0) {
                    
                    saniye=59;
                    dakika--;
                }
                if (saniye<10) {
                    lblTimer.setText(dakika + " : 0" + saniye);
                    saniye--;
                }
                if (dakika==0 && saniye==0) {
                    isOut=true;
                    startRefreshingSn();
                    
                }
                 else
                {
                lblTimer.setText(dakika + " : " + saniye);
                saniye--;
                }
                
            }
        });
         
        timer.start();
      
         
        soruDegistir();
               soruID.add(id);
        puan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnEkle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblPuan = new javax.swing.JLabel();
        lblSoru = new javax.swing.JLabel();
        txtbCevap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCvp = new javax.swing.JButton();
        lblCevap = new javax.swing.JLabel();
        btnHarf = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        lblToplam = new javax.swing.JLabel();
        lblTimer2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Soru Eklemek İster Misiniz?");

        btnEkle.setText("Soru Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Soru : ");

        lblPuan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPuan.setText("Puan Değeri :");

        lblSoru.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSoru.setText("Sorunun Tamamı");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Cevabınız :");

        btnCvp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCvp.setText("Cevapla");
        btnCvp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCvpActionPerformed(evt);
            }
        });

        lblCevap.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblCevap.setText("cevap");

        btnHarf.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHarf.setText("Harf Al");
        btnHarf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHarfActionPerformed(evt);
            }
        });

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer.setText("lblTimer");

        lblToplam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblToplam.setText("Puanınız : ");

        lblTimer2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer2.setText("20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPuan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSoru)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblToplam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCvp, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnHarf, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtbCevap, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimer))
                        .addGap(18, 18, 18)
                        .addComponent(lblTimer2)
                        .addContainerGap(257, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(lblCevap)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSoru))
                .addGap(18, 18, 18)
                .addComponent(lblPuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCevap)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblToplam)
                    .addComponent(lblTimer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtbCevap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimer2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCvp, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHarf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        lblCevap.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
       this.setVisible(false);
       SoruEkleme soruekleme = new SoruEkleme();
       soruekleme.setVisible(true);
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnCvpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCvpActionPerformed

        cevapClick++;
        lblTimer2.setVisible(true);
        
      
        if (cevapClick%2==1) {
                    timer.stop();
       
      
        txtbCevap.setEnabled(true);
        btnHarf.setEnabled(false);
        timer2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
               
                saniye2--;
                lblTimer2.setText(String.valueOf(saniye2));
             
                
                if (saniye2==0 && degisimSayisi>=14) {
                    startRefreshingSn();
                }
                else if(saniye2==0)
                {
                  
                    cevapClick++;
                    
                    soruDegistir();
                    txtbCevap.setEnabled(false);
                    timer.start();
                    timer2.stop();
                    saniye2=20;
                     degisimSayisi++;
                }
                
                
            }
        });
         
         timer2.start();
     
        }
        
        
        
        else
        {
            timer2.stop();
           
            
        if (txtbCevap.isEnabled() && txtbCevap.getText().equals("")  ) {
            cevapClick++;
            timer2.start();
            JOptionPane.showMessageDialog(this, "BOŞ BIRAKILAMAZ");
        }
        
        else
        {
      
            if (txtbCevap.getText().equalsIgnoreCase(islemler.word.trim())) {
                if (degisimSayisi>=14) {
                  
                     
                       
                    try {
                           screen.setVisible(false);
                     toplamPuan += puanDegeri;
                     txtbCevap.setEnabled(false);
                     btnHarf.setEnabled(false);
                     btnCvp.setEnabled(false);
                       lblToplam.setText(String.valueOf(toplamPuan));
                       islemler.puanUpdate(kullaniciAdi, toplamPuan);
                       
                       
                         myWriter = new FileWriter("kullanicilar.txt",true);
                        
                        myWriter.write(kullaniciAdi + "        " + toplamPuan + " \n");
                        myWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     JOptionPane.showMessageDialog(this, "Tebrikler! Puanınız : " + toplamPuan);
                   
                }
                else
                {
                    toplamPuan+=puanDegeri;
                    timer.start();
                    txtbCevap.setEnabled(false);
                    
                    soruDegistir();
                     degisimSayisi++;
                }
                       
            }
            else
            {
            cevapClick++;
            timer2.start();
            JOptionPane.showMessageDialog(this, "Bilemediniz");
            }
            
          
        }
       
        
        }
        

    
    
     

    }//GEN-LAST:event_btnCvpActionPerformed

    private void btnHarfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHarfActionPerformed

             startRefreshing();
       
       
         islemler.hang(lblCevap,btnHarf);
         puan();
       
       
    }//GEN-LAST:event_btnHarfActionPerformed

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
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new GamePanel().setVisible(true);
                
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCvp;
    private javax.swing.JButton btnEkle;
    public javax.swing.JButton btnHarf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel lblCevap;
    private javax.swing.JLabel lblPuan;
    private javax.swing.JLabel lblSoru;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTimer2;
    private javax.swing.JLabel lblToplam;
    private javax.swing.JTextField txtbCevap;
    // End of variables declaration//GEN-END:variables
}
