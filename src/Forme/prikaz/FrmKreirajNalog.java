/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz;

import Sesija.Sesija;
import Sesija.Sesija;

import domen.Korisnik;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import komunikacija.Komunikacija;

/**
 *
 *
 */
public class FrmKreirajNalog extends javax.swing.JDialog {

    /**
     * Creates new form FrmKreirajNalog
     */
    public FrmKreirajNalog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtPassword.setEchoChar('*');
        setLocationRelativeTo(null);
        srediLogo();
    }
    
  


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblKorisnickoIme = new javax.swing.JLabel();
        lblSifra = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnKreirajNalog = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma kreiraj nalog");

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        lblKorisnickoIme.setText("Korisničko ime:");

        lblSifra.setText("Šifra:");

        btnKreirajNalog.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnKreirajNalog.setText("Kreiraj nalog");
        btnKreirajNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajNalogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIme)
                                    .addComponent(lblPrezime))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIme)
                                    .addComponent(txtPrezime)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 373, Short.MAX_VALUE)
                                .addComponent(btnKreirajNalog, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKorisnickoIme)
                                    .addComponent(lblSifra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKorisnickoIme)
                                    .addComponent(txtPassword))))
                        .addGap(36, 36, 36))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIme)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKorisnickoIme))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSifra))
                .addGap(18, 18, 18)
                .addComponent(btnKreirajNalog, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajNalogActionPerformed
        try {
                   if(Komunikacija.getInstanca().getSoket()==null){
                       throw new Exception("Server nije pokrenut");
                   }
            
            String ime = txtIme.getText().trim();
                    String prezime = txtPrezime.getText().trim();
                    String korisnickoIme = txtKorisnickoIme.getText().trim();
                    String sifra = String.valueOf(txtPassword.getPassword());
                    String poruka = validacijaPodataka(ime, prezime, korisnickoIme, sifra);
                    if (!poruka.isEmpty()) {
                        throw new Exception(poruka);
                    }
                    Korisnik k = new Korisnik();
                    k.setIme(ime);
                    k.setPrezime(prezime);
                    k.setKorisnickoIme(korisnickoIme);
                    k.setSifra(sifra);
                    
                    //validacija(korisnickoIme);
                    
                   
                    Komunikacija.getInstanca().kreirajNalog(k);
                    JOptionPane.showMessageDialog(this, "Nalog je uspešno kreiran!", "Kreiranje naloga", JOptionPane.INFORMATION_MESSAGE);
                 
                    ocistiFormu();
                  
                    Sesija.getInstanca().dodajParametar("Korisnik", k);
                    
                    System.out.println(k.getIme());
                    new FrmMain().setVisible(true);
                } catch (Exception ex) {
                   
                    JOptionPane.showMessageDialog(this,ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_btnKreirajNalogActionPerformed

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
            java.util.logging.Logger.getLogger(FrmKreirajNalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajNalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajNalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajNalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKreirajNalog dialog = new FrmKreirajNalog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreirajNalog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

   

   

   

    private String validacijaPodataka(String ime, String prezime, String korisnickoIme, String sifra) {
          
                String poruka = "";
                poruka += validacijaImena(ime);
                poruka += validacijaPrezimena(prezime);
                poruka += validacijaKorisnickogImena(korisnickoIme);
                poruka += validacijaSifre(sifra);
                return poruka;
            
    }
    
     private String validacijaImena(String ime) {
         
         for (char c : ime.toCharArray()) {
             if(!Character.isLetter(c))
                  return "Ime mora sadržati samo slova!\n";
             
         }
              
                return "";
            }

            private String validacijaPrezimena(String prezime) {
                for (char c : prezime.toCharArray()) {
             if(!Character.isLetter(c))
                  return "Prezime mora sadržati samo slova!\n";
             
         }
              
                return "";
            }

            private String validacijaKorisnickogImena(String korisnickoIme) {
                String ki = "[A-Za-z][A-Za-z0-9]*";
                if (!korisnickoIme.matches(ki)) {
                    return "Korisničko ime mora početi slovom i mora sadržati samo slova i brojeve!\n";
                }
                return "";
            }

            private String validacijaSifre(String sifra) {
                String s = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
                if (!sifra.matches(s)) {
                    return "Šifra mora sadržati barem 8 karaktera, barem 1 malo slovo, barem 1 veliko slovo i barem 1 cifru!\n";
                }
                return "";
            }

            private void ocistiFormu() {
               txtPrezime.setText("");
                txtIme.setText("");
           txtKorisnickoIme.setText("");
               txtPassword.setText("");
            }

    private void srediLogo() {
        ImageIcon slikaLogo=new ImageIcon("logo2.png");
        jLabel3.setText("");
        jLabel3.setIcon(slikaLogo);
    }

    

     
}
