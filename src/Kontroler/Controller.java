/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Niti.PokretanjeServera;
import Operacija.korisnik.KreirajNalog;
import Operacija.korisnik.PrijaviSe;
import Operacija.sastojak.VratiListuSastojaka;
import Operacija.pica.IzbrisiPicu;
import Operacija.pica.IzmeniPicu;
import Operacija.pica.PronadjiPicu;
import Operacija.pica.SacuvajPicu;
import Operacija.pica.UcitajSvePice;
import Operacija.racun.ObradiRacun;
import Operacija.racun.PronadjiRacune;
import Operacija.racun.SacuvajRacun;
import Operacija.racun.StornirajRacun;
import Operacija.racun.UcitajRacune;
import domen.Sastojak;
import domen.Korisnik;
import domen.Pica;
import domen.Racun;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 
 */
public class Controller {

    private static Controller instance;

    private PokretanjeServera pokretanjeServera;

    private final Map<Korisnik, Socket> aktivni;

    private Controller() {
        aktivni = new HashMap<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void pokreniServer() {
        pokretanjeServera = new PokretanjeServera();
        pokretanjeServera.start();
    }

    public void zaustaviServer() {
        pokretanjeServera.zaustaviServer();
    }

    public Korisnik prijaviSe(String korisnickoIme, String sifra, Socket socket) throws Exception {
        PrijaviSe prijava = new PrijaviSe();
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        prijava.izvrsi(korisnik);
        korisnik = prijava.getKorisnik();
        if (aktivni.containsKey(korisnik)) {
            throw new Exception("Korisnik je vec prijavljen na sistem!");
        }
        aktivni.put(korisnik, socket);
        return korisnik;
    }

    public void kreirajNalog(Korisnik korisnik) throws Exception {
        KreirajNalog operacija = new KreirajNalog();
        
        
        operacija.izvrsi(korisnik);
    }

    public List<Sastojak> vratiListuSastojaka() throws Exception {
        VratiListuSastojaka operacija = new VratiListuSastojaka();
        operacija.izvrsi(new Sastojak());
        List<Sastojak> lista = operacija.getListaSastojaka();
        return lista;

    }

    public void sacuvajPicu(Pica p) throws Exception {
        SacuvajPicu operacija = new SacuvajPicu();
        operacija.izvrsi(p);
    }

    public List<Pica> ucitajListuPica() throws Exception {
        UcitajSvePice operacija = new UcitajSvePice();
        operacija.izvrsi(new Pica());
        return operacija.getListaPica();
    }

    public List<Pica> pretraziPice(Pica pica) throws Exception {
        PronadjiPicu operacija = new PronadjiPicu();
        operacija.izvrsi(pica);
        return operacija.getListaPica();
    }

    public void obrisiPicu(Pica p) throws Exception {
        IzbrisiPicu operacija = new IzbrisiPicu();
        operacija.izvrsi(p);
    }

    public void izmeniPicu(Pica pica) throws Exception {
        IzmeniPicu operacija = new IzmeniPicu();
        operacija.izvrsi(pica);
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        SacuvajRacun operacija = new SacuvajRacun();
        operacija.izvrsi(racun);
    }

    public List<Racun> vratiSveRacune() throws Exception {
        UcitajRacune operacija = new UcitajRacune();
        operacija.izvrsi(new Racun());
        return operacija.getListaRacuna();
    }

    public void obradiRacun(Racun racun1) throws Exception {
        ObradiRacun operacija = new ObradiRacun();
        operacija.izvrsi(racun1);
    }

    public void stornirajRacun(Racun racun2) throws Exception {
        StornirajRacun operacija = new StornirajRacun();
        operacija.izvrsi(racun2);
    }

    public List<Racun> pretraziRacune(Racun racun) throws Exception {
        PronadjiRacune operacija = new PronadjiRacune();
        operacija.izvrsi(racun);
        return operacija.getListaRacuna();
    }

    public void odjaviSe(Korisnik korisnik) throws Exception {
        aktivni.remove(korisnik);
    }

    public boolean proveriServer() throws Exception {
        if (!pokretanjeServera.isAlive()) {
            return false;
        }
        return true;
    }

   

}
