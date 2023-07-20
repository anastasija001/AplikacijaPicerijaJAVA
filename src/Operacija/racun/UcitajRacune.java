/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.racun;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Racun;
import domen.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class UcitajRacune extends ApstraktnaGenerickaOperacija {

    List<Racun> listaRacuna = new ArrayList<>();

    @Override
    protected void preduslovi(Object parametar) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        listaRacuna = skladiste.vratiSve((Racun) parametar);
        for (Racun racun : listaRacuna) {
            StavkaRacuna stavka = new StavkaRacuna();
            stavka.setPretraga(String.valueOf(racun.getRacunID()));
            List<StavkaRacuna> stavke = skladiste.pretrazi(stavka);
            racun.setListaStavki(stavke);
        }
    }

    public List<Racun> getListaRacuna() {
        return listaRacuna;
    }

}
