/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz;

import Forme.prikaz.modeli.ModelTabeleKolicinaSastojka;
import Forme.prikaz.mod.NacinForme;
import Sesija.Sesija;
import domen.Sastojak;
import domen.Pica;
import domen.KolicinaSastojka;
import domen.Racun;
import domen.StavkaRacuna;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import javax.swing.ImageIcon;

import sun.security.pkcs11.wrapper.Functions;

/**
 *
 *
 */
public class FrmKreirajPicu extends javax.swing.JDialog {

    ImageIcon slikaLogo = new ImageIcon("logo2.png");

    /**
     * Creates new form FrmKreirajPicu
     */
    public FrmKreirajPicu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        try {
            pripremiFormu();
        } catch (Exception ex) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOmoguciPromene = new javax.swing.JButton();
        lblNazivPice = new javax.swing.JLabel();
        txtNazivPice = new javax.swing.JTextField();
        lblOpisPice = new javax.swing.JLabel();
        lblCena = new javax.swing.JLabel();
        btnSacuvajPicu = new javax.swing.JButton();
        txtCena = new javax.swing.JTextField();
        btnObrisiPicu = new javax.swing.JButton();
        btnIzmeniPicu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOpisPice = new javax.swing.JTextArea();
        panelSastojci = new javax.swing.JPanel();
        cmbSastojci = new javax.swing.JComboBox<>();
        lblSastojak = new javax.swing.JLabel();
        lblGramaza = new javax.swing.JLabel();
        txtGramaza = new javax.swing.JTextField();
        btnDodajSastojak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSastojci = new javax.swing.JTable();
        btnObrisiSastojak = new javax.swing.JButton();
        lblStanje = new javax.swing.JLabel();
        txtStanje = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za kreiranje pice");

