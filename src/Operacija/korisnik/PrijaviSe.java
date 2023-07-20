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
public class PrijaviSe extends ApstraktnaGenerickaOperacija {

    private Korisnik korisnik;

    @Override
    protected void preduslovi(Object parametar) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        List<Korisnik> listaKorisnika = skladiste.vratiSve((Korisnik) parametar);
        Korisnik k = (Korisnik) parametar;
        for (Korisnik k1 : listaKorisnika) {
            if (k.getKorisnickoIme().equals(k1.getKorisnickoIme()) && k.getSifra().equals(k1.getSifra())) {
                korisnik = k1;
                return;
            }
        }

        throw new Exception("Korisnik ne postoji u bazi!");

    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    
}
