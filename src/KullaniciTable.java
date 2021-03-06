
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mert
 */
public class KullaniciTable extends javax.swing.JFrame {

    /**
     * Creates new form KullaniciTable
     */
    
    
     DefaultTableModel model;

    DatabaseOperation islemler = new DatabaseOperation();
    
     
    public void setBackGround()
    {
        getContentPane().setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\Mert\\Documents\\NetBeansProjects\\KelimeOyunu\\src\\JAVA ARKA PLAN-2.jpg"));
        getContentPane().add(background);
        background.setLayout(new FlowLayout());
    }
    
       public void kullaniciGoruntule()
    {
        model.setRowCount(0);
        ArrayList<KullaniciBilgi> kullanicilar = new ArrayList<KullaniciBilgi>();
        kullanicilar = islemler.kullaniciListele();
        
        if (kullanicilar!=null) {
            for(KullaniciBilgi item : kullanicilar)
            {
             Object[] eklenecek = {item.getKullanici_no(),item.getKullanici_ad(),item.getKullanici_puan()};
             model.addRow(eklenecek);
            }
        }
        
    } 
    
    
    
    public KullaniciTable() {
        
        initComponents();
        
          model = (DefaultTableModel)tblFatura.getModel();

        
         tblFatura.getTableHeader().setOpaque(false);
         DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
         MyHeaderRender.setBackground(new Color(32,136,203));
         MyHeaderRender.setForeground(new Color(255,255,255));

        tblFatura.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        tblFatura.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        tblFatura.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender); 
        
        tblFatura.setRowHeight(25);
        tblFatura.setDefaultEditor(Object.class, null);
        tblFatura.getTableHeader().setReorderingAllowed(false);


     
     
       
        kullaniciGoruntule();
        setBackGround();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFatura = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblFatura.setBackground(new java.awt.Color(255, 0, 51));
        tblFatura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblFatura.setForeground(new java.awt.Color(255, 255, 255));
        tblFatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kullan??c?? No", "Ad", "Puan"
            }
        ));
        tblFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFaturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFatura);

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homepage.png"))); // NOI18N
        jButton1.setText("Giri?? Ekran??na D??n");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFaturaMouseClicked
       


    }//GEN-LAST:event_tblFaturaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginScreen screen = new LoginScreen();
        this.setVisible(false);
        screen.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(KullaniciTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullaniciTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullaniciTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullaniciTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFatura;
    // End of variables declaration//GEN-END:variables
}
