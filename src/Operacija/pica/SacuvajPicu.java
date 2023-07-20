/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.pica;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Pica;
import domen.KolicinaSastojka;
import java.util.List;

/**
 *
 * 
 */
public class SacuvajPicu extends ApstraktnaGenerickaOperacija {
    
    @Override
    protected void preduslovi(Object parametar) throws Exception {
        if (parametar == null || !(parametar instanceof Pica)) {
            throw new Exception("Greska pri cuvanju pice!");
        }
        Pica pica = (Pica) parametar;
        List<Pica> pice = skladiste.vratiSve(pica);
        for (Pica p : pice) {
            if (p.getNazivPice().equals(pica.getNazivPice())) {
                throw new Exception("Naziv pice mora biti jedinstven!");
            }
        }
    }
    
    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        Pica pica = (Pica) parametar;
        skladiste.sacuvaj(pica);
        List<KolicinaSastojka> listaMaterije = pica.getKolicinaSastojaka();
        for (KolicinaSastojka k : listaMaterije) {
            k.setPica(pica);
            skladiste.sacuvaj(k);
        }
        
    }
    
}
