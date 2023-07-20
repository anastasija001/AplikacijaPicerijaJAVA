/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.racun;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Pica;
import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class SacuvajRacun extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object parametar) throws Exception {
        Racun racun = (Racun) parametar;
        List<Racun> racuni = skladiste.vratiSve(racun);
        for (Racun r : racuni) {
            if (r.getBrojRacuna().equals(racun.getBrojRacuna())) {
                throw new Exception("Broj računa mora biti jedinstven!");
            }
        }
    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        Racun racun = (Racun) parametar;
        skladiste.sacuvaj(racun);
        String poruka = "";
        for (StavkaRacuna stavka : racun.getListaStavki()) {
            
            stavka.setR(racun);
            skladiste.sacuvaj(stavka);
            List<Pica> pice = skladiste.vratiSveSaUslovom(stavka.getPica());
            Pica pica = pice.get(0);
            int stanje = pica.getStanje();
            if (stanje == 0 || stanje - stavka.getKolicina() < 0) {
                poruka += "Na stanju nema dovoljno pica " + pica.getNazivPice() + "!\n";
                System.out.println("Izvrsi operaciju");
            }
            if (poruka.isEmpty()) {
                pica.setStanje(pica.getStanje() - stavka.getKolicina());
                skladiste.izmeni(pica);
                System.out.println("izmena kolicine pice");
            }
        }
        if (!poruka.isEmpty()) {
            JOptionPane.showMessageDialog(null, poruka, "Greška", JOptionPane.ERROR_MESSAGE);
            //throw new Exception(poruka);
        }
    }

}
