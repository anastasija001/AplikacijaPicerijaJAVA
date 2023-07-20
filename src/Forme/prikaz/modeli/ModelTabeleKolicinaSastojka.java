/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz.modeli;

import domen.KolicinaSastojka;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class ModelTabeleKolicinaSastojka extends AbstractTableModel{
    
    
    private final List<KolicinaSastojka> kolicine;
    
    private final String[] kolone = new String[]{"Naziv sastojka", "Iznos u gramima"};

    public ModelTabeleKolicinaSastojka(List<KolicinaSastojka> kolicine) {
        this.kolicine = kolicine;
    }
    
    @Override
    public int getRowCount() {
        return kolicine.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KolicinaSastojka ks = kolicine.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return ks.getSastojak().getNazivSastojka();
            case 1:
                return ks.getKolicina();
            default:
                return "";
        }
    }

    public List<KolicinaSastojka> getSastojak() {
        return kolicine;
    }

    public void dodajSastojak(KolicinaSastojka ks) {
        kolicine.add(ks);
        fireTableRowsInserted(kolicine.size() - 1, kolicine.size() - 1);
    }

    public void obrisiSastojak(int red) {
        kolicine.remove(red);
        fireTableDataChanged();
    }
    
}
