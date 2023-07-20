/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesija;

import Forme.prikaz.FrmKreirajNalog;
import Forme.prikaz.FrmKreirajPicu;
import Forme.prikaz.FrmKreirajRacun;
import Forme.prikaz.FrmPrijava;
import Forme.prikaz.FrmMain;
import Forme.prikaz.FrmPocetna;
import Forme.prikaz.FrmPretragaPica;
import Forme.prikaz.FrmPretraziRacun;
import Forme.prikaz.modeli.ModelTabeleStavkaRacuna;
import Forme.prikaz.modeli.ModelTabeleKolicinaSastojka;
import Forme.prikaz.mod.NacinForme;
import java.util.HashMap;
import java.util.Map;
import domen.Sastojak;
import domen.Korisnik;
import domen.Pica;
import domen.Racun;
import domen.KolicinaSastojka;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Sesija {

    private static Sesija instanca;

    //private final MainKontroler glavniKontroler;
    private FrmKreirajPicu kreirajP;
    private FrmPretragaPica pretragap;
    private FrmKreirajRacun kreirajR;
    private FrmPretraziRacun pretragaR;
    private FrmMain glavna;

    private Korisnik k;

    private final Map<String, Object> parametri;

    private Sesija() {

        parametri = new HashMap<>();
        k = new Korisnik();

    }

    public FrmMain getGlavna() {
        return glavna;
    }

    public void setGlavna(FrmMain glavna) {
        this.glavna = glavna;
    }

    public FrmPretraziRacun getPretragaR() {
        return pretragaR;
    }

    public void setPretragaR(FrmPretraziRacun pretragaR) {
        this.pretragaR = pretragaR;
    }

    public FrmKreirajPicu getPretragaPica() {
        return kreirajP;
    }

    public void setKreirajPicu(FrmKreirajPicu kreirajP) {
        this.kreirajP = kreirajP;
    }

    public static Sesija getInstanca() {
        if (instanca == null) {
            instanca = new Sesija();
        }
       // System.out.println("proverila");
        return instanca;
    }

    public FrmPretragaPica getPretragap() {
        return pretragap;
    }

    public void setPretragap(FrmPretragaPica pretragap) {
        this.pretragap = pretragap;
    }

    public Map<String, Object> getParametri() {
        return parametri;
    }

    public Object vratiParametar(String kljuc) {
        return parametri.get(kljuc);
    }

    public void dodajParametar(String ime, Object object) {
        parametri.put(ime, object);
    }

    public void otvoriFormuZaDetalje(NacinForme nacin) {
        if (kreirajP == null) {
            kreirajP = new FrmKreirajPicu(new FrmMain(), true);
        }
        kreirajP.setLocationRelativeTo(null);
        pripremiIzgledPice(nacin);
        kreirajP.setVisible(true);

    }

    public void otovoriFormuZaDetaljeRacuna() {
        if (kreirajR == null) {
            kreirajR = new FrmKreirajRacun(new FrmMain(), true);
        }

        kreirajR.setLocationRelativeTo(null);

        pripremiIzgledRacun(NacinForme.DETALJI);
        kreirajR.setVisible(true);
    }

    public void osveziFormuPretragaPica(Pica p) {
        pretragap.osvezi(p);

    }

    public void obrisiParametar(String pica) {
        parametri.remove(pica);
    }

    public void osveziFormuPretragaRacuna() {
        pretragaR.osveziFormu();
    }

    public void pripremiIzgledPice(NacinForme nacin) {
        switch (nacin) {
            case KREIRAJ:
                ModelTabeleKolicinaSastojka model = new ModelTabeleKolicinaSastojka(new ArrayList<>());
                kreirajP.getTblSastojci().setModel(model);

                kreirajP.getBtnDodajSastojak().setEnabled(true);
                kreirajP.getBtnObrisiSastojak().setEnabled(true);
                kreirajP.getBtnSacuvajPicu().setEnabled(true);
                kreirajP.getBtnIzmeniPicu().setEnabled(false);
                kreirajP.getBtnObrisiPicu().setEnabled(false);
                kreirajP.getBtnOmoguciPromene().setEnabled(false);
                break;
            case DETALJI:
                Pica p = (Pica) Sesija.getInstanca().vratiParametar("Pica");
                List<KolicinaSastojka> kolicine = p.getKolicinaSastojaka();
                ModelTabeleKolicinaSastojka model1 = new ModelTabeleKolicinaSastojka(kolicine);
                kreirajP.getTblSastojci().setModel(model1);

                try {
                    kreirajP.popuniKombo();
                } catch (Exception ex) {

                }

                for (KolicinaSastojka kol : kolicine) {

                    kreirajP.getCmbSastojci().removeItem(kol.getSastojak());
                }
                kreirajP.getTxtNazivPice().setText(p.getNazivPice());
                kreirajP.getTxtOpisPice().setText(p.getOpisPice());
                kreirajP.getTxtCena().setText(String.valueOf(p.getCena()));
                kreirajP.getTxtStanje().setText(String.valueOf(p.getStanje()));

                kreirajP.getTxtNazivPice().setEnabled(false);
                kreirajP.getTxtOpisPice().setEnabled(false);
                kreirajP.getTxtCena().setEnabled(false);
                kreirajP.getTxtStanje().setEnabled(false);

                kreirajP.getCmbSastojci().setEnabled(false);
                kreirajP.getTxtGramaza().setEnabled(false);
                kreirajP.getTblSastojci().setEnabled(false);
                kreirajP.getBtnDodajSastojak().setEnabled(false);
                kreirajP.getBtnObrisiSastojak().setEnabled(false);
                kreirajP.getBtnSacuvajPicu().setEnabled(false);
                kreirajP.getBtnIzmeniPicu().setEnabled(false);
                kreirajP.getBtnObrisiPicu().setEnabled(false);
                kreirajP.getBtnOmoguciPromene().setEnabled(true);
                break;

            case OMOGUCI_IZMENE:
                ModelTabeleKolicinaSastojka model2 = (ModelTabeleKolicinaSastojka) kreirajP.getTblSastojci().getModel();
                List<KolicinaSastojka> kolS = model2.getSastojak();
                double ukupno = 0;
                for (KolicinaSastojka ks : kolS) {
                    ukupno += ks.getKolicina();
                }
                if (ukupno == 100) {
                    kreirajP.getBtnDodajSastojak().setEnabled(false);
                } else {
                    kreirajP.getBtnDodajSastojak().setEnabled(true);
                }
                kreirajP.getTxtNazivPice().setEnabled(true);
                kreirajP.getTxtOpisPice().setEnabled(true);
                kreirajP.getTxtCena().setEnabled(true);
                kreirajP.getTxtStanje().setEnabled(true);

                kreirajP.getCmbSastojci().setEnabled(true);
                kreirajP.getTxtGramaza().setEnabled(true);
                kreirajP.getTblSastojci().setEnabled(true);
                kreirajP.getBtnObrisiSastojak().setEnabled(true);
                kreirajP.getBtnSacuvajPicu().setEnabled(false);
                kreirajP.getBtnIzmeniPicu().setEnabled(true);
                kreirajP.getBtnObrisiPicu().setEnabled(true);
                kreirajP.getBtnOmoguciPromene().setEnabled(false);

                break;
        }
    }

    public void pripremiIzgledRacun(NacinForme frmMod) {
        switch (frmMod) {
            case KREIRAJ:
                popuniDefaultVrednosti();
                ModelTabeleStavkaRacuna model = new ModelTabeleStavkaRacuna(new ArrayList<>());
                kreirajR.getTblStavke().setModel(model);
                kreirajR.getBtnDodaj().setEnabled(true);
                kreirajR.getBtnObrisi().setEnabled(true);
                kreirajR.getBtnSacuvaj().setEnabled(true);
                kreirajR.getBtnObradi().setEnabled(false);
                kreirajR.getBtnStorniraj().setEnabled(false);
                kreirajR.getBtnOmoguciPromene().setEnabled(false);
                break;
            case DETALJI:
                popuniFormuVrednostima();
                kreirajR.getTxtBrojRacuna().setEnabled(false);
                kreirajR.getTxtDatum().setEnabled(false);
                kreirajR.getTxtKolicina().setEnabled(false);
                kreirajR.getCmbPice().setEnabled(false);
                kreirajR.getTblStavke().setEnabled(false);
                kreirajR.getBtnDodaj().setEnabled(false);
                kreirajR.getBtnObrisi().setEnabled(false);
                kreirajR.getBtnSacuvaj().setEnabled(false);
                kreirajR.getBtnObradi().setEnabled(false);
                kreirajR.getBtnStorniraj().setEnabled(false);
                kreirajR.getBtnOmoguciPromene().setEnabled(true);
                break;
            case OMOGUCI_IZMENE:
                kreirajR.getBtnObradi().setEnabled(true);
                kreirajR.getBtnStorniraj().setEnabled(true);
                kreirajR.getBtnOmoguciPromene().setEnabled(false);
                break;
        }
    }

    private void popuniDefaultVrednosti() {
        kreirajR.getTxtBrojRacuna().setText("");
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
        String danasnjiDatum = df.format(new Date());
        kreirajR.getTxtDatum().setText(danasnjiDatum);
        kreirajR.getTxtUkupnaVrednost().setText("0.0");
    }

    public FrmKreirajRacun getKreirajR() {
        return kreirajR;
    }

    public void setKreirajR(FrmKreirajRacun kreirajR) {
        this.kreirajR = kreirajR;
    }

    private void popuniFormuVrednostima() {
        Racun r = (Racun) Sesija.getInstanca().vratiParametar("Racun");
        kreirajR.getTxtBrojRacuna().setText(r.getBrojRacuna());
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
        kreirajR.getTxtDatum().setText(df.format(r.getDatum()));
        kreirajR.getTxtUkupnaVrednost().setText(String.valueOf(r.getUkupnaVrednost()));
        ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna(r.getListaStavki());
        kreirajR.getTblStavke().setModel(mts);
    }

    public Korisnik getK() {
        return k;
    }

    public void setK(Korisnik k) {
        this.k = k;
    }

    public FrmKreirajPicu getKreirajP() {
        return kreirajP;
    }

    public void setKreirajP(FrmKreirajPicu kreirajP) {
        this.kreirajP = kreirajP;
    }

}
