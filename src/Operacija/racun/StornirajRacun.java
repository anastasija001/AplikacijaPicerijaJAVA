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

/**
 *
 * 
 */
public class StornirajRacun extends ApstraktnaGenerickaOperacija {
    
    @Override
    protected void preduslovi(Object parametar) throws Exception {
        
    }
    
    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        Racun racun = (Racun) parametar;
        skladiste.izmeni(racun);
        for (StavkaRacuna stavkaRacuna : racun.getListaStavki()) {
            List<Pica> listaPica = skladiste.vratiSveSaUslovom(stavkaRacuna.getPica());
            Pica pica = listaPica.get(0);
            pica.setStanje(pica.getStanje() + stavkaRacuna.getKolicina());
            skladiste.izmeni(pica);
        }
    }
    
}
