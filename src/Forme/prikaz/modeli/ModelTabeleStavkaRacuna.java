/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz.modeli;

import domen.StavkaRacuna;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class ModelTabeleStavkaRacuna extends AbstractTableModel {

    private final List<StavkaRacuna> listaStavki;

    private final String[] kolone = new String[]{"RB", "Pica", "Cena", "Količina", "Ukupno"};

    public ModelTabeleStavkaRacuna(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "RB";
            case 1:
                return "Pica";
            case 2:
                return "Cena";
            case 3:
                return "Količina";
            case 4:
                return "Ukupno";

            default:
                return "n/a";

        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr = listaStavki.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sr.getRBStavke();
            case 1:
                return sr.getPica();
            case 2:
                return sr.getPica().getCena().setScale(2,RoundingMode.HALF_UP);
            case 3:
                return sr.getKolicina();
            case 4:
                return sr.getUkupnaCena();

            default:
                return "n/a";
        }
    }

    public BigDecimal dodajStavku(StavkaRacuna stavka) {
        dodajRedniBroj(stavka);
        listaStavki.add(stavka);
        fireTableRowsInserted(listaStavki.size() - 1, listaStavki.size() - 1);
       // fireTableDataChanged();
        return izracunajUkupno();
    }

    private void dodajRedniBroj(StavkaRacuna stavka) {
        stavka.setRBStavke(listaStavki.size() + 1);
    }

    private BigDecimal izracunajUkupno() {
        BigDecimal ukupno = new BigDecimal(0);
        for (StavkaRacuna stavkaRacuna : listaStavki) {
            ukupno = ukupno.add(stavkaRacuna.getUkupnaCena());
        }
        return ukupno;
    }

    public BigDecimal obrisiStavku(int red) {
        listaStavki.remove(red);
        presloziRedneBrojeve();
        fireTableDataChanged();
        return izracunajUkupno();
    }

    private void presloziRedneBrojeve() {
        for (int i = 0; i < listaStavki.size(); i++) {
            listaStavki.get(i).setRBStavke(i + 1);
        }
    }

    public StavkaRacuna vratiStavku(int row) {
        return listaStavki.get(row);
    }

    public List<StavkaRacuna> getStavke() {
        return listaStavki;
    }
  
}
