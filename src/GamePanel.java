
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
      
       SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
       Date date = new Date(System.currentTimeMillis());
      
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
                        timer.stop();
                       myWriter = new FileWriter("kullanicilar.txt",true);
                        
                       myWriter.write(kullaniciAdi + "    " + toplamPuan + "    "+ lblTimer.getText() + "    "  + formatter.format(date) + "\n");
                       
                       myWriter.close();
                 JOptionPane.showMessageDialog(this, "Tebrikler " + kullaniciAdi + "\n" + "Puanınız : " + toplamPuan + "\n" + "Kalan zamanınız : " + lblTimer.getText() + "\n" +"Tarih : " + formatter.format(date));

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
                       
                       txtbCevap.setEnabled(false);
                       btnHarf.setEnabled(false);
                       btnCvp.setEnabled(false);
                       lblToplam.setText(String.valueOf(toplamPuan));
                       islemler.puanUpdate(kullaniciAdi, toplamPuan);
                       myWriter = new FileWriter("kullanicilar.txt",true);
                        
                       myWriter.write(kullaniciAdi + "    " + toplamPuan + "    "+ lblTimer.getText() + "    "  + formatter.format(date) + "\n");
                       
                       myWriter.close();
                       timer.stop();
                       timer2.stop();
                 JOptionPane.showMessageDialog(this, "Tebrikler " + kullaniciAdi + "\n" + "Puanınız : " + toplamPuan + "\n" + "Kalan zamanınız : " + lblTimer.getText() + "\n" +"Tarih : " + formatter.format(date));

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
                        
                       myWriter.write(kullaniciAdi + "    " + toplamPuan + "    "+ lblTimer.getText() + "    "  + formatter.format(date) + "\n");
                       
                       myWriter.close();
                       timer.stop();
                      
                       lblTimer.setText("0:00");
                 JOptionPane.showMessageDialog(this, "Tebrikler " + kullaniciAdi + "\n" + "Puanınız : " + toplamPuan + "\n" + "Kalan zamanınız : " + lblTimer.getText() + "\n" +"Tarih : " + formatter.format(date));
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
    int dakika = 4;
    
    
    public String hiddenWord(){
     hyphen = islemler.cevapGetir(id);
     String dashes = hyphen.replaceAll("[^ ]", "-");
     return dashes;
     
                }
    
    
    public void setBackGround()
    {
        getContentPane().setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\Mert\\Documents\\NetBeansProjects\\KelimeOyunu\\src\\JAVA ARKA PLAN-2.jpg"));
        getContentPane().add(background);
        background.setLayout(new FlowLayout());
    }
    
    
    public GamePanel() {
        
        
        initComponents();
        setBackGround();
        
        txtbCevap.setEnabled(false);
     
         timer = new Timer(1000, new ActionListener() {
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Soru : ");

        lblPuan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPuan.setForeground(new java.awt.Color(255, 255, 255));
        lblPuan.setText("Puan Değeri :");

        lblSoru.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSoru.setForeground(new java.awt.Color(255, 255, 255));
        lblSoru.setText("Sorunun Tamamı");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cevabınız :");

        btnCvp.setBackground(new java.awt.Color(255, 0, 51));
        btnCvp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCvp.setForeground(new java.awt.Color(255, 255, 255));
        btnCvp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/idea.png"))); // NOI18N
        btnCvp.setText("Cevapla");
        btnCvp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCvpActionPerformed(evt);
            }
        });

        lblCevap.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblCevap.setForeground(new java.awt.Color(255, 255, 255));
        lblCevap.setText("cevap");

        btnHarf.setBackground(new java.awt.Color(255, 0, 51));
        btnHarf.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHarf.setForeground(new java.awt.Color(255, 255, 255));
        btnHarf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/technology.png"))); // NOI18N
        btnHarf.setText("Harf Al");
        btnHarf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHarfActionPerformed(evt);
            }
        });

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setText("lblTimer");

        lblToplam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblToplam.setForeground(new java.awt.Color(255, 255, 255));
        lblToplam.setText("Puanınız : ");

        lblTimer2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer2.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer2.setText("20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoru, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                    .addComponent(lblPuan, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblToplam, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCevap, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCvp, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHarf, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTimer)
                                    .addComponent(txtbCevap, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTimer2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSoru))
                .addGap(18, 18, 18)
                .addComponent(lblPuan)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblToplam))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(lblCevap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimer)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtbCevap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCvp, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHarf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblTimer2)))
                .addGap(121, 121, 121))
        );

        lblCevap.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                         toplamPuan-=puanDegeri;
                        startRefreshingSn();
                    }
                    else if(saniye2==0)
                    {
                        
                        cevapClick++;
                        toplamPuan-=puanDegeri;
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

                            myWriter.write(kullaniciAdi + "    " + toplamPuan + "    "+ lblTimer.getText() + "    "  + formatter.format(date) + "\n");
                            myWriter.close();
                        } catch (IOException ex) {
                            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(this, "Tebrikler " + kullaniciAdi + "\n" + "Puanınız : " + toplamPuan + "\n" + "Kalan zamanınız : " + lblTimer.getText() + "\n" +"Tarih : " + formatter.format(date));

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
    public javax.swing.JButton btnHarf;
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
