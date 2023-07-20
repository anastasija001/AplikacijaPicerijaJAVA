/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.pica;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Pica;

/**
 *
 * 
 */
public class IzbrisiPicu extends ApstraktnaGenerickaOperacija {
    
    @Override
    protected void preduslovi(Object parametar) throws Exception {
        if (parametar == null || !(parametar instanceof Pica)) {
            throw new Exception("Greska pri brisanju pice!");
        }
        
    }
    
    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        skladiste.obrisi((Pica) parametar);
    }
    
}
