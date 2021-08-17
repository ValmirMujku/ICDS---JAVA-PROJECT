/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Faktura;
import BLL.Komuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class KomunTable extends AbstractTableModel {

    public KomunTable() {
    }
    
    List<Komuna> lista;
    String[] kolonat = {"ID", "Komuna", "Qyteti"};

    public KomunTable(List<Komuna> lista) {
        this.lista = lista;
    }

    public void add(List<Komuna> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolonat.length;
    }

    public Komuna getKomuna(int i) {
        return lista.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Komuna k = getKomuna(rowIndex);
        switch(columnIndex){
            case 0:return k.getKId();
            case 1:return k.getEmri();
            case 2:return k.getQyteti();
            default:return 12;
        }
    }
    


}
