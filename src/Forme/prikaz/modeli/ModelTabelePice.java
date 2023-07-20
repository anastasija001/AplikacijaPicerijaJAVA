/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.prikaz.modeli;

import domen.Pica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class ModelTabelePice extends AbstractTableModel{
    
    private final List<Pica> pice;
    
    private final String[] kolone = new String[]{"Naziv pice", "Cena", "Stanje"};

    public ModelTabelePice(List<Pica> pice) {
        this.pice = pice;
    } 
    @Override
    public int getRowCount() {
        return pice.size();
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
        Pica p = pice.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return p.getNazivPice();
            case 1:
                return p.getCena();
            case 2:
                return p.getStanje();
            default:
                return "";
        }
    }

    public List<Pica> getPice() {
        return pice;
    }

    public void obrisiPicu(Pica pica) {
        pice.remove(pica);
        fireTableDataChanged();
    }

    public void dodajPicu(Pica pica) {
        pice.add(pica);
        fireTableDataChanged();
    }
    
    
}
