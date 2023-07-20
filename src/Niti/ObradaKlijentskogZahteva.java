/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niti;

import Kontroler.Controller;
import domen.Sastojak;
import domen.Korisnik;
import domen.Pica;
import domen.Racun;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * 
 */
public class ObradaKlijentskogZahteva extends Thread {

    Socket s;
    private final Posiljalac posiljalac;
    private final Primalac primalac;

    public ObradaKlijentskogZahteva(Socket s) {
        this.s = s;
        posiljalac = new Posiljalac(s);
        primalac = new Primalac(s);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Zahtev z = (Zahtev) primalac.primi();
                Odgovor o = new Odgovor();
                try {
                    switch (z.getOperacija()) {
                        
                        case PRIJAVI_SE:
                            Korisnik k = (Korisnik) z.getPodaci();
                            k = Controller.getInstance().prijaviSe(k.getKorisnickoIme(), k.getSifra(), s);
                            o.setRezultat(k);
                            break;
                            
                        case KREIRAJ_NALOG:
                            Korisnik k2 = (Korisnik) z.getPodaci();
                            Controller.getInstance().kreirajNalog(k2);
                            o.setRezultat("");
                            break;
                            
                        case VRATI_LISTU_SASTOJAKA:
                            List<Sastojak> lista = Controller.getInstance().vratiListuSastojaka();
                            o.setRezultat(lista);
                            break;
                            
                        case IZBRISI_PICU:
                            Pica p = (Pica) z.getPodaci();
                            Controller.getInstance().obrisiPicu(p);
                            break;
                            
                        case SACUVAJ_PICU:
                            Pica p2 = (Pica) z.getPodaci();
                            Controller.getInstance().sacuvajPicu(p2);
                            break;
                            
                        case PRONADJI_PICE:
                            String uslov = (String) z.getPodaci();
                            Pica p3 = new Pica();
                            p3.setPretrazi(uslov);
                            List<Pica> listaPica = Controller.getInstance().pretraziPice(p3);
                            o.setRezultat(listaPica);
                            break;
                            
                        case IZMENI_PICU:
                            Pica p4 = (Pica) z.getPodaci();
                            Controller.getInstance().izmeniPicu(p4);
                            break;
                            
                        case UCITAJ_SVE_PICE:
                            List<Pica> listaPica1 = Controller.getInstance().ucitajListuPica();
                            o.setRezultat(listaPica1);
                            break;
                            
                        case SACUVAJ_RACUN:
                            Racun r = (Racun) z.getPodaci();
                            Controller.getInstance().sacuvajRacun(r);
                           
                            break;
                        case VRATI_SVE_RACUNE:
                            List<Racun> racuni = Controller.getInstance().vratiSveRacune();
                            o.setRezultat(racuni);
                            break;
                        case OBRADI_RACUN:
                            Racun r1 = (Racun) z.getPodaci();
                            Controller.getInstance().obradiRacun(r1);
                            break;
                        case STORNIRAJ_RACUN:
                            Racun r2 = (Racun) z.getPodaci();
                            Controller.getInstance().stornirajRacun(r2);
                            break;
                        case PRETRAZI_RACUNE:
                            String pretraga = (String) z.getPodaci();
                            Racun racun = new Racun();
                            racun.setPretraga(pretraga);
                            List<Racun> racuni1 = Controller.getInstance().pretraziRacune(racun);
                            o.setRezultat(racuni1);
                            break;
                        case PROVERI_SERVER:
                            boolean vr=Controller.getInstance().proveriServer();
                            o.setRezultat(vr);
                            break;
                            
                        case ODJAVI_SE:
                            Controller.getInstance().odjaviSe((Korisnik) z.getPodaci());
                            o.setRezultat("");
                            break;
             
                            
                    }
                    
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                    o.setException(ex.getMessage());
                }
                posiljalac.posalji(o);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

}