        btnOmoguciPromene.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOmoguciPromene.setText("Omogući promene");
        btnOmoguciPromene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmoguciPromeneActionPerformed(evt);
            }
        });

        lblNazivPice.setText("Naziv pice:");

        lblOpisPice.setText("Opis pice:");

        lblCena.setText("Cena:");

        btnSacuvajPicu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSacuvajPicu.setText("Sačuvaj picu");
        btnSacuvajPicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajPicuActionPerformed(evt);
            }
        });

        btnObrisiPicu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnObrisiPicu.setForeground(new java.awt.Color(204, 0, 0));
        btnObrisiPicu.setText("Obriši picu");
        btnObrisiPicu.setEnabled(false);
        btnObrisiPicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPicuActionPerformed(evt);
            }
        });

        btnIzmeniPicu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIzmeniPicu.setText("Izmeni picu");
        btnIzmeniPicu.setEnabled(false);
        btnIzmeniPicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniPicuActionPerformed(evt);
            }
        });

        txtOpisPice.setColumns(20);
        txtOpisPice.setRows(5);
        jScrollPane2.setViewportView(txtOpisPice);

        panelSastojci.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sastojci", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lblSastojak.setText("Sastojci");

        lblGramaza.setText("Kolicina sastojka(g):");

        btnDodajSastojak.setText("Dodaj sastojak");
        btnDodajSastojak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajSastojakActionPerformed(evt);
            }
        });

        tblSastojci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblSastojci);

        btnObrisiSastojak.setText("Obrisi sastojak");
        btnObrisiSastojak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiSastojakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSastojciLayout = new javax.swing.GroupLayout(panelSastojci);
        panelSastojci.setLayout(panelSastojciLayout);
        panelSastojciLayout.setHorizontalGroup(
            panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSastojciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSastojciLayout.createSequentialGroup()
                        .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSastojak)
                            .addComponent(lblGramaza))
                        .addGap(16, 16, 16)
                        .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGramaza)
                            .addComponent(cmbSastojci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDodajSastojak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnObrisiSastojak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        panelSastojciLayout.setVerticalGroup(
            panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSastojciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSastojci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSastojak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGramaza)
                    .addComponent(txtGramaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajSastojak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSastojciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObrisiSastojak)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        lblStanje.setText("Stanje:");

        logo.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelSastojci, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOpisPice)
                            .addComponent(lblCena)
                            .addComponent(lblStanje)
                            .addComponent(lblNazivPice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNazivPice, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCena, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                .addComponent(txtStanje))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnIzmeniPicu, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(btnSacuvajPicu, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(btnObrisiPicu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOmoguciPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(461, 461, 461))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCena))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStanje)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNazivPice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNazivPice))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOpisPice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSastojci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOmoguciPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeniPicu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSacuvajPicu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnObrisiPicu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajPicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajPicuActionPerformed
        try {

            Pica p = provera();
            if (p != null) {
                proveriNaziv(p.getNazivPice());
                ModelTabeleKolicinaSastojka model = (ModelTabeleKolicinaSastojka) tblSastojci.getModel();
                List<KolicinaSastojka> lista = model.getSastojak();
                if (lista.isEmpty()) {
                    throw new Exception("Popuni sastojke pice!");
                }

                Komunikacija.getInstanca().sacuvajPicu(p);
                popuniKombo();
                JOptionPane.showMessageDialog(this, "Uspešno sačuvana pica!", "Sačuvana pica", JOptionPane.INFORMATION_MESSAGE);

                ocistiFormu();
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajPicuActionPerformed

    private void btnOmoguciPromeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmoguciPromeneActionPerformed
        Sesija.getInstanca().pripremiIzgledPice(NacinForme.OMOGUCI_IZMENE);
        txtGramaza.setText("1");
    }//GEN-LAST:event_btnOmoguciPromeneActionPerformed

    private void btnDodajSastojakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajSastojakActionPerformed

        try {
            Sastojak h = (Sastojak) cmbSastojci.getSelectedItem();
            if (h == null) {
                return;
            }
            if (txtGramaza.getText().isEmpty()) {
                throw new Exception("Morate uneti gramazu!");
            }
            String gramaza = txtGramaza.getText().trim();

            //  validacijaPolja(gramaza);
            double iznosUGramima = Double.valueOf(gramaza);
            ModelTabeleKolicinaSastojka model = (ModelTabeleKolicinaSastojka) tblSastojci.getModel();

            izbaciSastojak(h);
            KolicinaSastojka gram = new KolicinaSastojka();
            gram.setSastojak(h);
            gram.setKolicina(iznosUGramima);
            model.dodajSastojak(gram);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajSastojakActionPerformed

    private void btnObrisiSastojakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiSastojakActionPerformed
        try {
            int red = tblSastojci.getSelectedRow();
            if (red < 0) {
                throw new Exception("Morate izabrati red!");
            }
            ModelTabeleKolicinaSastojka model = (ModelTabeleKolicinaSastojka) tblSastojci.getModel();
            List<KolicinaSastojka> gramaze = model.getSastojak();
            Sastojak s = gramaze.get(red).getSastojak();
            model.obrisiSastojak(red);

            cmbSastojci.addItem(s);
            btnDodajSastojak.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiSastojakActionPerformed

    private void btnIzmeniPicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniPicuActionPerformed
        try {
            Pica p = provera();
            Pica pr = (Pica) Sesija.getInstanca().vratiParametar("Pica");

            p.setID(pr.getPicaID());
            Komunikacija.getInstanca().izmeniPicu(p);
            JOptionPane.showMessageDialog(this, "Uspešno izmenjena pica!", "Izmena pice", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Sesija.getInstanca().osveziFormuPretragaPica(p);

        } catch (Exception ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzmeniPicuActionPerformed

    private void btnObrisiPicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPicuActionPerformed
        try {

            Komunikacija.getInstanca().proveriServer();
            Pica p = (Pica) Sesija.getInstanca().vratiParametar("Pica");
            int i = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete picu?", "Message", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                Komunikacija.getInstanca().obrisiPicu(p);
                JOptionPane.showMessageDialog(this, "Pica je uspešno izbrisana", "Brisanje pice", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                Sesija.getInstanca().osveziFormuPretragaPica(null);
            } else {
                throw new Exception("Pica nije obrisana!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnObrisiPicuActionPerformed

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
            java.util.logging.Logger.getLogger(FrmKreirajPicu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajPicu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajPicu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajPicu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKreirajPicu dialog = new FrmKreirajPicu(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDodajSastojak;
    private javax.swing.JButton btnIzmeniPicu;
    private javax.swing.JButton btnObrisiPicu;
    private javax.swing.JButton btnObrisiSastojak;
    private javax.swing.JButton btnOmoguciPromene;
    private javax.swing.JButton btnSacuvajPicu;
    private javax.swing.JComboBox<Object> cmbSastojci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblGramaza;
    private javax.swing.JLabel lblNazivPice;
    private javax.swing.JLabel lblOpisPice;
    private javax.swing.JLabel lblSastojak;
    private javax.swing.JLabel lblStanje;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelSastojci;
    private javax.swing.JTable tblSastojci;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtGramaza;
    private javax.swing.JTextField txtNazivPice;
    private javax.swing.JTextArea txtOpisPice;
    private javax.swing.JTextField txtStanje;
    // End of variables declaration//GEN-END:variables

    private void validacijaPolja(String procenat) throws Exception {
        if (procenat.isEmpty()) {
            throw new Exception("Polje za gramazu ne može biti prazno!");
        }
        String regex = "[0-9]{0,3}(\\.[0-9]*)?";
        if (!procenat.matches(regex)) {
            throw new Exception("Unesite bilo koji realan broj od 0 do 100!");
        }
    }

    private void izbaciSastojak(Sastojak h) {
        cmbSastojci.removeItem(h);
    }

    private void validacija(double iznosUGramima, double ukupno) throws Exception {
        if (iznosUGramima < 0) {
            throw new Exception("Iznos u gramimа mora biti broj koji je pozitivan ili jednak nuli");
        }
        if (ukupno + iznosUGramima > 100) {
            throw new Exception("Svaka pica sadrzi do 100 grama");
        }
    }

    public JButton getBtnDodajSastojak() {
        return btnDodajSastojak;
    }

    public void setBtnDodajSastojak(JButton btnDodajSastojak) {
        this.btnDodajSastojak = btnDodajSastojak;
    }

    public JButton getBtnIzmeniPicu() {
        return btnIzmeniPicu;
    }

    public void setBtnIzmeniPicu(JButton btnIzmeniPicu) {
        this.btnIzmeniPicu = btnIzmeniPicu;
    }

    public JButton getBtnObrisiSastojak() {
        return btnObrisiSastojak;
    }

    public void setBtnObrisiSastojak(JButton btnObrisiSastojak) {
        this.btnObrisiSastojak = btnObrisiSastojak;
    }

    public JButton getBtnObrisiPicu() {
        return btnObrisiPicu;
    }

    public void setBtnObrisiPicu(JButton btnObrisiPicu) {
        this.btnObrisiPicu = btnObrisiPicu;
    }

    public JButton getBtnOmoguciPromene() {
        return btnOmoguciPromene;
    }

    public void setBtnOmoguciPromene(JButton btnOmoguciPromene) {
        this.btnOmoguciPromene = btnOmoguciPromene;
    }

    public JButton getBtnSacuvajPicu() {
        return btnSacuvajPicu;
    }

    public void setBtnSacuvajPicu(JButton btnSacuvajPicu) {
        this.btnSacuvajPicu = btnSacuvajPicu;
    }

    public JComboBox<Object> getCmbSastojci() {
        return cmbSastojci;
    }

    public void setCmbSastojci(JComboBox<Object> cmbSastojci) {
        this.cmbSastojci = cmbSastojci;
    }

    public JTable getTblSastojci() {
        return tblSastojci;
    }

    public void setTblSastojci(JTable tblSastojci) {
        this.tblSastojci = tblSastojci;
    }

    public JLabel getLblCena() {
        return lblCena;
    }

    public void setLblCena(JLabel lblCena) {
        this.lblCena = lblCena;
    }

    public JLabel getLblSastojak() {
        return lblSastojak;
    }

    public void setLblSastojak(JLabel lblSastojak) {
        this.lblSastojak = lblSastojak;
    }

    public JLabel getLblNazivPice() {
        return lblNazivPice;
    }

    public void setLblNazivPice(JLabel lblNazivPice) {
        this.lblNazivPice = lblNazivPice;
    }

    public JLabel getLblOpisPice() {
        return lblOpisPice;
    }

    public void setLblOpisPice(JLabel lblOpisPice) {
        this.lblOpisPice = lblOpisPice;
    }

    public JLabel getLblGramaza() {
        return lblGramaza;
    }

    public void setLblGramaza(JLabel lblGramaza) {
        this.lblGramaza = lblGramaza;
    }

    public JLabel getLblStanje() {
        return lblStanje;
    }

    public void setLblStanje(JLabel lblStanje) {
        this.lblStanje = lblStanje;
    }

    public JTextField getTxtCena() {
        return txtCena;
    }

    public void setTxtCena(JTextField txtCena) {
        this.txtCena = txtCena;
    }

    public JTextField getTxtNazivPice() {
        return txtNazivPice;
    }

    public void setTxtNazivPice(JTextField txtNazivPice) {
        this.txtNazivPice = txtNazivPice;
    }

    public JTextArea getTxtOpisPice() {
        return txtOpisPice;
    }

    public void setTxtOpisPice(JTextArea txtOpisPice) {
        this.txtOpisPice = txtOpisPice;
    }

    public JTextField getTxtGramaza() {
        return txtGramaza;
    }

    public void setTxtGramaza(JTextField txtGramaza) {
        this.txtGramaza = txtGramaza;
    }

    public JTextField getTxtStanje() {
        return txtStanje;
    }

    public void setTxtStanje(JTextField txtStanje) {
        this.txtStanje = txtStanje;
    }

    public void popuniKombo() throws Exception {

        try {
            List<Sastojak> sastojci = new ArrayList<>();

            cmbSastojci.removeAllItems();
            sastojci = Komunikacija.getInstanca().ucitajListuSastojaka();

            for (Sastojak sastojak : sastojci) {
                cmbSastojci.addItem(sastojak);

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    private void pripremiFormu() throws Exception {
        logo.setText("");
        logo.setIcon(slikaLogo);
        popuniKombo();
        Sesija.getInstanca().setKreirajPicu(this);
        Sesija.getInstanca().pripremiIzgledPice(NacinForme.KREIRAJ);
    }

    private Pica provera() throws Exception {
        try {

            String nazivPice = txtNazivPice.getText().trim();

            String opisPice = txtOpisPice.getText().trim();
            String cenaString = txtCena.getText().trim();
            String stanjeString = txtStanje.getText().trim();

            provera1();

            String poruka = validacija(nazivPice, opisPice, cenaString, stanjeString);
            if (!poruka.isEmpty()) {
                throw new Exception(poruka);
            }
            if (opisPice.toCharArray().length > 100) {
                throw new Exception("U polje opis pice moze stati najvise 100 karaktera!");
            }
            BigDecimal cena = new BigDecimal(cenaString);

            int stanje = Integer.valueOf(stanjeString);

            ModelTabeleKolicinaSastojka model = (ModelTabeleKolicinaSastojka) tblSastojci.getModel();

            List<KolicinaSastojka> kolicine = model.getSastojak();

            Pica p = new Pica();
            p.setNazivPice(nazivPice);
            p.setOpisPice(opisPice);
            p.setCena(cena);
            p.setStanje(stanje);
            p.setKolicinaSastojaka(kolicine);
            return p;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return null;
    }

    private String validacija(String nazivPice, String opisPice, String cenaString, String stanjeString) throws Exception {
        String poruka = "";
        poruka += validacijaNazivaIOpisa(nazivPice, opisPice);
        poruka += validacijaCene(cenaString);
        poruka += validacijaStanja(stanjeString);
        return poruka;
    }

    private String validacijaNazivaIOpisa(String nazivPice, String opisPice) throws Exception {
        String naziv = "[A-Za-z]";
        String poruka = "";
        if (nazivPice.isEmpty() || !nazivPice.substring(0, 1).matches(naziv)) {
            poruka += "Naziv pice mora poceti slovom!\n";
        }
        if (opisPice.isEmpty() || !opisPice.substring(0, 1).matches(naziv)) {
            poruka += "Opis pice mora poceti slovom!\n";
        }
        return poruka;
    }

    private String validacijaCene(String cenaString) {
        char[] niz = cenaString.toCharArray();
        for (int i = 0; i < niz.length; i++) {
            if (!(Character.isDigit(niz[i]) || niz[i] == '.')) {
                return "Cena mora da sadrži samo brojeve!\n";
            }
        }
        return "";
    }

    private String validacijaStanja(String stanjeString) {

        char[] niz = stanjeString.toCharArray();
        for (char c : niz) {
            if (!(Character.isDigit(c) && c >= 0)) {
                return "Stanje može biti bilo koji ceo broj veći ili jednak nuli!\n";

            }

        }
        return "";
    }

    private void ocistiFormu() throws Exception {
        txtNazivPice.setText("");
        txtOpisPice.setText("");
        txtCena.setText("");
        txtStanje.setText("");
        Sesija.getInstanca().pripremiIzgledPice(NacinForme.KREIRAJ);
    }

    private void provera1() throws Exception {
        if (txtCena.getText().isEmpty() || txtNazivPice.getText().isEmpty() || txtOpisPice.getText().isEmpty()
                || txtGramaza.getText().isEmpty() || txtStanje.getText().isEmpty()) {
            throw new Exception("Sva polja moraju biti popunjena!");
        }
    }

    private void proveriNaziv(String nazivPice) throws Exception {
        List<Pica> pice = (List<Pica>) Komunikacija.getInstanca().prikaziPicu();

        for (Pica pica : pice) {
            if (pica.getNazivPice().equalsIgnoreCase(nazivPice)) {
                throw new Exception("Naziv pice mora biti jedinstveno!");
            }

        }

    }

}
