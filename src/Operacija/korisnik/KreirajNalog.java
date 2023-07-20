/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.korisnik;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Korisnik;
import java.util.List;

/**
 *
 * 
 */
public class KreirajNalog extends ApstraktnaGenerickaOperacija {
    
    @Override
    protected void preduslovi(Object parametar) throws Exception {
        List<Korisnik> listaKorisnika = skladiste.vratiSve((Korisnik) parametar);
        Korisnik korisnik = (Korisnik) parametar;
        for (Korisnik korisnik1 : listaKorisnika) {
            if (korisnik1.getKorisnickoIme().equalsIgnoreCase(korisnik.getKorisnickoIme())) {
            throw new Exception("Korisnik sa unetim korisnickim imenom vec postoji u bazi!");
        }
        
            
        }
    }
    
    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        skladiste.sacuvaj(parametar);
    }
    
}
