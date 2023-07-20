/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.sastojak;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Sastojak;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class VratiListuSastojaka extends ApstraktnaGenerickaOperacija{

    private List<Sastojak> listaSastojaka = new ArrayList<>();
    
    
    @Override
    protected void preduslovi(Object parametar) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
       listaSastojaka = skladiste.vratiSve((Sastojak) parametar);
    }

    public List<Sastojak> getListaSastojaka() {
        return listaSastojaka;
    }
    
    
    
    
}
