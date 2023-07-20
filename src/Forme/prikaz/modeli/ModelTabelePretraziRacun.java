/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz.modeli;

import domen.Racun;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class ModelTabelePretraziRacun extends AbstractTableModel {

    private final List<Racun> listaRacuna;

    private final String[] kolone = new String[]{"Broj računa", "Datum", "Ukupna vrednost", "Obrađen", "Storniran", "Zaposleni"};

    public ModelTabelePretraziRacun(List<Racun> listaRacuna) {
        this.listaRacuna = listaRacuna;
    }

    @Override
    public int getRowCount() {
        return listaRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r = listaRacuna.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return r.getBrojRacuna();
            case 1:
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                return df.format(r.getDatum());
            case 2:
                return r.getUkupnaVrednost();
            case 3:
                if (r.isObradjen()) {
                    return "Da";
                } else {
                    return "Ne";
                }

            case 4:
                if (r.isStorniran()) {
                    return "Da";
                } else {
                    return "Ne";
                }
            case 5:
                return r.getKorisnik();

            default:
                return "n/a";

        }
    }

    public Racun vratiRacun(int row) {
        return listaRacuna.get(row);
    }

    
    public List<Racun> vratiListu(){
        return listaRacuna;
    }
}
