/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.pica;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Pica;
import domen.KolicinaSastojka;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * 
 */
public class PronadjiPicu extends ApstraktnaGenerickaOperacija {

    List<Pica> listaPica = new ArrayList<>();
    
    @Override
    protected void preduslovi(Object parametar) throws Exception {
     
    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
       listaPica = skladiste.pretrazi((Pica) parametar);
        for (Pica p : listaPica) {
            KolicinaSastojka kolicinaSastojka = new KolicinaSastojka();
            kolicinaSastojka.setPretraga(String.valueOf(p.getPicaID()));
            List<KolicinaSastojka> kolicine = skladiste.pretrazi(kolicinaSastojka);
            p.setKolicinaSastojaka(kolicine);
        }
       
    }

    public List<Pica> getListaPica() {
        return listaPica;
    }
    
    
    
}
