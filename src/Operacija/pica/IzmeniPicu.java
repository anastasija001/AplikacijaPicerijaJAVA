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
public class IzmeniPicu extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object parametar) throws Exception {
        if (parametar == null || !(parametar instanceof Pica)) {
            throw new Exception("Greska kod izmene pice");
        }

        Pica p = (Pica) parametar;
        List<Pica> listaPica = skladiste.vratiSve(parametar);

        for (Pica pica : listaPica) {
            if (!(pica.getPicaID().equals(p.getPicaID())) && pica.getNazivPice().equals(p.getNazivPice())) {
                throw new Exception("Pica mora imati jedinstveni naziv");
            }
        }

    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        Pica p = (Pica) parametar;
        List<KolicinaSastojka> ks1 = p.getKolicinaSastojaka();
        
        KolicinaSastojka kolicina = new KolicinaSastojka();
        
        kolicina.setPretraga(String.valueOf(p.getPicaID()));
        
        List<KolicinaSastojka> ks2 = skladiste.pretrazi(kolicina);
        
        
        for (KolicinaSastojka k1 : ks2) {
            System.out.println(k1.getSastojak().getSastojakID() + " " + k1.getPica().getPicaID());
            skladiste.obrisi(k1);
        }
        for (KolicinaSastojka k2 : ks1) {
            k2.setPica(p);
            skladiste.sacuvaj(k2);
        }
        skladiste.izmeni(p);
    }

}
