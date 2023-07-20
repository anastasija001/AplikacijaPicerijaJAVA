/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.Korisnik;
import domen.Pica;
import domen.Sastojak;
import domen.Racun;
import domen.StavkaRacuna;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Komunikacija {

    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instanca;

    public static Komunikacija getInstanca() throws IOException {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }

    public Komunikacija() {
        try {
            soket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Korisnik prijaviSe(String korisnickoIme, String sifra) throws Exception {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        Zahtev zahtev = new Zahtev(Operacija.PRIJAVI_SE, korisnik);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {
            return (Korisnik) odgovor.getRezultat();
        } else {
            throw new Exception("" + odgovor.getException());
        }
    }

    public void kreirajNalog(Korisnik k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.KREIRAJ_NALOG, k);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {

        } else {
            throw new Exception("" + odgovor.getException());
        }
    }

    public List<Sastojak> ucitajListuSastojaka() throws Exception {
        Zahtev zahtev = new Zahtev();
        zahtev.setOperacija(Operacija.VRATI_LISTU_SASTOJAKA);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {
            return (List<Sastojak>) odgovor.getRezultat();
        } else {
            throw new Exception("" + odgovor.getException());
        }
    }

    public void sacuvajPicu(Pica p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.SACUVAJ_PICU, p);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {

        } else {
            throw new Exception("" + odgovor.getException());
        }
    }

    public List<Pica> prikaziPicu() throws Exception {
        Zahtev zahtev = new Zahtev();
        zahtev.setOperacija(Operacija.UCITAJ_SVE_PICE);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {
            return (List<Pica>) odgovor.getRezultat();
        } else {
            throw new Exception("" + odgovor.getException());
        }
    }

    public List<Pica> pretraziPicu(String pretrazi) throws Exception {
        Zahtev zahtev = new Zahtev();
        zahtev.setOperacija(Operacija.PRONADJI_PICE);
        zahtev.setPodaci(pretrazi);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {
            return (List<Pica>) odgovor.getRezultat();
        } else {
            throw new Exception("" + odgovor.getException());
        }
    }

    public List<Racun> prikaziRacune() throws Exception {
        Zahtev z = new Zahtev();
        z.setOperacija(Operacija.VRATI_SVE_RACUNE);
        posiljalac.posalji(z);
        Odgovor o = (Odgovor) primalac.primi();
        if (o.getException() == null) {
            return (List<Racun>) o.getRezultat();
        } else {
            throw new Exception(o.getException());
        }
    }

    public List<Racun> pretraziRacune(String uslovZaPretragu) throws Exception {
        Zahtev z = new Zahtev();
        z.setOperacija(Operacija.PRETRAZI_RACUNE);
        z.setPodaci(uslovZaPretragu);
        posiljalac.posalji(z);
        Odgovor o = (Odgovor) primalac.primi();
        if (o.getException() == null) {
            return (List<Racun>) o.getRezultat();
        } else {
            throw new Exception(o.getException());
        }
    }

    public List<StavkaRacuna> pretraziStavkaRacuna(String uslovZaPretragu) throws Exception {
        Zahtev z = new Zahtev();
        z.setOperacija(Operacija.PRETRAZI_RACUNE);
        z.setPodaci(uslovZaPretragu);
        posiljalac.posalji(z);
        Odgovor o = (Odgovor) primalac.primi();
        if (o.getException() == null) {
            return (List<StavkaRacuna>) o.getRezultat();
        } else {
            throw new Exception(o.getException());
        }
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        Zahtev z = new Zahtev(Operacija.SACUVAJ_RACUN, racun);
        posiljalac.posalji(z);
        Odgovor o = (Odgovor) primalac.primi();
        if (o.getException() == null) {

        } else {

            throw new Exception(o.getException());
        }

    }

    public Socket odjaviSe(Korisnik korisnik) throws Exception {
        Zahtev z = new Zahtev(Operacija.ODJAVI_SE, korisnik);
        posiljalac.posalji(z);
        Odgovor o = (Odgovor) primalac.primi();
        if (o.getException() == null) {
            return soket;
        } else {
            throw new Exception(o.getException());
        }
    }

    public void obrisiPicu(Pica p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_PICU, p);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {

        } else {
            throw new Exception(odgovor.getException());
        }
    }

    public void izmeniPicu(Pica p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.IZMENI_PICU, p);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {

        } else {
            throw new Exception(odgovor.getException());
        }
    }

    public void obradiRacun(Racun racun) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRADI_RACUN, racun);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {

        } else {
            throw new Exception(odgovor.getException());
        }
    }

    public void stornirajRacun(Racun racun) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.STORNIRAJ_RACUN, racun);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getException() == null) {

        } else {
            throw new Exception(odgovor.getException());
        }
    }

    public boolean proveriServer() throws Exception {
        Zahtev zahtev = new Zahtev();
        zahtev.setOperacija(Operacija.PROVERI_SERVER);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        return (boolean) odgovor.getRezultat();

    }

    

}
