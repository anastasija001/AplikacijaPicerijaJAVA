/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz;

import Forme.prikaz.modeli.ModelTabelePretraziRacun;
import Forme.prikaz.modeli.ModelTabeleStavkaRacuna;
import Forme.prikaz.mod.NacinForme;
import Sesija.Sesija;
import domen.Korisnik;
import domen.Pica;
import domen.Racun;
import domen.StavkaRacuna;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class FrmKreirajRacun extends javax.swing.JDialog {

    ImageIcon slikaLogo = new ImageIcon("logo2.png");

    /**
     * Creates new form FrmKreirajRacun
     */
    public FrmKreirajRacun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        pripremi();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStorniraj = new javax.swing.JButton();
        lblBrojRacuna = new javax.swing.JLabel();
        lblUkupnaVrednost = new javax.swing.JLabel();
        txtUkupnaVrednost = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        txtBrojRacuna = new javax.swing.JTextField();
        btnObradi = new javax.swing.JButton();
        panelStavke = new javax.swing.JPanel();
        lblPica = new javax.swing.JLabel();
        cmbPice = new javax.swing.JComboBox<>();
        lblKolicina = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        lblDatum = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        btnOmoguciPromene = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za kreiranje računa");

        btnStorniraj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStorniraj.setForeground(new java.awt.Color(204, 0, 0));
        btnStorniraj.setText("Storniraj račun");
        btnStorniraj.setEnabled(false);
        btnStorniraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStornirajActionPerformed(evt);
            }
        });

        lblBrojRacuna.setText("Broj računa:");

        lblUkupnaVrednost.setText("Ukupna vrednost (sa PDV-om):");

        txtUkupnaVrednost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUkupnaVrednost.setText("0.0");
        txtUkupnaVrednost.setEnabled(false);
        txtUkupnaVrednost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUkupnaVrednostActionPerformed(evt);
            }
        });

        btnSacuvaj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSacuvaj.setText("Sačuvaj račun");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnObradi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnObradi.setText("Obradi račun");
        btnObradi.setEnabled(false);
        btnObradi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObradiActionPerformed(evt);
            }
        });

        panelStavke.setBackground(new java.awt.Color(255, 255, 255));
        panelStavke.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke računa"));

        lblPica.setText("Pica");

        lblKolicina.setText("Količina:");

        txtKolicina.setText("1");
        txtKolicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKolicinaActionPerformed(evt);
            }
        });

        tblStavke.setForeground(new java.awt.Color(153, 153, 153));
        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStavke.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblStavke.setGridColor(new java.awt.Color(51, 153, 0));
        tblStavke.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tblStavke);
        tblStavke.getAccessibleContext().setAccessibleName("");
        tblStavke.getAccessibleContext().setAccessibleDescription("");

        btnDodaj.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(51, 204, 0));
        btnDodaj.setText("Dodaj stavku računa");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(255, 51, 51));
        btnObrisi.setText("Obriši stavku računa");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelStavkeLayout = new javax.swing.GroupLayout(panelStavke);
        panelStavke.setLayout(panelStavkeLayout);
        panelStavkeLayout.setHorizontalGroup(
            panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStavkeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(panelStavkeLayout.createSequentialGroup()
                        .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKolicina)
                            .addComponent(lblPica))
                        .addGap(18, 18, 18)
                        .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKolicina)
                            .addComponent(cmbPice, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi)))
        );
        panelStavkeLayout.setVerticalGroup(
            panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStavkeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPica)
                    .addComponent(cmbPice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKolicina)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStavkeLayout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(btnObrisi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblDatum.setText("Datum (dd.mm.yyyy.):");

        btnOmoguciPromene.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnOmoguciPromene.setText("Promeni račun");
        btnOmoguciPromene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmoguciPromeneActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("PDV = 22%");

        logo.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(299, 812, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStorniraj, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOmoguciPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObradi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBrojRacuna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUkupnaVrednost)
                                    .addComponent(lblDatum))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBrojRacuna, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(txtDatum)
                                    .addComponent(txtUkupnaVrednost))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBrojRacuna)
                            .addComponent(txtBrojRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDatum)
                            .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUkupnaVrednost)
                            .addComponent(txtUkupnaVrednost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStorniraj, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOmoguciPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObradi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObradiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObradiActionPerformed
        try {
            Racun racun = (Racun) Sesija.getInstanca().vratiParametar("Racun");
            racun.setObradjen(true);
            Komunikacija.getInstanca().obradiRacun(racun);
            JOptionPane.showMessageDialog(this, "Račun je uspešno obrađen!", "Obrada računa", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Sesija.getInstanca().osveziFormuPretragaRacuna();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObradiActionPerformed

    private void txtUkupnaVrednostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUkupnaVrednostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUkupnaVrednostActionPerformed

    private void txtKolicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKolicinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKolicinaActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {

            validacija1();
            Racun racun = proveriRacun();
            validacijaBroja(racun.getBrojRacuna());
            validacijaListe(racun.getListaStavki());

            proveraStanja();
            Komunikacija.getInstanca().sacuvajRacun(racun);
            JOptionPane.showMessageDialog(this, "Račun je uspešno sačuvan!", "Uspešno", JOptionPane.INFORMATION_MESSAGE);

            ocistiFormu();
        } catch (Exception ex) {
            txtKolicina.setText("1");
            cmbPice.setSelectedItem(0);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {

            Pica pica = (Pica) cmbPice.getSelectedItem();
            if (pica == null) {
                return;
            }

            BigDecimal cena = pica.getCena();
            String kolicinaTxt = txtKolicina.getText();
            String validacija = validacija(kolicinaTxt);

            if (!validacija.isEmpty()) {
                throw new Exception(validacija);
            }
            int kolicina = Integer.valueOf(kolicinaTxt);
            if (kolicina > pica.getStanje()) {
                throw new Exception("Nema dovoljno pica na stanju");
            }
            Racun c = new Racun();

            double PDV = c.getPoreskaStopa() / 100;

            BigDecimal pdv = new BigDecimal(PDV);

            BigDecimal iznosPoreza = cena.multiply(pdv);
            BigDecimal ukupna = cena.add(iznosPoreza);

            ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) tblStavke.getModel();
            StavkaRacuna stavkaRacuna = new StavkaRacuna();
            stavkaRacuna.setPica(pica);
            stavkaRacuna.setKolicina(kolicina);

            stavkaRacuna.setUkupnaCena(ukupna.multiply(new BigDecimal(kolicina)));

            BigDecimal ukupno = mts.dodajStavku(stavkaRacuna);
            System.out.println(stavkaRacuna.getUkupnaCena());
            ukupno = ukupno.setScale(2, RoundingMode.HALF_UP);
            txtUkupnaVrednost.setText(ukupno + "");
            izbaciIzCmb(pica);
            osveziPolja();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            int red = tblStavke.getSelectedRow();
            if (red < 0) {
                throw new Exception("Morate izabrati stavku!");
            }
            ModelTabeleStavkaRacuna model = (ModelTabeleStavkaRacuna) tblStavke.getModel();
            StavkaRacuna s = model.vratiStavku(red);
            BigDecimal ukupno = model.obrisiStavku(red);
            txtUkupnaVrednost.setText(String.valueOf(ukupno));
            ubaciPice(s);
            osveziPoljaStavke();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnOmoguciPromeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmoguciPromeneActionPerformed
        try {
            Racun racun = (Racun) Sesija.getInstanca().vratiParametar("Racun");
            Korisnik korisnik = (Korisnik) Sesija.getInstanca().vratiParametar("Korisnik");
            if (!korisnik.getKorisnickoIme().equals(racun.getKorisnik().getKorisnickoIme())) {
                throw new Exception("Samo zaposleni koji je kreirao račun može da vrši promene nad njim!");
            }
            if (racun.isObradjen()) {
                throw new Exception("Ne možete vršiti promene nad obrađenim računom!");
            }
            if (racun.isStorniran()) {
                throw new Exception("Ne možete vršiti promene nad storniranim računom!");
            }
            Sesija.getInstanca().pripremiIzgledRacun(NacinForme.OMOGUCI_IZMENE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOmoguciPromeneActionPerformed

    private void btnStornirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStornirajActionPerformed
        try {
            Racun racun = (Racun) Sesija.getInstanca().vratiParametar("Racun");
            if (racun.isStorniran()) {
                this.dispose();
                throw new Exception("Ne možete vršiti promene nad storniranim računom!");
            }
            racun.setStorniran(true);
            Komunikacija.getInstanca().stornirajRacun(racun);
            ModelTabelePretraziRacun tbl = (ModelTabelePretraziRacun) Sesija.getInstanca().vratiParametar("Tabela racuna");

            List<Racun> lista = tbl.vratiListu();
            for (Racun racun1 : lista) {
                if (racun.getRacunID().equals(racun1.getRacunID())) {
                    racun1 = racun;
                    Sesija.getInstanca().dodajParametar("Lista", lista);
                }

            }
            JOptionPane.showMessageDialog(this, "Račun je uspešno storniran!", "Storniranje računa", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnStornirajActionPerformed

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
            java.util.logging.Logger.getLogger(FrmKreirajRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKreirajRacun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKreirajRacun dialog = new FrmKreirajRacun(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObradi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOmoguciPromene;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnStorniraj;
    private javax.swing.JComboBox<Object> cmbPice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojRacuna;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblPica;
    private javax.swing.JLabel lblUkupnaVrednost;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelStavke;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtBrojRacuna;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtUkupnaVrednost;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtBrojRacuna() {
        return txtBrojRacuna;
    }

    public JTextField getTxtDatum() {
        return txtDatum;
    }

    public JTextField getTxtKolicina() {
        return txtKolicina;
    }

    public JTextField getTxtUkupnaVrednost() {
        return txtUkupnaVrednost;
    }

    public JComboBox<Object> getCmbPice() {
        return cmbPice;
    }

    public JButton getBtnDodaj() {
        return btnDodaj;
    }

    public JButton getBtnObradi() {
        return btnObradi;
    }

    public JButton getBtnObrisi() {
        return btnObrisi;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public JButton getBtnStorniraj() {
        return btnStorniraj;
    }

    public JButton getBtnOmoguciPromene() {
        return btnOmoguciPromene;
    }

    public JTable getTblStavke() {
        return tblStavke;
    }

    private Racun proveriRacun() throws Exception {

        String brojRacuna = txtBrojRacuna.getText().trim();
        String datum = txtDatum.getText();
        String poruka = validacijaRacuna(brojRacuna, datum);
        if (!poruka.isEmpty()) {
            throw new Exception(poruka);
        }

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
        Racun racun = new Racun();
        racun.setBrojRacuna(brojRacuna);
        racun.setDatum(df.parse(datum));
        racun.setObradjen(false);
        racun.setStorniran(false);
        racun.setKorisnik((Korisnik) Sesija.getInstanca().vratiParametar("Korisnik"));
        racun.setUkupnaVrednost(new BigDecimal(txtUkupnaVrednost.getText()));

        ModelTabeleStavkaRacuna model = (ModelTabeleStavkaRacuna) tblStavke.getModel();
        racun.setListaStavki(model.getStavke());
        return racun;
    }

    private void ocistiFormu() {

        ModelTabeleStavkaRacuna modelTabele = new ModelTabeleStavkaRacuna(new ArrayList<>());
        tblStavke.setModel(modelTabele);
        txtKolicina.setText("");
        popuniKombo();

    }

    private String validacijaRacuna(String brojRacuna, String datum) {
        String poruka = "";
        poruka += validacijaBrojaRacuna(brojRacuna);
        poruka += validacijaDatuma(datum);
        return poruka;
    }

    private String validacijaBrojaRacuna(String brojRacuna) {
        if (!brojRacuna.contains("-")) {
            return "Broj računa mora sadržati crticu između imena kupca i broja!\n";
        }

        int brojac = 0;

        for (char c : brojRacuna.toCharArray()) {
            if (c == '-') {
                brojac++;
            }

        }

        if (brojac > 1) {
            return "Broj računa može sadržati samo jednu -!\n";
        }
        String poruka = "";
        String[] niz = brojRacuna.split("-");
        String regex1 = "[a-zA-Z]";
        if (!niz[0].substring(0, 1).matches(regex1)) {
            poruka += "Ime kupca mora početi slovom!\n";
        }
        String regex2 = "[0-9]{1,6}";
        if (!niz[1].matches(regex2)) {
            poruka += "Broj mora da sadrži od 1 do 6 cifara!\n";
        }
        return poruka;
    }

    private String validacijaDatuma(String datum) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
        Date date;
        try {
            date = df.parse(datum);
        } catch (ParseException ex) {
            return "Morate uneti datum u formatu dd.MM.yyyy.\n";
        }
        if (date.after(new Date())) {
            return "Datum ne može biti nakon današnjeg!\n";
        }
        return "";
    }

    private String validacija(String kolicinaTxt) {
        String povratnaVrednost = "";

        povratnaVrednost += proveraKolicine(kolicinaTxt);
        return povratnaVrednost;
    }

    private String proveraKolicine(String kolicinaTxt) {
        String regex = "([1-9]|[1-9][0-9]*)";
        if (!kolicinaTxt.matches(regex)) {
            return "Količina može biti bilo koji ceo broj veći od nule!\n";
        }
        return "";
    }

    private void izbaciIzCmb(Pica pica) {
        cmbPice.removeItem(pica);
    }

    private void osveziPolja() {

        txtKolicina.setText("1");

    }

    private void ubaciPice(StavkaRacuna s) {
        Pica p = s.getPica();
        p.setCena((BigDecimal) Sesija.getInstanca().vratiParametar("Cena"));
        cmbPice.addItem(p);
    }

    private void osveziPoljaStavke() {
        //  cmbPice.setSelectedIndex(-1);
        txtKolicina.setText("");

    }

    public void pripremi() {
        try {
            popuniKombo();
            logo.setText("");

            logo.setIcon(slikaLogo);
            Sesija.getInstanca().setKreirajR(this);
            Sesija.getInstanca().pripremiIzgledRacun(NacinForme.KREIRAJ);
        } catch (Exception e) {
        }
    }

    private void popuniKombo() {

        try {
            List<Pica> pice = Komunikacija.getInstanca().prikaziPicu();
            for (Pica pica : pice) {
                cmbPice.addItem(pica);

            }
            cmbPice.setSelectedIndex(-1);
        } catch (Exception ex) {

        }
    }

    private void validacija1() throws Exception {
        if (txtBrojRacuna.getText().isEmpty() || txtKolicina.getText().isEmpty()) {
            throw new Exception("Sva polja moraju biti popunjena!");
        }
    }

    private void proveraStanja() throws Exception {
        ModelTabeleStavkaRacuna model = (ModelTabeleStavkaRacuna) tblStavke.getModel();
        List<StavkaRacuna> lista = model.getStavke();
        String poruka = "Pice koje nemaju dovoljnu kolicinu na stanju: ";
        int brojac = 0;
        for (StavkaRacuna stavkaRacuna : lista) {
            System.out.println(stavkaRacuna.getRBStavke() + "    ");
        }
        for (StavkaRacuna stavkaRacuna : lista) {
            System.out.println("Prvo: " + stavkaRacuna.getPica().getStanje());
            System.out.println("drugo:" + stavkaRacuna.getKolicina());
            if (stavkaRacuna.getPica().getStanje() < stavkaRacuna.getKolicina()) {
                poruka += stavkaRacuna.getPica().getNazivPice() + " ";
                brojac++;

            }
        }
        if (brojac != 0) {
            throw new Exception(poruka);
        }

    }

    private void validacijaBroja(String brojRacuna) throws Exception {

        List<Racun> racuni = Komunikacija.getInstanca().prikaziRacune();
        for (Racun racun : racuni) {
            if (racun.getBrojRacuna().equals(brojRacuna)) {
                throw new Exception("Broj racuna je jedinstven!");
            }

        }

    }

    private void validacijaListe(List<StavkaRacuna> listaStavki) throws Exception {

        ModelTabeleStavkaRacuna model = (ModelTabeleStavkaRacuna) tblStavke.getModel();
        List<StavkaRacuna> lista = model.getStavke();

        if (lista.isEmpty()) {
            throw new Exception("Uneti stavke prvo!");
        }
    }
}
