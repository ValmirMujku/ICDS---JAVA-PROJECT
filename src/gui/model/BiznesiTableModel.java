/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Biznesi;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class BiznesiTableModel extends AbstractTableModel{
    List<Biznesi> list;
    String[] columns = {"ID", "Emri", "Lloji", "Qyteti", "Komuna"};

    public BiznesiTableModel() {
    }

    public BiznesiTableModel(List<Biznesi> list) {
        this.list = list;
    }

    public void add(List<Biznesi> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public Biznesi getBiznesi(int i) {
        return list.get(i);
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Biznesi b = getBiznesi(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getBiznesiID();
            case 1:
                return b.getEmri();
            case 2:
                return b.getLloji();
            case 3:
                return b.getQyteti();
            case 4:
                return b.getKomuna();
             default:
                 return null;
        }
    }
}
